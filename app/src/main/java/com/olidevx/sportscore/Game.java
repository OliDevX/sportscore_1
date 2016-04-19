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

        // Updates the Display holders with method SetPoints with the current Team Points
        mDisplay1.SetPoints(mTeam1.mPoints);
        mDisplay2.SetPoints(mTeam2.mPoints);

        // mDisplaySet.SetPoints();
        // TODO: Complete code for Set - Create Set Class

        // Passes info from the Display classes to the Game class
        mDisp1_digit1 = mDisplay1.Digit_1;
        mDisp1_digit2 = mDisplay1.Digit_2;
        mDisp1_digit3 = mDisplay1.Digit_3;

        mDisp2_digit1 = mDisplay2.Digit_1;
        mDisp2_digit2 = mDisplay2.Digit_2;
        mDisp2_digit3 = mDisplay2.Digit_3;

        mDispSet_digit1 = mDisplaySet.Digit_1;
        mDispSet_digit2 = mDisplaySet.Digit_2;
    }

    /* ScoreChange method is created to make score changes happen
    * and then trigger all other actions in Team and Display classes
    * int_score_id - int variable to determine the team or set to modify
    * boolean - if TRUE then increase, if FALSE then decrease
     */
    public void ScoreChange(int int_score_id, boolean bool_increase){
        if ((int_score_id > 0) && (int_score_id < 3)){
            switch (int_score_id) {
                case 0: break;

                // Case 1 indicates team 1 increases or decreases points
                case 1:
                    if (bool_increase){
                        mTeam1.onIncreasePoint();
                    } else {
                        mTeam1.onDecreasePoint();
                    }
                    break;

                // Case 2 indicates team 2 increases or decreases points
                case 2:
                    if (bool_increase){
                        mTeam2.onIncreasePoint();
                    } else {
                        mTeam2.onDecreasePoint();
                    }
                    break;
            }

            // After changing the points
            UpdateDisplays();
        }
        // TODO: Complete this section
    }
}
