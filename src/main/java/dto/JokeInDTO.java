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
    private String category, created_at, icon_url, id, updated_at, url, value;

    public JokeInDTO() {
    }

    public JokeInDTO(String category, String created_at, String icon_url, String id, String updated_at, String url, String value) {
        this.category = category;
        this.created_at = created_at;
        this.icon_url = icon_url;
        this.id = id;
        this.updated_at = updated_at;
        this.url = url;
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
