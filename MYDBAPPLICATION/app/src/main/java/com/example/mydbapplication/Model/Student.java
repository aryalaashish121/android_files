package com.example.mydbapplication.Model;

public class Student {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String image;

    public static final String TBL_NAME = "STUDENT";
    public static final String std_query ="CREATE TABLE "+TBL_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, STUDENT_NAME TEXT, STUDENT_PHONE TEXT, STUDENT_EMAIL TEXT, STUDENT_IMAGE TEXT)";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Student(int id, String name, String phone, String email, String image) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }
}
