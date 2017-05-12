package com.example.shaimaalzahrani.habittrakersqlite;

/**
 * Created by shaimaalzahrani on 12/05/2017.
 */

public class Habit {

    private int id;
    private String name;
    private int status;

    public Habit()
    {
    }

    public Habit(int id,String name,int status)
    {
        this.id=id;
        this.name=name;
        this.status=status;
    }

    public Habit(String name,int status)
    {
        this.name=name;
        this.status=status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSatus(int status) {
        this.status = status;
    }

    public int getId() {

        return id;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }
}