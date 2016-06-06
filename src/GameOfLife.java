
public class GameOfLife 
{	
	//private int row = 50;
	//private int col = 50;
	private boolean[][] board; 
	public GameOfLife(boolean[][] board) //constructor
	{
		this.board = board;
	}
	public void calculateNextGeneration()  //calculate the next generation of the universe.
	{
		boolean nextGeneration[][] = new boolean[board.length][board[0].length];
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[0].length;col++)
			{
				int n = neighbours(row,col);
				if (n > 3 || n < 2)
				{
					nextGeneration[row][col] = false;
				}
				else if (n == 3 )
				{
					nextGeneration[row][col] = true;
				}
				else 
				{
					nextGeneration[row][col] = board[row][col];
				}
			}
		}
		board = nextGeneration;
	}
	public int neighbours (int row, int col) 
	{
		  int neighbours = 0;
		  for ( int i = row -1; i <= row + 1 ; i++)
		    {
		     for (int j = col -1 ; j <= col + 1 ; j++)
		       {
		       try {
		         if (board[i][j]==true && (i != row || j!=col))
		         {
		           neighbours++;
		         }          
		       } catch ( ArrayIndexOutOfBoundsException f)
		       {continue;}
		     }
		  }
		  return neighbours;
	}
	
	public void print() //prints the current generation to the console using '*' for cells that are alive and '.' for cells that are not.
	{
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[0].length;col++)
			{
				if (board[row][col] == true)
				{
					System.out.print("#");
				}
				else 
				{
					System.out.print("-");
				}
				
			}
			System.out.println();
		}
	}
	public void setAlive(int x, int y, boolean isAlive) //sets whether the cell at (x,y) is alive;
	{
		if(!(board == null || x < 0|| x > board[0].length || y < 0 || y > board.length))
		{
			board[y][x] = isAlive;
		}
		
	}
	public boolean isAlive(int x, int y) //returns whether the cell at (x,y) is alive; (0,0) is at the top left
	{
		if (board == null || x < 0|| x > board[0].length || y < 0 || y > board.length)
		{
			return false;
		}
		else
		{
			return board[y][x];
		}
	}
}
