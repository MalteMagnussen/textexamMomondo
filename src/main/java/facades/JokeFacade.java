package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dto.CountDTO;
import dto.JokeDTO;
import dto.JokeInDTO;
import dto.JokeOutDTO;
import entities.Category;
import entities.Request;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import javafx.util.Pair;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/*
  Joke Facade.
 Implement this endpoint:
    api/jokeByCategory/{categories} 
    which when called like this: api/jokeByCategory/food,fashion,history   
 (the last part is just a comma-separated string ) should return a JSON-response like this:
{ 
   "jokes":[ 
      { "category":"food", "joke":"When Chuck Norris goes to out to eat...."},
      { "category":"fashion","joke":"Chuck Norris does not follow fashion trends..."},
      { "category":"history","joke":"After returning from World War 2 unscathed..." }
   ]
   "Reference" : "api.chucknorris.io"

}
These are the acceptable categories that can be supplied with the request: 
Career, celebrity, dev, explicit, fashion, food, history, money, movie, music, political, science, sport, travel
For this request, a maximum of 4 categories is allowed. If more is supplied, or a category is not valid, you should make a sensible error response.
See “How to get the data” at the end of this document for this information.

 */
public class JokeFacade {

    private static JokeFacade instance;
    private static EntityManagerFactory emf;

    private final String URI = "https://api.chucknorris.io/jokes/random?category=";

    private static final ExecutorService workingJack = Executors.newCachedThreadPool();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    //Private Constructor to ensure Singleton
    private JokeFacade() {
    }

    private static List<String> acceptable_categories = new ArrayList<>();

    /*
     
    INSERT INTO `testexamMomondo_base`.`CATEGORY`
(`NAME`)
VALUES
("Career"), ("celebrity"), ("dev"), ("explicit"), ("fashion"), ("food"), ("history"), ("money"), ("movie"), ("music"), 
("political"), ("science"), ("sport"), ("travel");

SELECT * FROM testexamMomondo_base.CATEGORY;
    
     */
    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static JokeFacade getJokeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        if (acceptable_categories.isEmpty()) {
            String[] categories = {"career", "celebrity", "dev", "explicit", "fashion", "food", "history", "money", "movie", "music", "political", "science", "sport", "travel"};
            acceptable_categories.addAll(Arrays.asList(categories));
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public JokeOutDTO getJoke(String categories, boolean permission) throws InterruptedException, ExecutionException, TimeoutException {
        List<String> categoriesList = handleString(categories, permission);
        try {
            return asyncGet(categoriesList);
        } finally {
            saveHistoricalData(categoriesList);
        }
    }

    private JokeOutDTO asyncGet(List<String> categoriesList) throws InterruptedException, ExecutionException {
        /*
        Get the Futures asynchronously.
         */
        Queue<Future<JokeInDTO>> queue = new ArrayBlockingQueue(categoriesList.size());
        for (String endpoint : categoriesList) {
            Future<JokeInDTO> future = workingJack.submit(() -> GSON.fromJson(doGetJson(endpoint), JokeInDTO.class));
            queue.add(future);
        }
        List<JokeInDTO> inJokes = new ArrayList();
        while (!queue.isEmpty()) {
            Future<JokeInDTO> future = queue.poll();
            if (future.isDone()) {
                inJokes.add(future.get());
            } else {
                queue.add(future);
            }
        }
        // Make JokeInDTO into a JokeOutDTO
        JokeOutDTO returnJoke = new JokeOutDTO();
        inJokes.forEach((j) -> {
            if (j == null) {
                throw new WebApplicationException("Joke is null.", Response.Status.BAD_REQUEST);
            }
            System.out.println(j);
            returnJoke.addJoke(new JokeDTO(j));
        });
        return returnJoke;
    }

    /**
     * Helper function
     */
    private String doGetJson(String search) {
        try {
            String URL = URI + search;
            URL url = new URL(URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json;charset=UTF-8");
            con.setRequestProperty("user-agent", "Application");
            String jsonStr = "";
            try (Scanner scan = new Scanner(con.getInputStream())) {
                while (scan.hasNext()) {
                    jsonStr += scan.nextLine();
                }
            }
            String result = GSON.fromJson(jsonStr, JsonObject.class).toString();
            return result;
        } catch (IOException ex) {
            return "{\"status\":400, \"message\":\"Bad Request\"}";
        }
    }

    /**
     * For this request, a maximum of 4 categories is allowed. If more is
     * supplied, or a category is not valid, you should make a sensible error
     * response A client makes this request (A in the figure) up against your
     * server: /jokeByCategory/food,fashion,history
     *
     * @param categories Example: "food,fashion,history"
     * @return List of the categories.
     */
    private List<String> handleString(String str, boolean permission) {

        if (str == null) {
            throw new WebApplicationException("Bad Request.", Response.Status.BAD_REQUEST);
        }

        List<String> categories = Arrays.asList(str.split(","));

        if (permission) {
            if (categories.size() > 12) {
                throw new WebApplicationException("Max 12 categories in request.", Response.Status.BAD_REQUEST);
            }
        } else {
            if (categories.size() > 4) {
                throw new WebApplicationException("Max 4 categories in request.", Response.Status.BAD_REQUEST);
            }
        }
        for (String s : categories) {
            if (!acceptable_categories.contains(s)) {
                throw new WebApplicationException("Category " + s + " does not exist.", Response.Status.BAD_REQUEST);
            }
        }

        return categories;

    }

    private void saveHistoricalData(List<String> categoriesList) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Request request = new Request();
            categoriesList.forEach((name) -> {
                request.addCategory(em.createNamedQuery("Category.getCategoryByName", Category.class).setParameter("name", name).getSingleResult());
            });
            em.persist(request);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public CountDTO getCategoryCount(String category) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Long count = em.createNamedQuery("Request.getCount", Long.class).setParameter("name", category).getSingleResult();
            CountDTO res = new CountDTO(category, count);
            em.getTransaction().commit();
            return res;
        } finally {
            em.close();
        }
    }

}
