package tut.ac.za.tvep.classes;

import java.io.Serializable;

/**
 * Created by mlab on 2017/07/02.
 */

public class Info implements Serializable {

    private String name;
    private String url;


    public Info()
    {
        super();
    }


    public Info(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
