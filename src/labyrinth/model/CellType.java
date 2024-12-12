package labyrinth.model;

public enum CellType {
    WALL('W'),
    EMPTY(' '),
    PLAYER('P'),
    EXIT('E'),
    SECRET_PASSAGE('S');

    private final char symbol;

    CellType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static CellType fromSymbol(char symbol) {
        for (CellType type : CellType.values()) {
            if (type.symbol == symbol) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid cell type symbol: " + symbol);
    }
}
