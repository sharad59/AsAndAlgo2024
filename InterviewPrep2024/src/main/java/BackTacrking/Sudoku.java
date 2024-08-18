package BackTacrking;

public class Sudoku {

	 static int N = 9;

	    static boolean solveSudoku(int grid[][], int row,
	                               int col)
	    {
	 
	        if (row == N - 1 && col == N)
	            return true;

	        if (col == N) {
	            row++;
	            col = 0;
	        }

	        if (grid[row][col] != 0)
	            return solveSudoku(grid, row, col + 1);
	 
	        for (int num = 1; num < 10; num++) {

	            if (isSafe(grid, row, col, num)) {
	                grid[row][col] = num;
	                if (solveSudoku(grid, row, col + 1))
	                    return true;
	            }
	            grid[row][col] = 0;
	        }
	        return false;
	    }
	 
	    static void print(int[][] grid)
	    {
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++)
	                System.out.print(grid[i][j] + " ");
	            System.out.println();
	        }
	    }
	 

	    static boolean isSafe(int[][] grid, int row, int col,
	                          int num)
	    {

	        for (int x = 0; x <= 8; x++)
	        {  if (grid[row][x] == num)
	                return false;

	            if (grid[x][col] == num)
	                return false;
	        }
	        int startRow = row - row % 3, startCol
	                                      = col - col % 3;
	        for (int i = 0; i < 3; i++)
	            for (int j = 0; j < 3; j++)
	                if (grid[i + startRow][j + startCol] == num)
	                    return false;
	 
	        return true;
	    }
	  
	    public static void main(String[] args)
	    {
	        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
	                         { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
	                         { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
	                         { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
	                         { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
	                         { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
	                         { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
	                         { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
	                         { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
	 
	        if (solveSudokuUtil(grid, 0, 0))
	            print(grid);
	        else
	            System.out.println("No Solution exists");
	    }
	    
	    static  int n=9;
	    static boolean SolveSudoku(int grid[][])
	    {
	        n=grid.length;
	       return solveSudokuUtil(grid ,0,0) ;
	     }
	    
	    //Function to print grids of the Sudoku.
	    static void printGrid (int grid[][])
	    {
	 for (int i = 0; i < n; i++) {
		            for (int j = 0; j < n; j++)
		                System.out.print(grid[i][j] + " ");
		            System.out.println();
		        }    }
	    
	      public static  boolean solveSudokuUtil(int board[][],int row,int col)
	    {

	        if(row==n-1 && col ==n)
	        return true;

	        if(col==n)
	        {
	            row++;
	            col=0;
	        }

	        if(board[row][col]!=0){
	            return solveSudokuUtil(board,row,col+1);
	        }
	        for(int i=1;i<=n;i++)
	        {
	            if(isSafe1(board,row,col,i)) {
	            board[row][col]= i;

	            if(solveSudokuUtil(board,row,col+1))
	          return true;
	            }
	            board[row][col]=0;

	        }
	        return false;
	    }

	   static boolean isSafe1(int board[][],int row,int col,int num){

	        for(int i=0;i<n;i++){
	           if( board[row][i]==num)
	           return false;

	            if( board[i][col]==num)
	           return false;
	        }

	        int rowStart=row-row%3; int colStart =col-col%3;
	        for(int i=0;i<3;i++){
	            for(int j=0;j<3;j++){
	                if(board[i+rowStart][j+colStart]==num)
	                return false;
	            }
	        }
	        return true;
	    }
}
