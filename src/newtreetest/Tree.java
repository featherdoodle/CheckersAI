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
        ArrayList<Move> possibleMoves = findAllMoves(board, playerType);
        
        Move bestMove = possibleMoves.get(0);
        
        for(int i = 1; i < possibleMoves.size(); i++){
            if(possibleMoves.get(i).value > bestMove.value){
                bestMove = possibleMoves.get(i);
            }
        }
        board = bestMove.board; //check
        board.updateBoard();
        
    }
    
    public Move findBestMove(Board board){
        Move bestMove;
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board.boardStates[i][j] != BoardState.EMPTY){
                    ArrayList<Move> moves = findFutureMoves(board, i, j);
                    for(int k = 0; k < moves.size(); k++){
                        
                    }
                }
            }
        }
        
        return bestMove;
    }
    
    public ArrayList<Move> findFutureMoves(Board board, int x, int y){
        //i only really need to check through half the board. half will be empty
        ArrayList<Move> moves = new ArrayList<>();
        /*
                if(board.boardStates[i][j] != BoardState.EMPTY){
                    findMoves(board, board.getPieceType(board.boardStates[i][j]), i, j);
                }
                if(board.checkGameState() == WinnerState.UNFINISHED){
                    movePlayer(board, playerType *(-1)); //switch turn
                }else{
                    moves.add(new Move(board));
                }
        }*/ //restructure
        return moves;
    }
    
    public ArrayList<Move> findMoves(Board board, int playerType, int x, int y){
        //this is almost good
        ArrayList<Move> moves = new ArrayList<>();
        
        for(int i = -1; i <= 1; i+=2){
            for(int j = -1; j <= 1; j+=2){
                if(board.boardStates[x+i][y+j] == BoardState.EMPTY){
                    if(!outOfBounds()){
                        moves.add(0, new Move(board));
                        if(becomeKing()){
                            if(playerType == 1){
                                moves.get(0).board.boardStates[x+i][y+j] = BoardState.P1K;
                            }else if(playerType == -1){
                                moves.get(0).board.boardStates[x+i][y+j] = BoardState.P2K;
                            }
                        }else{
                            moves.get(0).board.boardStates[x+i][y+j] = board.boardStates[x][y];
                        }
                        moves.get(0).board.boardStates[x][y] = BoardState.EMPTY;
                    }
                }else if(board.getPieceType(board.boardStates[x+i][y+j]) != playerType){
                    checkJump(); //i guess i need to check for jumping in three directions from where i land.
                }
            }
        }
        return moves;
    }
    
    public boolean checkJump(){
        //?
        return true;
    }
    
    public boolean outOfBounds(){
        //?
        return false;
    }
    
    public boolean becomeKing(){
        
        return false;
    }
    
}
