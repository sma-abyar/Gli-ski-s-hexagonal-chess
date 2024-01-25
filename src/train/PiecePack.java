package train;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;
import train2.Cell;

public class PiecePack {
    Map<String, Cell> bBoard = new HashMap<>();
    public int[] wrow = {1,1,1,1,1,1,1,1,1,2,3,2,3,4,5,4,3,2};
    public char[] wcol = {'b','c','d','e','f','g','h','i','k','f','f','c','d','e','f','g','h','i'};
    public String[] wpiece = {PieceName.BLACK_PAWN,PieceName.BLACK_ROCK,PieceName.BLACK_KNIGHT,PieceName.BLACK_QUEEN,PieceName.BLACK_BISHOP,PieceName.BLACK_KING,PieceName.BLACK_KNIGHT,PieceName.BLACK_ROCK,PieceName.BLACK_PAWN,PieceName.BLACK_BISHOP,PieceName.BLACK_BISHOP,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN};
    public int[] brow = {7,8,9,10,11,10,9,8,7,10,9,7,7,7,7,7,7,7};
    public char[] bcol = {'b','c','d','e','f','g','h','i','k','f','f','c','d','e','f','g','h','i'};
    public String[] bpiece = {PieceName.BLACK_PAWN,PieceName.BLACK_ROCK,PieceName.BLACK_KNIGHT,PieceName.BLACK_QUEEN,PieceName.BLACK_BISHOP,PieceName.BLACK_KING,PieceName.BLACK_KNIGHT,PieceName.BLACK_ROCK,PieceName.BLACK_PAWN,PieceName.BLACK_BISHOP,PieceName.BLACK_BISHOP,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN};


    public Color[] bgColor = new Color[9];
    public Color[] tColor = new Color[9];
    int num = 18;

    public PiecePack() {
        bgColor[5] = null;
        tColor[5] = Color.BLACK;

    }
    public void setPieces(Application app) {
        for(int i =0; i<num; i++){
            app.setCellProperties(wrow[i], wcol[i], wpiece[i], null, Color.WHITE);
            bBoard.put(""+wrow[i]+wcol[i],new Cell(null, wpiece[i], Color.WHITE));
            app.setCellProperties(brow[i], bcol[i], bpiece[i], null, Color.BLACK);
            bBoard.put(""+brow[i]+bcol[i],new Cell(null, bpiece[i], Color.BLACK));


        }
    }

    public Map<String, Cell> getbBoard() {
        return bBoard;
    }
}
