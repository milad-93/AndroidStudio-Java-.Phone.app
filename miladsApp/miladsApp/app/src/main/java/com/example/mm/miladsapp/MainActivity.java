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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // meny
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // flytande knappen med text
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Välkommen", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
            case R.id.Homepage:{ // Hemsidan
                Intent FirstActivity = new Intent(this, MainActivity.class);
                startActivity(FirstActivity);

                return true;
            }

            case  R.id.Page1:{ // Kontakta oss
                Intent ContactUs = new Intent(this, Page2.class);
                startActivity(ContactUs);
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
