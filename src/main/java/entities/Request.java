package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "Request.deleteAllRows", query = "DELETE FROM Request"),
    @NamedQuery(name = "Request.getCount", query = "SELECT count(request) FROM Request request WHERE :name MEMBER OF request.categories")
})
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "requests")
    private List<Category> categories;

    /*
    Time in Java is torture
    
    Date d = rs.getDate("date_column");
    Calendar c = Calendar.getInstance();
    c.setTime(d.getTime());
    int month = c.get(Calendar.MONTH);
    
     */
    // Timestamp is a reserved keyword.
    private Date timestamb;

    public Request() {
        this.categories = new ArrayList();
    }

    public Request(List<String> categories) {
        this.categories = new ArrayList();
        this.timestamb = new Date();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Date getTimestamb() {
        return timestamb;
    }

    public void setTimestamb(Date timestamb) {
        this.timestamb = timestamb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
