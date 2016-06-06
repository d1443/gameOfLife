
import junit.framework.TestCase;

public class GameOfLifeTest extends TestCase {

		
	public void testGame()
	{
	
		 //test for null board
		
		GameOfLife nullGame = new GameOfLife(null);
		//should not fail
		nullGame.setAlive(1, 2, true);
		//should not fail
		assertEquals(false, nullGame.isAlive(0,0));
		
		boolean[][] board = new boolean[10][10];
		GameOfLife game = new GameOfLife(board);

		//set up a glider
		game.setAlive(2, 1, true);
		game.setAlive(3, 2, true);
		game.setAlive(1, 3, true);
		game.setAlive(2, 3, true);
		game.setAlive(3, 3, true);

		//test if cells were set correctly
		assertEquals(false, game.isAlive(0,0));
		assertEquals(false, game.isAlive(3,1));
		assertEquals(true, game.isAlive(2,1));
		
		//test bounds
		assertEquals(false, game.isAlive(-1,0));
		assertEquals(false, game.isAlive(0,-1));
		assertEquals(false, game.isAlive(11,0));
		assertEquals(false, game.isAlive(0,11));
		assertEquals(false, game.isAlive(20,20));
		
		//run ten generations, and test if the end state is correct
		game.print();
		for (int i = 1; i <= 10; i++) {
			game.calculateNextGeneration();
			System.out.println("generation:" + i);
			game.print();
		}

		assertEquals(false, game.isAlive(3,4));
		assertEquals(false, game.isAlive(4,4));
		assertEquals(true, game.isAlive(5,4));
		
		assertEquals(true, game.isAlive(3,5));
		assertEquals(false, game.isAlive(4,5));
		assertEquals(true, game.isAlive(5,5));
		
		assertEquals(false, game.isAlive(3,6));
		assertEquals(true, game.isAlive(4,6));
		assertEquals(true, game.isAlive(5,6));	
	}

		
	
}