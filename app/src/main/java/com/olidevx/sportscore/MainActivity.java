package com.olidevx.sportscore;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import junit.framework.Test;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Declares the mGame object that will be used during the program
    public Game mGame = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set listener to home_layout & visit_layout
        View mLayoutHome = (View) findViewById(R.id.home_layout);
        View mLayoutVisit = (View) findViewById(R.id.visit_layout);

        mLayoutHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Does Nothing yet
            }
        });

        mLayoutVisit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                // Does Nothing yet
            }
        });

        // Initializes the displays to "00" "00"
        mGame.InitialGameSet();
        RefreshScreen();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void RefreshScreen (){
        // Declare Displays to be updated
        TextView mDisplay1_first_digit = (TextView) findViewById(R.id.home_first_digit_textview);
        TextView mDisplay1_second_digit = (TextView) findViewById(R.id.home_second_digit_textview);
        TextView mDisplay1_third_digit = (TextView) findViewById(R.id.home_third_digit_textview);

        TextView mDisplay2_first_digit = (TextView) findViewById(R.id.visit_first_digit_textview);
        TextView mDisplay2_second_digit = (TextView) findViewById(R.id.visit_second_digit_textview);
        TextView mDisplay2_third_digit = (TextView) findViewById(R.id.visit_third_digit_textview);

        // TODO: Declare and code for Set Display

        mDisplay1_first_digit.setText(mGame.mDisp1_digit1);
        mDisplay1_second_digit.setText(mGame.mDisp1_digit2);
        mDisplay1_third_digit.setText(mGame.mDisp1_digit3);

        mDisplay2_first_digit.setText(mGame.mDisp2_digit1);
        mDisplay2_second_digit.setText(mGame.mDisp2_digit2);
        mDisplay2_third_digit.setText(mGame.mDisp2_digit3);


    }
}
