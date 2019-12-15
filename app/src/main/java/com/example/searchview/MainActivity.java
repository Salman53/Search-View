package com.example.searchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity   {
    ListView listView;
    SearchView searchView;
    ArrayAdapter adapter;
    ArrayList fruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        searchView = findViewById(R.id.Search_list);

        fruits = new ArrayList<>();

        fruits.add("Apples");
        fruits.add("Apricot");
        fruits.add("orange");
        fruits.add("Almond");
        fruits.add("pineapple");
        fruits.add("pine");
        fruits.add("lemon");
        fruits.add("watermelon");
        fruits.add("Apples");
        fruits.add("Banana");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, fruits);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You selected" + " " +
                        fruits.get(position), Toast.LENGTH_SHORT).show();

            }
        });
    }
    }