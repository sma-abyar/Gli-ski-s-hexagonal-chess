package trian3;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;
import train2.Cell;
import train2.GameManager;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Rules {
    String charnum;
    Application app;
    char[] chars;
    int row;
    char col;
    int charn;
    int turn;
    Map<String, Cell> board;
    public void Movement(GameManager board, Cell cell){
        this.charnum = board.getCharnum();
        this.app = board.getApp();
        this.chars = board.getChars();
        this.row = cell.getRow();
        this.col = cell.getColumn();
        this.charn = charnum.indexOf(col);
        this.turn = cell.getTurn();
        this.board = board.getbBoard();
        String name = cell.getPiece();
        if (name.equals(PieceName.WHITE_PAWN)){
            whitePawn();
        }else if(name.equals(PieceName.BLACK_PAWN)){
            blackPawn();
        }else if(name.equals(PieceName.WHITE_ROCK) || name.equals(PieceName.BLACK_ROCK)){
            Rock();
        }
    }

    private void blackPawn() {
    }

    public void whitePawn() {
        if(turn == 0){
            changeBackGroundColor(row+2,chars[charn], Color.lightGray);
        }if( charn == 5){
            changeBackGroundColor(row,chars[charn+1], Color.lightGray);
            changeBackGroundColor(row,chars[charn-1], Color.lightGray);
            changeBackGroundColor(row+1,chars[charn], Color.lightGray);
        }else if (charn<5){
            changeBackGroundColor(row+1,chars[charn+1], Color.lightGray);
            changeBackGroundColor(row,chars[charn-1], Color.lightGray);
            changeBackGroundColor(row+1,chars[charn], Color.lightGray);
        }else{
            changeBackGroundColor(row,chars[charn+1], Color.lightGray);
            changeBackGroundColor(row+1,chars[charn-1], Color.lightGray);
            changeBackGroundColor(row+1,chars[charn], Color.lightGray);
            }
        turn ++;
    }
    private void changeBackGroundColor(int row, char col, Color color){
        board.get(""+row+col).setBcolor(color);
        app.changeBackGround(row, col, color);
    }
    private void Rock(){
        for (int i = 0; i<11; i++){
            try{
                changeBackGroundColor(row-i, col, Color.lightGray);
                changeBackGroundColor(row+i, col, Color.lightGray);
            }catch (Exception e){
            }
        }
    }
}

