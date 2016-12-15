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
    
    public void movePlayer(Board board, int playerType){
        ArrayList<Move> possibleMoves = findAllMoves(board);
        
        Move bestMove = possibleMoves.get(0);
        
        for(int i = 1; i < possibleMoves.size(); i++){
            if(possibleMoves.get(i).value > bestMove.value){
                bestMove = possibleMoves.get(i);
            }
        }
        board = bestMove.board; //check
    }
    
    public ArrayList<Move> findAllMoves(Board board, int playerType){
        ArrayList<Move> moves = new ArrayList<>();
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board.boardStates[i][j] != BoardState.EMPTY){
                    findMoves(board, i, j);
                }
                if(board.checkGameState() == WinnerState.UNFINISHED){
                    movePlayer(board, playerType*(-1)); //switch turn
                }else{
                    moves.add(new Move(board));
                }
            }
        }
        return moves;
    }
    
    public void findMoves(Board board, int x, int y){
        
        if(board.boardStates[x][y] == BoardState.P1){
           
        }else if(board.boardStates[x][y] == BoardState.P2){
           
        }else if(board.boardStates[x][y] == BoardState.P1K){
           
        }else if(board.boardStates[x][y] == BoardState.P1K){
           
        }
        
    }
    
    public void findMovesP2(Board board, int pieceX, int pieceY){
        
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
    
}
