/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Malte
 */
public class JokeDTO {
    /*
    Example
    "category":"food", "joke":"When Chuck Norris goes to out to eat...."
    */
    private String category, joke;

    public JokeDTO() {
    }

    public JokeDTO(JokeInDTO joke) {
        this.category = joke.getCategory();
        this.joke = joke.getValue();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
    
    
}
