package com.tic;
import java.util.Scanner;


public class TicTacToe {
	
	
	    // Define the game board
	    private char[][] board = new char[3][3];
	    private char currentPlayer;

	    // Constructor to initialize the game
	    public TicTacToe() {
	        initializeBoard();
	        currentPlayer = 'X';
	    }

	    // Method to initialize the game board
	    private void initializeBoard() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                board[i][j] = '-';
	            }
	        }
	    }

	    // Method to display the current state of the board
	    public void displayBoard() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    // Method to switch players (X to O and vice versa)
	    private void switchPlayer() {
	        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	    }

	    // Method to make a move on the board
	    public void makeMove(int row, int col) {
	        if (isValidMove(row, col)) {
	            board[row][col] = currentPlayer;
	            switchPlayer();
	        } else {
	            System.out.println("Invalid move. Try again.");
	        }
	    }

	    // Method to check if a move is valid
	    private boolean isValidMove(int row, int col) {
	        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
	    }

	    // Method to check if the game has a winner
	    public boolean hasWinner() {
	        return (checkRows() || checkColumns() || checkDiagonals());
	    }

	    // Helper methods to check for a winner
	    private boolean checkRows() {
	        for (int i = 0; i < 3; i++) {
	            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
	                return true;
	            }
	        }
	        return false;
	    }

	    private boolean checkColumns() {
	        for (int j = 0; j < 3; j++) {
	            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
	                return true;
	            }
	        }
	        return false;
	    }

	    private boolean checkDiagonals() {
	        return (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
	               (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
	    }

	    // Method to check if the board is full (a tie)
	    public boolean isBoardFull() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j] == '-') {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    // Main method to run the game
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        TicTacToe game = new TicTacToe();

	        while (!game.hasWinner() && !game.isBoardFull()) {
	            System.out.println("Current Board:");
	            game.displayBoard();

	            System.out.println("Player " + game.currentPlayer + ", enter your move (row and column):");
	            int row = scanner.nextInt();
	            int col = scanner.nextInt();

	            game.makeMove(row, col);
	        }

	        System.out.println("Final Board:");
	        game.displayBoard();

	        if (game.hasWinner()) {
	            System.out.println("Player " + game.currentPlayer + " wins!");
	        } else {
	            System.out.println("It's a tie!");
	        }

	        scanner.close();
	    }
	}



