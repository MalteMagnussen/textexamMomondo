package facades;

import entities.RenameMe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    
    //Private Constructor to ensure Singleton
    private JokeFacade() {}
    
    private static List<String> acceptable_categories = new ArrayList<>();
    
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
            String[] categories = {"Career", "celebrity", "dev", "explicit", "fashion", "food", "history", "money", "movie", "music", "political", "science", "sport", "travel"};
            acceptable_categories.addAll(Arrays.asList(categories));
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    

}
