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
import android.widget.TextView;

import java.util.ArrayList;

public class SnakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake);


        // meny
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // flytande knappen med text
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Kontakta oss ifall du upptäcker felaktiv information", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // tar emot just den positionen från arrayn som tryckts från föregående aktivetet som är page 3
        Bundle extras = getIntent().getExtras();
        int position = extras.getInt("position");

        // via ifsatser skrivs information ut om just den ormeen som är placerad på den positionen i arrayn.

        if (position == 0){

            TextView txSnakes = (TextView) findViewById(R.id.snakeview);
            txSnakes.setText(" -Skallerorm(Crotalus)-\n * Utbredning:Amerika \n * Gift: Giftig\n * Längd: ca 150cm");

        }


        else if (position == 1){

            TextView txSnakes = (TextView) findViewById(R.id.snakeview);
            txSnakes.setText(" -Huggorm(Vipera berus)-\n * Utbredning:Europa/Asien/Afrika(Palearktis )\n * Gift: Giftig\n * Längd: ca 60cm" );

        }
        else if (position == 2){

            TextView txSnakes = (TextView) findViewById(R.id.snakeview);
            txSnakes.setText(" -TIGERORM(Notechis scutatus)-\n * Utbredning: Australien\n * Gift:giftig(neurotoxiskt)\n * Längd: 120-180cm ");

        }
        else if (position == 3){

            TextView txSnakes = (TextView) findViewById(R.id.snakeview);
            txSnakes.setText(" -FILLIPINSK KOBRA-\n * Utbredning:Asien(Norra fillipinerna)\n * Gift: Väldigt giftig\n * Längd: ca 160cm ");

        }
        else if (position == 4){

            TextView txSnakes = (TextView) findViewById(R.id.snakeview);
            txSnakes.setText(" -MAJSORM(Pantherophis guttatus)- \n * Utbredning:USA\n * Gift: Ogiftig \n * Längd: ca 120-180cm ");

        }
        else if (position == 5){

            TextView txSnakes = (TextView) findViewById(R.id.snakeview);
            txSnakes.setText(" -SVART MAMBA(Dendroaspis polylepis)-\n * Utbredning:Afrika\n  *Gift: Dödligt giftig\n *Varning : Ett bett  innehåller gift som kan döda 30 personer\n * Längd: ca 2.5 - 4m ");

        }
        else if (position == 6){

            TextView txSnakes = (TextView) findViewById(R.id.snakeview);
            txSnakes.setText(" -TAIPAN(Oxyuranus scutellatus)- \n * Utbredning:Australien, Nya Guniea\n * Gift: Dödligt Giftig\n * Varning : 100% dödlighet utan  motgift\n * Längd: ca 3m ");

        }
        else if (position == 7){

            TextView txSnakes = (TextView) findViewById(R.id.snakeview);
            txSnakes.setText(" -BRUNORM(Pseudonaja textilis)-\n * Utbredning:Australien, Nya Guniea\n * Gift: Giftig\n * Varning : Dödlighet hög utan motgift\n Längd: ca 2m ");

        }
        else if (position == 8){

            TextView txSnakes = (TextView) findViewById(R.id.snakeview);
            txSnakes.setText(" -INLANDS TAIPAN(Oxyuranus microlepidotus)-\n * Utbredning: Australien\n * Gift: Världens giftigaste orm\n* Varning : Ett bett  innehåller gift som kan döda 100 personer \n *Gifttyp: Neurotoxiskt \n * Längd: ca 1.8-2.5 m ");

        }




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
            case R.id.Homepage:{ // Hemsidan
                Intent FirstActivity = new Intent(this, MainActivity.class);
                startActivity(FirstActivity);

                return true;
            }

            case  R.id.Page1:{ // Kontakta oss
                Intent ContactUS = new Intent(this, Page2.class);
                startActivity(ContactUS);
                return true;
            }
            case  R.id.Page2:{ // Välj en orm
                Intent SnakePick = new Intent(this, Page3.class);
                startActivity(SnakePick);
                return true;
            }


        }
        return true;

    }


}
