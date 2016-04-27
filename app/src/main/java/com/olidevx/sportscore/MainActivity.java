package com.olidevx.sportscore;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

// These last two imports were used for the exit dialog
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    // Declares the mGame object that will be used during the program
    public Game mGame = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set listeners to home_layout & visit_layout
        View mLayoutHome = (View) findViewById(R.id.home_layout);
        View mLayoutVisit = (View) findViewById(R.id.visit_layout);

        mLayoutHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Invoques the ScoreChange Method passing "1" for the Home Team and "true" to increase
                mGame.ScoreChange(1,true);

                // Then asks to refresh the screen
                RefreshScreen();
            }
        });

        mLayoutHome.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                // Invoques the ScoreChange Method passing "1" for the Home Team and "false" to decrease
                mGame.ScoreChange(1,false);

                // Then asks to refresh the screen
                RefreshScreen();

                return true;
            }
        });


        mLayoutVisit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                // Invoques the ScoreChange Method passing "2" for the Visit Team and "true" to increase
                mGame.ScoreChange(2,true);

                // Then asks to refresh the screen
                RefreshScreen();
            }
        });

        mLayoutVisit.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                // Invoques the ScoreChange Method passing "2" for the Visit Team and "false" to decrease
                mGame.ScoreChange(2,false);

                // Then asks to refresh the screen
                RefreshScreen();

                return true;
            }
        });

        // Initializes the displays to "00" "00"
        mGame.SetScores(0,0,0);

        // Refreshes the displays on screen
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

    // Created to save Score states when orientation changes
    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("TEAM1_POINTS",mGame.mTeam1.mPoints);
        outState.putInt("TEAM2_POINTS",mGame.mTeam2.mPoints);
    }

    // Created to restore Score states after orientation changes
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mGame.SetScores(savedInstanceState.getInt("TEAM1_POINTS"),savedInstanceState.getInt("TEAM2_POINTS"),0);
        RefreshScreen();
    }

    // Created to refresh screen every time score changes
    public void RefreshScreen (){
        // Declare Displays to be updated
        TextView mDisplay1_first_digit = (TextView) findViewById(R.id.home_first_digit_textview);
        TextView mDisplay1_second_digit = (TextView) findViewById(R.id.home_second_digit_textview);
        TextView mDisplay1_third_digit = (TextView) findViewById(R.id.home_third_digit_textview);

        TextView mDisplay2_first_digit = (TextView) findViewById(R.id.visit_first_digit_textview);
        TextView mDisplay2_second_digit = (TextView) findViewById(R.id.visit_second_digit_textview);
        TextView mDisplay2_third_digit = (TextView) findViewById(R.id.visit_third_digit_textview);

        // TODO: Declare and code for Set Display on the RefeshScreen method

        mDisplay1_first_digit.setText(mGame.mDisp1_digit1);
        mDisplay1_second_digit.setText(mGame.mDisp1_digit2);
        mDisplay1_third_digit.setText(mGame.mDisp1_digit3);

        mDisplay2_first_digit.setText(mGame.mDisp2_digit1);
        mDisplay2_second_digit.setText(mGame.mDisp2_digit2);
        mDisplay2_third_digit.setText(mGame.mDisp2_digit3);

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

}
