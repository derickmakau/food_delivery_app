package com.example.fooddeliveryapp;

public class search {
    private int resource;
    private  String titles;
    public search(int resource, String titles){
        this.resource=resource;
        this.titles= titles;

    }
    public int getResourceId(){

        return resource;
    }
    public void setResourceId(int resource){

        this.resource=resource;
    }
    public String getTitle(){

        return titles;
    }
    public void setTitle(String titles){

        this.titles=titles;
    }
}
