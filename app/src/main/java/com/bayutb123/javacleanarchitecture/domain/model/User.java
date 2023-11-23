package com.bayutb123.javacleanarchitecture.domain.model;

public class User {
    private final String _name;
    private final int _age;

    public User(String name, int age) {
        this._name = name;
        this._age = age;
    }

    public String getUserName() {
        return _name;
    }

    public int getUserAge() {
        return _age;
    }

}
