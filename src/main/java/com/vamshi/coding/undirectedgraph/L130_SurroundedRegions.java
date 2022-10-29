package com.vamshi.coding.undirectedgraph;

public class L130_SurroundedRegions {

    private void dfs(int row, int col, char[][] board, int[][] vis){
        int[] row_delta = {-1,0,1,0};
        int[] col_delta = {0,1,0,-1};
        vis[row][col] = 1;

        for(int i=0; i <4;i++){
            int new_row = row + row_delta[i];
            int new_col = col + col_delta[i];

            if(new_row>=0 && new_row < board.length &&
                    new_col >=0 && new_col < board[0].length &&
                    board[new_row][new_col] == 'O' && vis[new_row][new_col] == 0){
                dfs(new_row, new_col, board, vis);
            }
        }

    }

    public void solve(char[][] board) {
        int[][] vis = new int[board.length][board[0].length];


        int rows = board.length;
        int cols = board[0].length;

        // first row
        for(int j=0;j < cols;j++ ){
            // second condition makes sure, we are not running dfs unnecessarily, say two corner 'O's
            if(board[0][j] == 'O' && vis[0][j] == 0){
                dfs(0,j,board, vis);
            }
        }
        // last row
        for(int j=0; j<cols; j++){
            if(board[rows-1][j] == 'O' && vis[rows-1][j] == 0){
                dfs(rows-1,j,board, vis);
            }
        }

        // first column
        for(int i=0; i<rows; i++){
            if(board[i][0] == 'O' && vis[i][0] == 0){
                dfs(i,0,board, vis);
            }
        }
        // last column
        for(int i=0; i<rows; i++){
            if(board[i][cols-1] == 'O' && vis[i][cols-1] == 0){
                dfs(i,cols-1,board, vis);
            }
        }

        // by this step, all corner 'O' should have been visited, so vis[i][j] == 1
        for(int i =0; i < rows;i++){
            for(int j =0; j < cols;j++) {
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void main(String[] args) {
        char mat[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};

        L130_SurroundedRegions l130_surroundedRegions = new L130_SurroundedRegions();
        l130_surroundedRegions.solve(mat);


        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }
}
