package labyrinth;

import labyrinth.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        gameBoard.loadLabyrinth("easy_labyrinth.csv");

        HighScoreManager highScoreManager = new HighScoreManager();

        System.out.println("Welcome to the Labyrinth!");
        gameBoard.printLabyrinth();

        int startRow = -1, startCol = -1;
        Cell[][] labyrinth = gameBoard.getLabyrinth();
        for (int row = 0; row < labyrinth.length; row++) {
            for (int col = 0; col < labyrinth[row].length; col++) {
                if (labyrinth[row][col].getType() == CellType.PLAYER) {
                    startRow = row;
                    startCol = col;
                    break;
                }
            }
            if (startRow != -1) break;
        }

        if (startRow == -1) {
            System.out.println("Error: Player start position not found!");
            return;
        }
        Player player = new Player(startRow, startCol);
        highScoreManager.startTimer();

        // Game loop
        Scanner scanner = new Scanner(System.in);
        while (true) {

            for (int row = 0; row < labyrinth.length; row++) {
                for (int col = 0; col < labyrinth[row].length; col++) {
                    if (row == player.getRow() && col == player.getCol()) {
                        System.out.print('P' + " "); // Player position
                    } else {
                        System.out.print(labyrinth[row][col].getType().getSymbol() + " ");
                    }
                }
                System.out.println();
            }

            // Input from the player
            System.out.print("Move (ZQSD for AZERTY keyboards): ");
            String input = scanner.nextLine().toLowerCase();


            if (input.isEmpty()) {
                System.out.println("No input given! Please use ZQSD to move.");
                continue;
            }

            // Access the first character safely
            char move = input.charAt(0);
            switch (move) {
                case 'z': player.moveUp(gameBoard); break;
                case 's': player.moveDown(gameBoard); break;
                case 'q': player.moveLeft(gameBoard); break;
                case 'd': player.moveRight(gameBoard); break;
                default:
                    System.out.println("Invalid input! Use ZQSD to move as on an AZERTY keyboard.");
            }

            // Check if the player has reached the exit
            if (player.isAtExit(gameBoard)) {
                System.out.println("Congratulations! You reached the exit!");
                break;
            }
        }


        highScoreManager.stopTimer();



        long elapsedTime = highScoreManager.getElapsedTimeInSeconds();
        System.out.println("Your time: " + elapsedTime + " seconds");

        // Add the score to the high score list
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        highScoreManager.addHighScore(playerName, elapsedTime);



        highScoreManager.displayHighScores();

        scanner.close();
    }
}
