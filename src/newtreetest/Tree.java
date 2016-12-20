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
        ArrayList<Move> possibleMoves = getFinalMoves(board, playerType);
        
        Move bestMove = possibleMoves.get(0);
        
        for(int i = 1; i < possibleMoves.size(); i++){
            if(possibleMoves.get(i).value > bestMove.value){
                bestMove = possibleMoves.get(i);
            }
        }
        board = bestMove.board; //check
        board.updateBoard();
        
    }
    
    public Move getBestMove(ArrayList<Move> moves){
        Move bestMove = moves.get(0);
        
        for(int k = 0; k < moves.size(); k++){
            if(moves.get(k).value > bestMove.value){
                bestMove = moves.get(k);
            }
        }        
        return bestMove;
    }
    
    public ArrayList<Move> getFinalMoves(Board board, int playerType){
        //. while board is unfinsihed, keep finding 
        //allMoves. bak in forth for turns (*-1) when it is finished, set the value
        
        ArrayList<Move> moves = getAllMoves(board, playerType*(-1));
        for(int i = 0; i < moves.size(); i++){
            while(moves.get(i).board.checkGameState() == WinnerState.UNFINISHED){
                getAllMoves(board, playerType*(-1));
            }
            moves.get(i).value = moves.get(i).board.findValue();
        }
        return moves;
    }
    
    public ArrayList<Move> getAllMoves(Board board, int playerType){
        ArrayList<Move> moves = new ArrayList<>();
        
        //the only point of this method is to iterate through the whole board
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board.getPieceType(board.boardStates[i][j]) == playerType){
                    ArrayList<Move> pieceMoves = getMoves(board, playerType, i, j);
                    for(int k = 0; k < pieceMoves.size(); k++){
                        moves.add(pieceMoves.get(k));
                    }
                }
            }
        }
        return moves;
    }
    //finds moves for a specific piece
    public ArrayList<Move> getMoves(Board board, int playerType, int x, int y){
        //this is almost good
        ArrayList<Move> moves = new ArrayList<>();
        
        for(int i = -1; i <= 1; i+=2){
            for(int j = -1; j <= 1; j+=2){
                if(board.boardStates[x+i][y+j] == BoardState.EMPTY){
                    if(!outOfBounds(x+i, y+j)){
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
                    //checkJump(); //i guess i need to check for jumping in three directions from where i land.
                    //while the moves are more than one, check jump
                }
            }
        }
        return moves;
    }
    
    public boolean checkJump(Board board, int playerType, int x, int y){
        for(int i = -1; i <= 1; i+=2){
            for(int j = -1; j <= 1; j+=2){
                if(Board.getPieceType(board.boardStates[x+i][y+j]) == playerType*(-1)){
                    if(board.boardStates[x+(2*i)][y+(2*j)] == BoardState.EMPTY){
                        
                    }
                }
            }
        }
                
        return true;
    }
    
    public boolean outOfBounds(int x, int y){
        //?
        return false;
    }
    
    public boolean becomeKing(){
        
        return false;
    }
    
}
