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
        value = findValue();
    }
    
    public int findValue(){ //positive value means good for P1, neg means good for P2
        int score = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board.boardStates[i][j] == Board.BoardState.P1){
                    score++;
                }else if(board.boardStates[i][j] == Board.BoardState.P2){
                    score--;
                }else if(board.boardStates[i][j] == Board.BoardState.P1K){
                    score += 3;
                }else if(board.boardStates[i][j] == Board.BoardState.P2K){
                    score -= 3;
                }
            }
        }
        return score;
    }
    
}
