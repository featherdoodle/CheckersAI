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
public class Board {
    //it seems not useful to find the value of each board. we only really care about the ending one i think
    public static enum BoardState{
        EMPTY, P1, P2, P1K, P2K
    }
    
    public BoardState[][] boardStates = new BoardState[8][8];
    public int boardValue;
    
    public Board(){
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 8; j++){
                boardStates[i][j] = BoardState.P2;
            }
        }
        for(int i = 2; i < 6; i++){
            for(int j = 0; j < 8; j++){
                boardStates[i][j] = BoardState.EMPTY;
            }
        }
        for(int i = 6; i < 8; i++){
            for(int j = 0; j < 8; j++){
                boardStates[i][j] = BoardState.P1;
            }
        }
        
        boardValue = 0;
        
    }
    
    public Board(BoardState[][] _boardStates){
        boardStates = _boardStates;
        boardValue = findValue();
    }
    //this is more like a print board method 'cause i think im making a new board for every moveeeeee
    public void updateBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(boardStates[i][j] == BoardState.EMPTY){
                    System.out.print(" |");
                }else if(boardStates[i][j] == BoardState.P1){
                    System.out.print("a|");
                }else if(boardStates[i][j] == BoardState.P2){
                    System.out.print("b|");
                }else if(boardStates[i][j] == BoardState.P1K){
                    System.out.print("A|");
                }else if(boardStates[i][j] == BoardState.P2K){
                    System.out.print("B|");
                }
            }
            System.out.println();
            
        }
    }
    
    public WinnerState checkGameState(){
        boolean P1pieces = false;
        boolean P2pieces = false;
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if((boardStates[i][j] == BoardState.P1)||(boardStates[i][j] == BoardState.P1K)){
                    P1pieces = true;
                }else if((boardStates[i][j] == BoardState.P2)||(boardStates[i][j] == BoardState.P2K)){
                    P2pieces = true;
                }
            }
        }
        
        if((P1pieces)&&(!P2pieces)){
            return WinnerState.PLAYER_1_WINS;
        }else if((!P1pieces)&&(P2pieces)){
            return WinnerState.PLAYER_2_WINS;
        }else if((P1pieces)&&(P2pieces)){
            return WinnerState.UNFINISHED;
        }
        return WinnerState.UNFINISHED;
    }
    
    public int findValue(){ //positive value means good for P1, neg means good for P2
        int score = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(boardStates[i][j] == BoardState.P1){
                    score++;
                }else if(boardStates[i][j] == BoardState.P2){
                    score--;
                }else if(boardStates[i][j] == BoardState.P1K){
                    score += 3;
                }else if(boardStates[i][j] == BoardState.P2K){
                    score -= 3;
                }
            }
        }
        return score;
    }
    
}
