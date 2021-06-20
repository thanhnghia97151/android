package com.example.fulldemothithu;

public class Users {
    private String id,name,age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Users() {
    }

    public Users(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


}
