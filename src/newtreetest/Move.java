/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newtreetest;

/**
 *
 * @author SyBye8898
 */
public class Move {
    
    public Board board;
    public Player player;
    public int value;
    /*value is contained within board. not sure if it is better to have it in here
    instead*/
    
    public Move(Board _board){
        board = _board;
        //player = _player; not sure if player should be included here
        value = board.findValue();
    }
    
    
    
}
