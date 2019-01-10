package com.example.a1thefull.myapplication;

public class ChatMsg {

    private String userName;    //보낸이
    private String message;     // 메시지
    private String time;        // 시간

    public ChatMsg(){
    }

    public ChatMsg(String userName, String message, String time){
        this.userName = userName;
        this.message = message;
        this.time = time;
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }

    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }
}

