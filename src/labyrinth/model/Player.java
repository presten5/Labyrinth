package labyrinth.model;

public class Player {
    private int row;
    private int col;

    public Player(int startRow, int startCol) {
        this.row = startRow;
        this.col = startCol;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void moveUp(GameBoard gameBoard) {
        if (gameBoard.isValidCell(row - 1, col) && !gameBoard.isWall(row - 1, col)) {
            row--;
        } else {
            System.out.println("You hit a wall!");
        }
    }

    public void moveDown(GameBoard gameBoard) {
        if (gameBoard.isValidCell(row + 1, col) && !gameBoard.isWall(row + 1, col)) {
            row++;
        } else {
            System.out.println("You hit a wall!");
        }
    }

    public void moveLeft(GameBoard gameBoard) {
        if (gameBoard.isValidCell(row, col - 1) && !gameBoard.isWall(row, col - 1)) {
            col--;
        } else {
            System.out.println("You hit a wall!");
        }
    }

    public void moveRight(GameBoard gameBoard) {
        if (gameBoard.isValidCell(row, col + 1) && !gameBoard.isWall(row, col + 1)) {
            col++;
        } else {
            System.out.println("You hit a wall!");
        }
    }

    public boolean isAtExit(GameBoard gameBoard) {
        return gameBoard.isExit(row, col);
    }
}
