package train;

import java.awt.Color;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

public class PiecePack {

    public int[] row = {1,1,1,1,1,1,1,1,1,2,3};
    public char[] col = {'b','c','d','e','f','g','h','i','k','f','f'};
    public String[] piece = {PieceName.BLACK_PAWN,PieceName.BLACK_ROCK,PieceName.BLACK_KNIGHT,PieceName.BLACK_QUEEN,PieceName.BLACK_BISHOP,PieceName.BLACK_KING,PieceName.BLACK_KNIGHT,PieceName.BLACK_ROCK,PieceName.BLACK_PAWN,PieceName.BLACK_BISHOP,PieceName.BLACK_BISHOP};
    public Color[] bgColor = new Color[9];
    public Color[] tColor = new Color[9];
    int num = 11;

    public PiecePack() {
        // row[] = {1,1,1,1,1,1,1,1,1};
        col[5] = 'f';
        bgColor[5] = null;
        tColor[5] = Color.BLACK;

    }
    public void setPieces(Application app) {
        for(int i =0; i<num; i++){
            app.setCellProperties(row[i], col[i], piece[i], null, Color.WHITE);

        }
        System.out.println(col[10]);
    }
}
