package train2;

import java.awt.*;
import java.util.SplittableRandom;

public class Cell {
    public Cell(Color bcolor, String piece, Color tcolor) {
        this.bcolor = bcolor;
        this.piece = piece;
        this.tcolor = tcolor;

    }
    protected Color bcolor;
    protected String piece;
    protected Color tcolor;

    public Color getBcolor() {
        return bcolor;
    }

    public String getPiece() {
        return piece;
    }

    public Color getTcolor() {
        return tcolor;
    }
}
