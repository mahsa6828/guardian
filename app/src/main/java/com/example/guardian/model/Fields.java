package com.example.guardian.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {
    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
