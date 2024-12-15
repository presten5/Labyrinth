package labyrinth.model;

public class Cell {
    private CellType type; // het type van de cell zoals de muur ofzo

    public Cell(CellType type) {
        this.type = type;

    }

    public void setType(CellType type) {
        this.type = type;
    }


    public CellType getType() {
        return type;
    }
}



