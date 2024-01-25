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
    protected Application app;
    protected PiecePack pack;
    private Cell sCell;
    private Cell lcell;

    Map<String, Cell> bBoard = new HashMap<>();
    int lrow;
    char lcol;
    Color lBColor;
    public List<Character> col = new ArrayList<>();
    char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l'};


    private void Move(Cell lcell, Cell ncell){
        int nrow = ncell.getRow();
        char ncol = ncell.getColumn();
        int lrow = lcell.getRow();
        char lcol = lcell.getColumn();
        app.setCellProperties(nrow, ncol, lcell.getPiece(), Color.BLUE, lcell.getTcolor());
        bBoard.put(""+nrow+ncol,new Cell(null, lcell.getPiece(), lcell.getTcolor(), nrow, ncol));
        bBoard.remove(""+lrow+lcol);
        app.setCellProperties(lrow, lcol, null, null, null);
        lBColor = Color.BLUE;
    }
    public void turn(){}
    private void removePiece(){}
    private void changeBackgroundColor(Cell cell, int row, char col, Color color){

        if (lBColor==Color.GREEN){
            Move(lcell, cell);
        }
        if (cell!=null){
            app.changeBackGround(row, col, Color.GREEN);
            lBColor = Color.GREEN;
        }else{
            app.changeBackGround(row, col, Color.blue);
        }
        if ((row != lrow) || (col != lcol)){
            app.changeBackGround(lrow, lcol, null);
        }
        lrow = row;
        lcol = col;
        lcell = cell;
        System.out.println(row+""+col+cell.getPiece());
    }
    public void clicked(int row, char column){
        this.row = row;
        this.column = column;
        try{
            sCell = bBoard.get(""+row+column);
            changeBackgroundColor(sCell, row, column, null);
            whatSelected(sCell);
        }catch (Exception e){
        }
    }
    public void arrangeBoard(){
        for(int i =0; i<pack.num; i++){
            app.setCellProperties(pack.wrow[i], pack.wcol[i], pack.wpiece[i], null, Color.WHITE);
            bBoard.put(""+pack.wrow[i]+pack.wcol[i],new Cell(null, pack.wpiece[i], Color.WHITE, pack.wrow[i], pack.wcol[i]));
            app.setCellProperties(pack.brow[i], pack.bcol[i], pack.bpiece[i], null, Color.BLACK);
            bBoard.put(""+pack.brow[i]+pack.bcol[i],new Cell(null, pack.bpiece[i], Color.BLACK, pack.brow[i], pack.bcol[i]));
        }
        for(char c : chars){
            col.add(c);
        }
    }
    private void whatSelected(Cell cell){
        String piece = cell.getPiece();
        if (piece.equals(pack.pieces[0])){
            app.changeBackGround(cell.getRow(), chars[col.indexOf(cell.getColumn())+1], Color.darkGray);
            app.changeBackGround(cell.getRow(), chars[col.indexOf(cell.getColumn())-1], Color.darkGray);

        }
    }
}
