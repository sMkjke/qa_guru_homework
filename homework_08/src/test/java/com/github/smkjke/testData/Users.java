package com.github.smkjke.testData;

import java.util.List;

public class Users {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Users withUsers(List<User> users) {
        this.users = users;
        return this;
    }

    public void printUsers() {
        for (User i : users) {
            System.out.println(i.toString());
        }
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }

}
