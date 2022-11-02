package com.vamshi.coding.challenges;

import java.util.HashSet;
import java.util.Set;

// asked to murali bandaru by US Bank
public class ValidSudoko_US_Bank {

    public boolean isValidSudoku(char[][] board) {

        Set noDuplicates = new HashSet<>();

        for(int i=0;i < board.length; i++){
            for(int j=0;j < board[i].length; j++){

                char number = board[i][j];
                if(board[i][j] != '.'){
                    if(!noDuplicates.add("row value at" + i + "is" + number)){
                        return false;
                    }
                    if(!noDuplicates.add("col value at" + j+ "is" + number)){
                        return false;
                    }
                    if(!noDuplicates.add("box value at " + i/3 + j/3 + "is" + number)){
                        return false;
                    }
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};


        ValidSudoko_US_Bank validSudoko = new ValidSudoko_US_Bank();
        validSudoko.isValidSudoku(board);
    }
}
