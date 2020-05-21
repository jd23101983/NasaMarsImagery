
package com.deshaies.nasaimagery.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NasaResult {

    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

}
