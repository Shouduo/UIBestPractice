package com.shouduo.uibestpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;

    private List<Msg> msgList = new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initMsg();
        adapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList);
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgListView = (ListView) findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT, R.drawable.ha);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                }
            }
        });
    }

    private void initMsg(){
        Msg msg1 = new Msg("Hello?", Msg.TYPE_RECEIVED, R.drawable.wallace);
        msgList.add(msg1);
        Msg msg2 = new Msg("Excited. Who is that", Msg.TYPE_SENT, R.drawable.ha);
        msgList.add(msg2);
        Msg msg3 = new Msg("This is wallace. Nice talking to you.", Msg.TYPE_RECEIVED, R.drawable.wallace);
        msgList.add(msg3);
        Msg msg4 = new Msg("          ;;;\n" +
                "❐..❐- ∂  \n" +
                "  '～' }  /\n" +
                "   ︶ ", Msg.TYPE_SENT, R.drawable.ha);
        msgList.add(msg4);
    }
}
