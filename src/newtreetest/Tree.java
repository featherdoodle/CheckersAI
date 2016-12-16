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
    
    public Move findBestMove(ArrayList<Move> moves){
        Move bestMove = moves.get(0);
        
        for(int k = 0; k < moves.size(); k++){
            if(moves.get(k).value > bestMove.value){
                bestMove = moves.get(k);
            }
        }        
        return bestMove;
    }
    
    public void findFutureMoves(Board board, int playerType){
        //. while board is unfinsihed, keep finding 
        //allMoves. bak in forth for turns (*-1) when it is finished, set the value
        while(true){
            ArrayList<Move> moves = findAllMoves(board, playerType*(-1));
            while(board.checkGameState() == WinnerState.UNFINISHED){
                findAllMoves(board, playerType*(-1));
            }
            //set value
        }
        
    }
    
    public ArrayList<Move> findAllMoves(Board board, int playerType){
        ArrayList<Move> moves = new ArrayList<>();
        
        //the only point of this method is to iterate through the whole board
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board.getPieceType(board.boardStates[i][j]) == playerType){
                    ArrayList<Move> pieceMoves = findMoves(board, playerType, i, j);
                    for(int k = 0; k < pieceMoves.size(); k++){
                        moves.add(pieceMoves.get(k));
                    }
                }
            }
        }
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
                    //while the moves are more than one, check jump
                }
            }
        }
        return moves;
    }
    
    public boolean checkJump(){
        //fedrggessgeSGDS
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
