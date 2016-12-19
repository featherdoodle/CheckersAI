/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newtreetest;

import java.util.Scanner;

/**
 *
 * @author SyBye8898
 */
public class HumanPlayer extends Player{
    
    @Override
    public void move(){
        int oldX, oldY, newX, newY;
        
        Scanner scan = new Scanner(System.in);
        //getting user input
        System.out.print("Enter a piece to move: ");
        oldX = scan.nextInt();
        oldY = scan.nextInt();
        System.out.print("Enter the new coordinates: ");
        newX = scan.nextInt();
        newY = scan.nextInt();
        
        //use tree to findMoves and see if the new pos is possible, and then perform the move
        
    }
    
}
