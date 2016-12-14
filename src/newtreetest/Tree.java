/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newtreetest;

import java.util.ArrayList;
import newtreetest.Board.BoardState;

/**
 *
 * @author SyBye8898
 */
public class Tree {
    
    Player player;
    
    public Tree(Player _player){
        player = _player;
    }
    
    public void moveP1(Board board){
        
        ArrayList<Move> moves = new ArrayList<>();
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board.boardStates[i][j] == BoardState.P1){
                    findMovesP1(board, i, j);
                }else if(board.boardStates[i][j] == BoardState.P1K){
                    findMovesKing(board, i, j);
                }
                if(board.checkGameState() == WinnerState.UNFINISHED){
                    moveP2(board);
                }else{
                    //determine the best move
                    Move bestMove = moves.get(0);//new Move();
                    for(int k = 0; k < moves.size(); k++){//check the size
                        if(moves.get(k).value > bestMove.value){
                            bestMove = moves.get(k);
                        }
                    }
                    
                }
            }
        }
    }
    
    public void moveP2(Board board){
        
        ArrayList<Move> moves = new ArrayList<>();
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board.boardStates[i][j] == BoardState.P2){
                    findMovesP2(board, i, j);
                }else if(board.boardStates[i][j] == BoardState.P2K){
                    findMovesKing(board, i, j);
                }
                if(board.checkGameState() == WinnerState.UNFINISHED){
                    moveP1(board);
                }else{
                    //determine the best move
                    Move bestMove = moves.get(0);//new Move();
                    for(int k = 0; k < moves.size(); k++){//check the size
                        if(moves.get(k).value < bestMove.value){
                            bestMove = moves.get(k);
                        }
                    }
                }
            }
        }
    }
    
    public void findMovesP1(Board board, int pieceX, int pieceY){
        //should it return an array of moves
    }
    
    //seems a little silly to have a method for P1, P2 and king...
    public void findMovesP2(Board board, int pieceX, int pieceY){
        //keep the board with the highest value... maybe store the value under the board!
        //each regular piece has two possible moves. each king has four...
        //need to check if the move would be outside of the board... is that necessary??
        
        /*if i do it like this, i have an array of the finished boards, so i 
        can find which outcome is best, but i lose the move that lead there. if i
        had a class just for move though, it would only contain a board and maybe
        a player whose turn it was? just containing info, no methods :/ */
        //list
        ArrayList<Move> possibleMoves = new ArrayList<>();
        
        //umm so am i keeping track of all of the moves or just the best?
        //i think maybe return them all, and sort through in the move method
        possibleMoves.add(0, new Move());
        if(board.boardStates[pieceX-1][pieceY+1] == BoardState.EMPTY){ /*kinda choppy 
            because it only works for one side of the board (moving down)*/
            board.boardStates[pieceX][pieceY] = BoardState.EMPTY;
            board.boardStates[pieceX-1][pieceY+1] = BoardState.P2;
            possibleMoves.get(0).board.boardStates = board.boardStates;/*kinda gotta 
            check to make sure this is updating the correct boards 'cause they are both called board*/
            //findMovesP2(board, pieceX-1, pieceY+1);//but need to have P1 move first
        }if(board.boardStates[pieceX+1][pieceY+1] == BoardState.EMPTY){
            board.boardStates[pieceX][pieceY] = BoardState.EMPTY;
            board.boardStates[pieceX+1][pieceY+1] = BoardState.P2;
            possibleMoves.get(0).board.boardStates = board.boardStates;
        }
        //this should be the stopping statement... ?
        if(board.checkGameState() == WinnerState.PLAYER_1_WINS){
            possibleMoves.get(0).value = board.findValue();
        }else if(board.checkGameState() == WinnerState.PLAYER_2_WINS){
            possibleMoves.get(0).value = board.findValue();
        }else if(board.checkGameState() == WinnerState.UNFINISHED){
            
        }
        
    }
    
    public void findMovesKing(Board board, int pieceX, int pieceY){
        
    }
    
}
