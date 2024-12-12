package labyrinth.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private Cell[][] labyrinth;

    //ik heb dit voor de csv file gemaakt en maakt het in een 2d array met een imputstream en met een exeption als de file niet gevonden wordt
    public void loadLabyrinth(String fileName) {
        List<Cell[]> rows = new ArrayList<>();
        try {
            InputStream inputStream = GameBoard.class.getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                System.out.println("Error: File not found: " + fileName);
                return;
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cellStrings = line.split(","); // Split line into cells
                Cell[] row = new Cell[cellStrings.length];
                for (int col = 0; col < cellStrings.length; col++) {
                    row[col] = new Cell(CellType.fromSymbol(cellStrings[col].charAt(0)));
                }
                rows.add(row);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading labyrinth file: " + e.getMessage());
            return;
        }
        labyrinth = rows.toArray(new Cell[0][]);
    }

    //een cell controleren of het een muur is of niet en conecteren met de enum
    public boolean isWall(int row, int col) {
        return isValidCell(row, col) && labyrinth[row][col].getType() == CellType.WALL;
    }

    //een cell controleren of het een uitgang is is of niet en conecteren met de enum
    public boolean isExit(int row, int col) {
        return isValidCell(row, col) && labyrinth[row][col].getType() == CellType.EXIT;
    }

    //een cell controleren of het een lege plaats is als doorgang of niet en conecteren met de enum
    public boolean isValidCell(int row, int col) {
        return row >= 0 && row < labyrinth.length && col >= 0 && col < labyrinth[row].length;
    }

   //het labyrinth maken dat w, p, spatie een array wordt
    public Cell[][] getLabyrinth() {
        return labyrinth;
    }

//   het labyrinth laten zien
    public void printLabyrinth() {
        for (int row = 0; row < labyrinth.length; row++) {
            for (int col = 0; col < labyrinth[row].length; col++) {
                System.out.print(labyrinth[row][col].getType().getSymbol() + " ");
            }
            System.out.println();
        }
    }
}
