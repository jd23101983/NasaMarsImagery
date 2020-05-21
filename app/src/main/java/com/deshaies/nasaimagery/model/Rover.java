
package com.deshaies.nasaimagery.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rover {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("landing_date")
    @Expose
    private String landingDate;
    @SerializedName("launch_date")
    @Expose
    private String launchDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("max_sol")
    @Expose
    private Long maxSol;
    @SerializedName("max_date")
    @Expose
    private String maxDate;
    @SerializedName("total_photos")
    @Expose
    private Long totalPhotos;
    @SerializedName("cameras")
    @Expose
    private List<Camera_> cameras = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLandingDate() {
        return landingDate;
    }

    public void setLandingDate(String landingDate) {
        this.landingDate = landingDate;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getMaxSol() {
        return maxSol;
    }

    public void setMaxSol(Long maxSol) {
        this.maxSol = maxSol;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    public Long getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(Long totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public List<Camera_> getCameras() {
        return cameras;
    }

    public void setCameras(List<Camera_> cameras) {
        this.cameras = cameras;
    }

}
