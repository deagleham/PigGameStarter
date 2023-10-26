package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
    private int turnID;
    private int P0Score;
    private int P1Score;
    private int runningTotal;
    private int dieValue;

    public PigGameState(){
        turnID = 0;
        P0Score = 0;
        P1Score = 0;
        runningTotal = 0;
        dieValue = 0;
    }

    public PigGameState(PigGameState a){
        this.turnID = a.turnID;
        this.P0Score = a.P0Score;
        this.P1Score = a.P1Score;
        this.runningTotal = a.runningTotal;
        this.dieValue = a.dieValue;
    }

    public int getTurnID(){
        return turnID;
    }//0 or 1

    public int getP0Score(){
        return P0Score;
    }

    public int getP1Score(){
        return P1Score;
    }

    public int getRunningTotal(){
        return runningTotal;
    }

    public int getDieValue(){
        return dieValue;
    }

    public void setTurnID(int id){
        turnID = id;
    }

    public void setP0Score(int score){
        P0Score = score;
    }

    public void setP1Score(int score){
        P1Score = score;
    }

    public void setRunningTotal(int total){
        runningTotal = total;
    }

    public void setDieValue(int die){
        dieValue = die;
    }
}
