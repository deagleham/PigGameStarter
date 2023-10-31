package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    private PigGameState gameState;

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        gameState = (PigGameState) info;
        if(gameState.getTurnID() == this.playerNum){
            int rand = (int) (Math.random()*2);
            if(rand == 0){
                game.sendAction(new PigHoldAction(this));
            }
            else if(rand == 1){
                game.sendAction(new PigRollAction(this));
            }
        }
    }//receiveInfo

}
