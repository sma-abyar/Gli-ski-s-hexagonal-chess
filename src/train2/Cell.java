package train2;

import java.awt.*;
import java.util.SplittableRandom;

public class Cell {
    public Cell(Color bcolor, String piece, Color tcolor) {
        this.bcolor = bcolor;
        this.piece = piece;
        this.tcolor = tcolor;

    }
    public Color bcolor;
    public String piece;
    public Color tcolor;
}
