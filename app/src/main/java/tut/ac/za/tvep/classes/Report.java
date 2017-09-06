package tut.ac.za.tvep.classes;

import java.io.Serializable;

/**
 * Created by mlab on 2017/06/13.
 */

public class Report implements Serializable {

    private String subject;
    private String description;
    private Area area;
    private String email;

    public Report()
    {
        super();
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getDescription()
    {
        return  this.description;
    }



    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
