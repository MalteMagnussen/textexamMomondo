/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Used for response to own frontend. 
 * @author Malte
 */
public class JokeOutDTO {
    /*
    Example
    { 
   "jokes":[ 
      { "category":"food", "joke":"When Chuck Norris goes to out to eat...."},
      { "category":"fashion","joke":"Chuck Norris does not follow fashion trends..."},
      { "category":"history","joke":"After returning from World War 2 unscathed..." }
   ]
   "Reference" : "api.chucknorris.io"
    }
    */
    
    private String Reference;
    private List<JokeDTO> jokes = new ArrayList();

    public JokeOutDTO() {
        this.Reference = "api.chucknorris.io";
    }
    
    public void addJoke(JokeDTO joke) {
        jokes.add(joke);
    }

    public String getReference() {
        return Reference;
    }

    public void setReference(String Reference) {
        this.Reference = Reference;
    }

    public List<JokeDTO> getJokes() {
        return jokes;
    }

    public void setJokes(List<JokeDTO> jokes) {
        this.jokes = jokes;
    }
    
    
    
}
