package com.example.shaimaalzahrani.habittrakersqlite;

/**
 * Created by shaimaalzahrani on 12/05/2017.
 */

public class Habit {

    private int id;
    private String name;

    public Habit()
    {
    }

    public Habit(int id,String name)
    {
        this.id=id;
        this.name=name;
    }

    public Habit(String name)
    {
        this.name=name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }
}