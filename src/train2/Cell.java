package train2;

import java.awt.*;

public class Cell {
    public Cell(Color bcolor, String piece, Color tcolor, int row, char column) {
        this.bcolor = bcolor;
        this.piece = piece;
        this.tcolor = tcolor;
        this.row = row;
        this.column = column;

    }
    private Color bcolor;
    private String piece;
    private Color tcolor;
    private int row;
    private char column;
    private int round = 0;

    public Color getBcolor() {
        return bcolor;
    }

    public String getPiece() {
        return piece;
    }

    public Color getTcolor() {
        return tcolor;
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }

    public void setBcolor(Color bcolor) {
        this.bcolor = bcolor;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public void setTcolor(Color tcolor) {
        this.tcolor = tcolor;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }


}
