package labyrinth;

import labyrinth.model.Cell;
import labyrinth.model.CellType;
import labyrinth.model.GameBoard;
import labyrinth.model.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        gameBoard.loadLabyrinth("easy_labyrinth.csv");

        System.out.println("Welcome to the Labyrinth!");
        gameBoard.printLabyrinth();

        // zet de speler aan de begin positie
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

        // Game loop
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //print het labyrinth na elke move
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

            // Input van de speler
            System.out.print("Move (WASD): ");
            char move = scanner.nextLine().toLowerCase().charAt(0);
            switch (move) {
                case 'z': player.moveUp(gameBoard); break;
                case 's': player.moveDown(gameBoard); break;
                case 'q': player.moveLeft(gameBoard); break;
                case 'd': player.moveRight(gameBoard); break;
                default:
                    System.out.println("Invalid input! Use zqsd to move as an azerty keyboard.");
            }

            // controleren of het gechekt is
            if (player.isAtExit(gameBoard)) {
                System.out.println("Congratulations! You reached the exit!");
                break;
            }
        }

        scanner.close();
    }
}