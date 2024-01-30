package train;

import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

import java.util.ArrayList;
import java.util.List;

public class PiecePack {
    public int[] wrow = {1,1,1,1,1,1,1,1,1,2,3,2,3,4,5,4,3,2};
    public char[] wcol = {'b','c','d','e','f','g','h','i','k','f','f','c','d','e','f','g','h','i'};
//    public String[] wpiece = {PieceName.WHITE_PAWN,PieceName.WHITE_ROCK,PieceName.WHITE_KNIGHT,PieceName.WHITE_QUEEN,PieceName.WHITE_BISHOP,PieceName.WHITE_KING,PieceName.WHITE_KNIGHT,PieceName.WHITE_ROCK,PieceName.WHITE_PAWN,PieceName.WHITE_BISHOP,PieceName.WHITE_BISHOP,PieceName.WHITE_PAWN,PieceName.WHITE_PAWN,PieceName.WHITE_PAWN,PieceName.WHITE_PAWN,PieceName.WHITE_PAWN,PieceName.WHITE_PAWN,PieceName.WHITE_PAWN};
    public String[] wpiece = {null,PieceName.WHITE_ROCK,PieceName.WHITE_KNIGHT,PieceName.WHITE_QUEEN,PieceName.WHITE_BISHOP,PieceName.WHITE_KING,PieceName.WHITE_KNIGHT,PieceName.WHITE_ROCK,null,PieceName.WHITE_BISHOP,PieceName.WHITE_BISHOP,null,null,null,null,null,null,null};
    public int[] brow = {7,8,9,10,11,10,9,8,7,10,9,7,7,7,7,7,7,7};
    public char[] bcol = {'b','c','d','e','f','g','h','i','k','f','f','c','d','e','f','g','h','i'};
//    public String[] bpiece = {PieceName.BLACK_PAWN,PieceName.BLACK_ROCK,PieceName.BLACK_KNIGHT,PieceName.BLACK_QUEEN,PieceName.BLACK_BISHOP,PieceName.BLACK_KING,PieceName.BLACK_KNIGHT,PieceName.BLACK_ROCK,PieceName.BLACK_PAWN,PieceName.BLACK_BISHOP,PieceName.BLACK_BISHOP,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN,PieceName.BLACK_PAWN};
    public String[] bpiece = {null,PieceName.BLACK_ROCK,PieceName.BLACK_KNIGHT,PieceName.BLACK_QUEEN,PieceName.BLACK_BISHOP,PieceName.BLACK_KING,PieceName.BLACK_KNIGHT,PieceName.BLACK_ROCK,null,PieceName.BLACK_BISHOP,PieceName.BLACK_BISHOP,null,null,null,null,null,null,null};
    public String[] pieces = {PieceName.BLACK_PAWN,PieceName.BLACK_ROCK,PieceName.BLACK_KNIGHT,PieceName.BLACK_QUEEN,PieceName.BLACK_BISHOP,PieceName.BLACK_KING,PieceName.BLACK_PAWN,PieceName.BLACK_ROCK,PieceName.BLACK_KNIGHT,PieceName.BLACK_QUEEN,PieceName.BLACK_BISHOP,PieceName.BLACK_KING};

    public int num = 18;

}
