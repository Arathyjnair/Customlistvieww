package com.example.user.customlistviewwidimages;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.BitSet;


public class MainActivity extends AppCompatActivity {

    ListView lst;
    ImageView imgs;
    TextView txt;
    ArrayList<String> fine;


   private int[] images = {R.mipmap.red, R.mipmap.green, R.mipmap.orange};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst=(ListView)findViewById(R.id.list);

        fine = new ArrayList<String>();

        fine.add("hi");
        fine.add("bye");
        fine.add("ok");

        adapt adp=new adapt();
        lst.setAdapter(adp);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
        } else if (position == 1) {
            Toast.makeText(MainActivity.this, "bye", Toast.LENGTH_SHORT).show();
        } else if (position == 2) {
            Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
        }
    }
});


    }


    class adapt extends BaseAdapter {

        LayoutInflater inflater;


        @Override
        public int getCount() {
            return fine.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View cview, ViewGroup parent) {

            inflater= (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cview= inflater.inflate(R.layout.list_single,null);
            txt=(TextView)cview.findViewById(R.id.txt);
            imgs=(ImageView)cview.findViewById(R.id.img);
            imgs.setImageResource(images[position]);
            txt.setText(fine.get(position));
            return cview;
        }
    }
}



