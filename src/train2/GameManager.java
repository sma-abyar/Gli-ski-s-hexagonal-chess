package train2;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import train.PiecePack;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
    public GameManager(Application app, PiecePack pack) {
        this.app = app;
        this.pack = pack;

    }
    protected int row;
    protected char column;
    public Application app;
    protected PiecePack pack;
    private Cell sCell;
    private Cell lcell;

    Map<String, Cell> bBoard = new HashMap<>();
    int lrow;
    char lcol;
    Color lBColor;
    public List<Character> col = new ArrayList<>();
    char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l'};
    String charnum = "abcdefghikl";


    private void Move(Cell lcell, Cell ncell){
        if (ncell.getBcolor() == Color.DARK_GRAY) {
            ncell.setPiece(lcell.getPiece());
            ncell.setTcolor(lcell.getTcolor());
            lcell.setPiece(null);
            lcell.setTcolor(null);
            lcell.setBcolor(null);
            app.setCellProperties(ncell.getRow(), ncell.getColumn(), ncell.getPiece(), null, ncell.getTcolor());
            app.setCellProperties(lcell.getRow(), lcell.getColumn(), null, null, null);
            lBColor = null;
            ClearBackGrounds();
        }else {
            ClearBackGrounds();
            app.changeBackGround(ncell.getRow(), ncell.getColumn(), Color.blue);
        }

    }
    public void turn(){}
    private void removePiece(){
    }
    private void changeBackgroundColor(Cell cell, int row, char col, Color color){
        if ((row != lrow) || (col != lcol)){
            app.changeBackGround(lrow, lcol, null);
        }
        app.changeBackGround(row, col, color);
        lrow = row;
        lcol = col;
        lcell = cell;
        lBColor = color;
    }
    public void clicked(int row, char column){
        this.row = row;
        this.column = column;
        try{
            sCell = bBoard.get(""+row+column);
            if (lBColor == Color.GREEN){
                if (sCell.getTcolor() != lcell.getTcolor()){
                    Move(lcell, sCell);
                }
            }else if (sCell.getTcolor() != null){
                changeBackgroundColor(sCell, row, column, Color.GREEN);
                test(sCell);
                System.out.println(row+""+column+sCell.getPiece());
            }else{
                changeBackgroundColor(sCell, row, column, Color.BLUE);
            }
        }catch (Exception e){

        }
    }
    public void arrangeBoard(){
        for(char c : chars){
            col.add(c);
            for (int i = 0; i<11; i++){
                try{
                    bBoard.put(""+i+c, new Cell(null, null, null, i, c));
                }catch (Exception e){

                }
            }
        }for(int i =0; i<pack.num; i++){
            app.setCellProperties(pack.wrow[i], pack.wcol[i], pack.wpiece[i], null, Color.WHITE);
            bBoard.put(""+pack.wrow[i]+pack.wcol[i],new Cell(null, pack.wpiece[i], Color.WHITE, pack.wrow[i], pack.wcol[i]));
            app.setCellProperties(pack.brow[i], pack.bcol[i], pack.bpiece[i], null, Color.BLACK);
            bBoard.put(""+pack.brow[i]+pack.bcol[i],new Cell(null, pack.bpiece[i], Color.BLACK, pack.brow[i], pack.bcol[i]));
        }

    }
    public void test(Cell cell){
        int row = cell.getRow();
        char col = cell.getColumn();
        int charn = charnum.indexOf(col);
        if( charn == 5){
            app.changeBackGround(row, chars[charn+1], Color.darkGray);
            app.changeBackGround(row, chars[charn-1], Color.darkGray);
            app.changeBackGround(row+1, chars[charn], Color.darkGray);

        }else if (charn<5){
            app.changeBackGround(row+1, chars[charn+1], Color.darkGray);
            app.changeBackGround(row, chars[charn-1], Color.darkGray);
            app.changeBackGround(row+1, chars[charn], Color.darkGray);
        }else {
            app.changeBackGround(row, chars[charn+1], Color.darkGray);
            app.changeBackGround(row+1, chars[charn-1], Color.darkGray);
            app.changeBackGround(row+1, chars[charn], Color.darkGray);
        }
    }
    public void ClearBackGrounds(){
        for (char c: chars){
            for (int i=1; i<=11; i++){
                try{
                    app.changeBackGround(i,c,null);
                }catch (Exception e){
                }
            }
        }
    }
//    private void whatSelected(Cell cell){
//        String piece = cell.getPiece();
//        if (piece.equals(pack.pieces[0])){
//            app.changeBackGround(cell.getRow(), chars[col.indexOf(cell.getColumn())+1], Color.darkGray);
//            app.changeBackGround(cell.getRow(), chars[col.indexOf(cell.getColumn())-1], Color.darkGray);
//
//        }
//    }
}
