package tut.ac.za.tvep.classes;

import java.io.Serializable;

/**
 * Created by mlab on 2017/07/01.
 */

public class Message implements Serializable {


    private String message;
    private String email;
    private  String date;
    private String audio;
    private String tvepEmail;
    private String userEmail;



    public Message()
    {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }


    public String getTvepEmail() {
        return tvepEmail;
    }

    public void setTvepEmail(String tvepEmail) {
        this.tvepEmail = tvepEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
