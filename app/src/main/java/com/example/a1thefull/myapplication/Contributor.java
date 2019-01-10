package com.example.a1thefull.myapplication;

public class Contributor {
    String login;
    String html_url;

    int contributions;

    @Override
    public String toString() {
        return login + "(" + contributions + ")";
    }
}
