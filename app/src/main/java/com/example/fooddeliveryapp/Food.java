package com.example.fooddeliveryapp;

public class Food {
    private int resourceId;
    private String title;
     boolean isVisible;
    public Food(int resourceId, String title,boolean isVisible){
        this.resourceId=resourceId;
        this.title= title;
        this.isVisible= isVisible;
    }
    public int getResourceId(){
        return resourceId;
    }
    public void setResourceId(int resourceId){
        this.resourceId=resourceId;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
}
