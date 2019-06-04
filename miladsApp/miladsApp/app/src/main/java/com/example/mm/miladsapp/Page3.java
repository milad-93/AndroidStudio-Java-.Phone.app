package com.example.mm.miladsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Page3 extends AppCompatActivity {

    private ListView mainListView;
    private ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //skapar en knapp floating med random information
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                Snackbar.make(view, "Tryck på namnet för att välja en orm", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        // skapar en lista med ormar
        final ArrayList<String> ormar = new ArrayList<String>();
        ormar.add("Skallerorm");
        ormar.add("Huggorm");
        ormar.add("Tigerorm");
        ormar.add("Fillipisnk Kobra");
        ormar.add("Majsorm");
        ormar.add("Svart Mamba");
        ormar.add("Taipan");
        ormar.add("Brunorm");
        ormar.add("Inlands taipan");

        // skapar en adapter som har designen list_row xml fil

        myAdapter = new ArrayAdapter<String>(this, R.layout.list_row,ormar);


        // hämtar  listview från min layout

        mainListView =(ListView) findViewById(R.id.mainListView);
        mainListView.setAdapter(myAdapter);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // denna if sats kommer att öppna aktiviteten SnakeActivity alla tryck i listan leder till att samma sida öppnas.

            if (position == 0 || position ==1 || position == 2 || position == 3 || position == 4
                    || position == 5 || position == 6 || position == 7 || position == 8){


                Intent myintent = new Intent(view.getContext(),SnakeActivity.class);
               // myintent.putExtra("snakes", ormar);
                myintent.putExtra("position",position);
                startActivity(myintent);
            }

                Toast.makeText(Page3.this," Information om: "+ ormar.get(position)
                                +" kommer att presenteras ", Toast.LENGTH_LONG).show();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

    // via switchsats så öppnas en aktivtet beroende på vilken du klickar på i menyn
        switch (id){
            case R.id.Homepage:{ //Hemsidan
                Intent FirstActivity = new Intent(this, MainActivity.class);
                startActivity(FirstActivity);

                return true;
            }

            case  R.id.Page1:{ // kontakta oss
                Intent ContactUs = new Intent(this, Page2.class);
                startActivity(ContactUs);
                return true;
            }

            case  R.id.Page2:{ // välj en orm sidan
                Intent SnakePick = new Intent(this, Page3.class);
                startActivity(SnakePick);
                return true;
            }



        }
        return true;
    }








}
