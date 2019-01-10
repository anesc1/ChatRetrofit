package com.example.a1thefull.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyChatAdapter extends ArrayAdapter<ChatMsg> {
    Context context;
    ArrayList<ChatMsg> list;
    boolean msg_left = false;
    String userid;
    public MyChatAdapter(String userid, @NonNull Context context, int resource, @NonNull ArrayList<ChatMsg> objects) {
        super(context, resource, objects);
        this.context = context;
        list = objects;
        this.userid = userid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v==null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = layoutInflater.inflate(R.layout.row,null);
        }
        ChatMsg msg = list.get(position);
        TextView msgText = (TextView)v.findViewById(R.id.msg);
        TextView time = (TextView)v.findViewById(R.id.msgTime);
        msgText.setText(msg.getMessage());
        time.setText(msg.getTime());
        LinearLayout msgContainer = (LinearLayout)v.findViewById(R.id.msgContainers);
        if(userid.equals(msg.getUserName())){
            msg_left = true;
            msgContainer.setGravity(Gravity.LEFT);
        }else{
            msg_left = false;
            msgContainer.setGravity(Gravity.RIGHT);
        }
        msgText.setBackgroundResource(msg_left? R.drawable.m_left:R.drawable.m_right);
        return v;
        //return super.getView(position, convertView, parent);
    }

}
