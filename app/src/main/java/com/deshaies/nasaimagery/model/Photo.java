
package com.deshaies.nasaimagery.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("sol")
    @Expose
    private Long sol;
    @SerializedName("camera")
    @Expose
    private Camera camera;
    @SerializedName("img_src")
    @Expose
    private String imgSrc;
    @SerializedName("earth_date")
    @Expose
    private String earthDate;
    @SerializedName("rover")
    @Expose
    private Rover rover;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSol() {
        return sol;
    }

    public void setSol(Long sol) {
        this.sol = sol;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

}
