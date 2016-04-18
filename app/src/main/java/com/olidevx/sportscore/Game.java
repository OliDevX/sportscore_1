package com.olidevx.sportscore;

/**
 * Created by Armando on 18/04/2016.
 */
public class Game {
    // Declares two teams to play the game
    public Team mTeam1 = new Team();
    public Team mTeam2 = new Team();

    // Declares Displays for each team in game
    public Display mDisplay1 = new Display();
    public Display mDisplay2 = new Display();

    // Initializes game, puts team's points to zero and calls for display updates
    public void InitialGameSet(){
        // Puts points to "0" on each team
        mTeam1.SetPoints(0);
        mTeam2.SetPoints(0);
        UpdateDisplays();
    }

    public void UpdateDisplays(){
        mDisplay1.Points = mTeam1.mPoints;
        mDisplay2.Points = mTeam2.mPoints;
    }
}
