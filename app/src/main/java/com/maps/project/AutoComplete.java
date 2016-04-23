package com.maps.project;

/**
 * Created by suryaramadhon on 4/23/16.
 */
public class AutoComplete {
    private String description;
    private  String id;
    private String placeId;

    public AutoComplete(String description, String id, String placeId){
        this.setDescription(description);
        this.setId(id);
        this.setPlaceId(placeId);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
}
