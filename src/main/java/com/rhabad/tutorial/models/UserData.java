package com.rhabad.tutorial.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserData {

    public String name;

    @JsonIgnore
    public int age;

    @JsonProperty("realAddress")
    public String address;

    @JsonGetter("informacion")
    public String info(){
        return "name: "+name+" age: "+age+" address: "+address;
    }


    public UserData(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
