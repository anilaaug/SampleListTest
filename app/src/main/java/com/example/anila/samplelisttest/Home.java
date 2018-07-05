package com.example.anila.samplelisttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    ListView mListView;
    SearchView mSearchView;
    ArrayAdapter adapter;
    List<String> mStringList=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mListView=findViewById(R.id.listview);
        mSearchView=findViewById(R.id.search_view);
        mStringList.add("Bob Marley");
        mStringList.add("Mick Jagger");
        mStringList.add("Rod Stewart");
        mStringList.add("Charlie Puth");
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mStringList);
        mListView.setAdapter(adapter);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(mStringList.contains(query))
                {
                    adapter.getFilter().filter(query);
                }
                else
                {
                    Toast.makeText(Home.this, "No match found", Toast.LENGTH_SHORT).show();

                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });


    }
}
