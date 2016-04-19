package com.olidevx.sportscore;

/**
 * Created by Armando Ibarrarán on 18/04/2016.
 */
public class Game {
    // Declares two teams to play the game
    public Team mTeam1 = new Team();
    public Team mTeam2 = new Team();

    // Declares Displays for each team in game
    public Display mDisplay1 = new Display();
    public Display mDisplay2 = new Display();
    public Display mDisplaySet = new Display();

    // Declares Strings for each Digit in Displays
    public String mDisp1_digit1 = new String();
    public String mDisp1_digit2 = new String();
    public String mDisp1_digit3 = new String();

    public String mDisp2_digit1 = new String();
    public String mDisp2_digit2 = new String();
    public String mDisp2_digit3 = new String();

    public String mDispSet_digit1 = new String();
    public String mDispSet_digit2 = new String();

    //TODO: Declare the visit and set digit strings

    // Initializes game, puts team's points to zero and calls for display updates
    public void InitialGameSet(){
        // Puts points to "0" on each team
        mTeam1.SetPoints(0);
        mTeam2.SetPoints(0);
        UpdateDisplays();
    }

    public void UpdateDisplays(){
        mDisplay1.SetPoints(mTeam1.mPoints);
        mDisplay2.SetPoints(mTeam2.mPoints);
        // mDisplaySet.SetPoints();
        // TODO: Complete code for Set - Create Set Class


        mDisp1_digit1 = mDisplay1.Digit_1;
        mDisp1_digit2 = mDisplay1.Digit_2;
        mDisp1_digit3 = mDisplay1.Digit_3;

        mDisp2_digit1 = mDisplay2.Digit_1;
        mDisp2_digit2 = mDisplay2.Digit_2;
        mDisp2_digit3 = mDisplay2.Digit_3;

        mDispSet_digit1 = mDisplaySet.Digit_1;
        mDispSet_digit2 = mDisplaySet.Digit_2;
    }

    // ScoreChange method is created to make scorechanges happen and subsecuently trigger all other actions in Team and Display classes
    public void ScoreChange(){
        // TODO: Complete ScoreChange method inside Game class
    }
}
