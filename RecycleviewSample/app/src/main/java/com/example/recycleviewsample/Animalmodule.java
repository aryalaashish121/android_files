package com.example.recycleviewsample;

import java.lang.reflect.Constructor;

public class Animalmodule {
    private String heading;
    private  int img;


    public Animalmodule(String heading, int img) {
        this.heading = heading;
        this.img = img;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
