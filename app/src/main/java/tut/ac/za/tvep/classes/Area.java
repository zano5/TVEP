package tut.ac.za.tvep.classes;

import java.io.Serializable;

/**
 * Created by mlab on 2017/07/01.
 */

public class Area implements Serializable {


    private String areaName;
    private String areaAddress;


    public Area() {
        super();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(String areaAddress) {
        this.areaAddress = areaAddress;
    }
}
