package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState game;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        game = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(game.getTurnID() == playerIdx){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if(action instanceof PigHoldAction){
            int score;
            if(game.getTurnID() == 0){
                score = game.getP0Score() + game.getRunningTotal();
                game.setP0Score(score);
            }
            else if(game.getTurnID() == 1){
                score = game.getP1Score() + game.getRunningTotal();

                game.setP1Score(score);
            }
            game.setRunningTotal(0);
            if(playerNames.length > 1){
                if(game.getTurnID() == 0){
                    game.setTurnID(1);
                }
                else{
                    game.setTurnID(0);
                }
            }
            return true;
        }
        else if(action instanceof PigRollAction){
            int roll = (int) (1 + Math.random()*6);
            int total;
            if(roll != 1){
                game.setDieValue(roll);
                total = roll + game.getRunningTotal();
                game.setRunningTotal(total);
            }
            else{
                game.setDieValue(roll);
                game.setRunningTotal(0);
                if(playerNames.length > 1) {
                    if (game.getTurnID() == 1) {
                        game.setTurnID(0);
                    } else {
                        game.setTurnID(1);
                    }
                }
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(new PigGameState(game));
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if(game.getP0Score() >= 50){
            return "Player 0 wins with a score of " + game.getP0Score();
        }
        else if(game.getP1Score() >= 50){
            return "Player 1 wins with a score of " + game.getP1Score();
        }
        return null;
    }

}// class PigLocalGame
