package com.spartanwrath.model;

import java.util.Date;

public class Gym {
    private Integer id;
    private String name;
    private String activity;
    private String type;
    private Date activityhour;
    private String description;
    private String image;

    public Gym() {
    }

    public Gym(Integer id, String name, String activity, String type, Date activityhour, String description, String image) {
        this.id = id;
        this.name = name;
        this.activity = activity;
        this.type = type;
        this.activityhour = activityhour;
        this.description = description;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getActivityhour() {
        return activityhour;
    }

    public void setActivityhour(Date activityhour) {
        this.activityhour = activityhour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Gym{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activity='" + activity + '\'' +
                ", type='" + type + '\'' +
                ", activityhour=" + activityhour +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}