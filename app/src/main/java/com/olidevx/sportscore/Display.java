package com.olidevx.sportscore;

/**
 * Created by Armando on 18/04/2016.
 */
public class Display {

    // Declares each digit for the display as Strings
    public String Digit_1;
    public String Digit_2;
    public String Digit_3;

    // Declares Score as the holder variable for each display
    public int Points;

    public void SetPoints(int points) {
        Points = points;
        if (Points < 10) {
            Digit_1 = Integer.toString(Points);
            Digit_2 = "0";
            Digit_3 = "";
        }

        if ((Points > 9) && (Points < 100)) {
            Digit_1 = Integer.toString(Points % 10);
            Digit_2 = Integer.toString((Points - (Points % 10)/10));
            Digit_3 = "";

        }
    }
}
