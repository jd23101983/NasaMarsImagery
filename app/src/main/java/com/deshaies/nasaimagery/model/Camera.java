
package com.deshaies.nasaimagery.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Camera {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rover_id")
    @Expose
    private Long roverId;
    @SerializedName("full_name")
    @Expose
    private String fullName;

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

    public Long getRoverId() {
        return roverId;
    }

    public void setRoverId(Long roverId) {
        this.roverId = roverId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
