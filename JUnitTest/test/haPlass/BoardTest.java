package haPlass;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.*;


public class BoardTest {
	Board board = new Board();
	
	@Before
	public void initializeBoard() {
		board.initializeBoard();
		board.printBoard();
	}
	
	
	
	@Test
	public void testEmptyBoard() {
		assertTrue(board.hasWinner());
	}
	
	@Test
	public void testRightMarksNoW() {
		board.setMark(0, 0);
		board.changePlayer();
		board.setMark(1, 0);
		board.changePlayer();
		board.setMark(1, 1);
		board.changePlayer();
		board.setMark(2, 2);
		board.changePlayer();
		board.setMark(2, 0);
		board.changePlayer();
		board.setMark(0, 2);
		board.changePlayer();
		board.setMark(0, 1);
		board.changePlayer();
		board.setMark(2, 1);
		board.changePlayer();
		board.setMark(1, 2);
		assertTrue(board.hasWinner());
		
	}
	
	@Test
	public void testRightMarksW() {
		board.setMark(0, 0);
		board.changePlayer();
		board.setMark(1, 0);
		board.changePlayer();
		board.setMark(1, 1);
		board.changePlayer();
		board.setMark(0, 1);
		board.changePlayer();
		board.setMark(2, 2);
		assertTrue(board.hasWinner());
	}
	
	@Test
	public void testWrongMarks() {
		board.setMark(4, 0);
		board.changePlayer();
		board.setMark(1, 6);
		board.changePlayer();
		board.setMark(1, 434);
		board.changePlayer();
		board.setMark(3, 2);
		board.changePlayer();
		board.setMark(2, 0);
		board.changePlayer();
		board.setMark(44, 2);
		board.changePlayer();
		board.setMark(0, 42);
		board.changePlayer();
		board.setMark(2, 1);
		board.changePlayer();
		board.setMark(1, -14);
		assertTrue(board.hasWinner());
	}
	

}
