package com.javaman.webprojectlearn.powermock.pojo;

public class Mom {
    private int id;

    private String name;

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

    @Override
    public String toString() {
        return "Mom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
