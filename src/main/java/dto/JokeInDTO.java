/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 * This is a representation of a joke coming from 
 * https://api.chucknorris.io/jokes/random?category=food
 * @author Malte
 */
public class JokeInDTO {
/*
 * Example of a response from joke API. 
 * {"categories":["food"],
 * "created_at":"2020-01-05 13:42:19.576875",
 * "icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png",
 * "id":"muujj6xvr16hazym0b5tjw",
 * "updated_at":"2020-01-05 13:42:19.576875",
 * "url":"https://api.chucknorris.io/jokes/muujj6xvr16hazym0b5tjw",
 * "value":"When Chuck Norris was a baby, he didn't suck his mother's breast. His mother served him whiskey, straight out of the bottle."}
 */
    /*
    {"categories":["food"],
    "created_at":"2020-01-05 13:42:23.240175",
    "icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png",
    "id":"zW8KKcrRRoOJ1cW_2m6VaQ","updated_at":"2020-01-05 13:42:23.240175","url":"https://api.chucknorris.io/jokes/zW8KKcrRRoOJ1cW_2m6VaQ","value":"There are more than 1 billion Chinese people throughout the world because Chuck Norris likes Chinese food."}
    */
    private String created_at, icon_url, id, updated_at, url, value;
    private String[] categories;

    public JokeInDTO() {
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
