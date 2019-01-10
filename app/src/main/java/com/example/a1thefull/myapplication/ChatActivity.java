package com.example.a1thefull.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatActivity extends AppCompatActivity {
    String userid;
    EditText msg;
    SimpleDateFormat timeformat;
    ArrayList<ChatMsg> m_chatdata;
    ListView listView;
    MyChatAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent intent = getIntent();
        userid = intent.getStringExtra("userid");
        init();
    }

    public void init() {
        msg = (EditText)findViewById(R.id.msg);
        listView = (ListView)findViewById(R.id.msglist);
        m_chatdata = new ArrayList<>();
        adapter = new MyChatAdapter(userid,this,R.layout.row,m_chatdata);
        listView.setAdapter(adapter);
        timeformat = new SimpleDateFormat("M월 d일 a h:m", Locale.KOREA);

        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
                Call<List<Contributor>> call = gitHubService.repoContributors("square", "retrofit");

                try {
                    return call.execute().body().toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                String time = timeformat.format(System.currentTimeMillis());
                ChatMsg chat = new ChatMsg(userid,s.toString(),time);
                m_chatdata.add(chat);
                adapter.notifyDataSetChanged();
                listView.setSelection(adapter.getCount()-1);
            }
        }.execute();


    }

    public void sendmsg(View view) {
        String tempmsg = msg.getText().toString();
        String time = timeformat.format(System.currentTimeMillis());
        ChatMsg chat = new ChatMsg(userid,tempmsg,time);
        msg.setText("");
        m_chatdata.add(chat);
        adapter.notifyDataSetChanged();
        listView.setSelection(adapter.getCount()-1);
    }
}
