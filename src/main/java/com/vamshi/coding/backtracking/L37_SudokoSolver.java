package com.vamshi.coding.backtracking;

public class L37_SudokoSolver {

    public static void main(String[] args) {
        int c = '9';
        System.out.println("c is " + c);

//        for(char c='1'; c <= 9; c++){
//            System.out.println("c is " + c);
//        }
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {

        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                if(board[i][j] == '.'){

                    for(char c='1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;

                            if(solve(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }

                return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int column, char c) {
        // check column condition
        for(int k=0; k < 9; k++){
            if(board[row][k] == c ){
                return false;
            }

        // check row condition
            if(board[k][column] == c ){
                return false;
            }

            if(board[3 * (row/3) + k/3][3 * (column/3) + k % 3] == c){
                return false;
            }
        }
        return true;
    }

}
