
package com.deshaies.nasaimagery.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Camera_ {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private String fullName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
