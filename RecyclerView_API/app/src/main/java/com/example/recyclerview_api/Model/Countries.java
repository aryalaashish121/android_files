package com.example.recyclerview_api.Model;

public class Countries {

    private int id;
    private String country, file;

    public Countries(int id, String country, String file) {
        this.id = id;
        this.country = country;
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
