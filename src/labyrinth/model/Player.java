package labyrinth.model;

public class Player {
    private int row;
    private int col;
    private final int startRow;
    private final int startCol;

    public Player(int startRow, int startCol) {
        this.row = startRow;
        this.col = startCol;
        this.startRow = startRow;
        this.startCol = startCol;
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
        } else if (gameBoard.isWall(row + 1, col)) {
            System.out.println("you hit a wall!");
            this.row = Player.this.row = startRow;
            this.col = Player.this.col = startCol;
        }
    }

    public void moveDown(GameBoard gameBoard) {
        if (gameBoard.isValidCell(row + 1, col) && !gameBoard.isWall(row + 1, col)) {
            row++;
        } else if (gameBoard.isWall(row + 1, col)) {
            System.out.println("you hit a wall!");
            this.row = Player.this.row = startRow;
            this.col = Player.this.col = startCol;
        }
    }

    public void moveLeft(GameBoard gameBoard) {
        if (gameBoard.isValidCell(row, col - 1) && !gameBoard.isWall(row, col - 1)) {
            col--;
        } else if (gameBoard.isWall(row, col+1)) {
            System.out.println("you hit a wall!");
            this.row = Player.this.row = startRow;
            this.col = Player.this.col = startCol;
        }
    }

    public void moveRight(GameBoard gameBoard) {
        if (gameBoard.isValidCell(row, col + 1) && !gameBoard.isWall(row, col + 1)) {
            col++;
        } else if (gameBoard.isWall(row, col+1)) {
            System.out.println("you hit a wall!");
            this.row = Player.this.row = startRow;
            this.col = Player.this.col = startCol;
        }
    }

    public boolean isAtExit(GameBoard gameBoard) {
        return gameBoard.isExit(row, col);
    }
}
