package tut.ac.za.tvep.classes;

import java.io.Serializable;

/**
 * Created by mlab on 2017/06/13.
 */

public class FeedBack implements Serializable {

    private String subject;
    private String comment;

    public FeedBack()
    {
        super();
    }

    public void setSubject(String subject)
    {
        this.subject =subject;
    }

    public void setComment(String comment)
    {
        this.comment =comment;
    }


    public String getSubject()
    {
        return  this.subject;
    }


    public String getComment()
    {

        return  this.comment;
    }

}
