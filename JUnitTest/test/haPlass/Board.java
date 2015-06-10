package haPlass;
import java.util.*;


public class Board {
	private char[][] board;
	private char currentPlayerMark;
	
	public Board() {
		board = new char[3][3];
		currentPlayerMark = 'x';
		initializeBoard();
	}
	
	class InvalidPositionException extends RuntimeException {
		public InvalidPositionException(String a) {
			super(a);
		}
	}
	
	public void initializeBoard() {
		for(int i= 0; i<3;i++) {
			
			for(int j=0;j<3;j++){
				board[i][j] ='-';
			}
		}
	}
	
	public void printBoard() {
		System.out.println("---------------");
		
		for(int i=0; i<3;i++){
			System.out.println("| ");
			for(int j=0; j<3;j++){
				System.out.println(board[i][j] + " | ");
		}
			System.out.println();
			System.out.println("------------");
		}	
	}
	
	public boolean hasWinner(){
		return (checkXForWin() || checkYForWin() || checkXYForWin());
	}
	
	private boolean checkXForWin() {
		for(int i=0;i<3;i++){
			if(checkXY(board[i][0], board[i][1], board[i][2]) == true) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkYForWin() {
		for(int i=0;i<3;i++){
			if(checkXY(board[0][i], board[1][i], board[2][i]) == true) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkXYForWin() {
		return ((checkXY(board[0][0], board[1][1], board[2][2]) == true) || 
			(checkXY(board[0][2], board[1][1], board[2][0]) == true));
	}
	
	private boolean checkXY(char m1, char m2, char m3){
		return ((m1 != '-') && (m1 == m2) && (m2 == m3));
	}
	
	public void changePlayer() {
		if(currentPlayerMark =='x') {
			currentPlayerMark = 'o';
		}
		else {
			currentPlayerMark = 'x';
		}
	}
	
	public boolean setMark(int x, int y)throws InvalidPositionException{
		 if ((x <= 2 && x >= 0) && (y <= 2 && y >= 0 )){
				if((x >= 0) && (x < 3)) {
					if ((y >= 0) && (y < 3)) {
						if (board[x][y] == '-') {
							board[x][y] = currentPlayerMark;
							return true;
						}
						
					}
				}
				return false;
			}	
			 else {
			 throw new InvalidPositionException("ungültige Position");
			 }
			}
	
}
