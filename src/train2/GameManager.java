package train2;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import train.PiecePack;

import java.awt.*;
import java.util.HashMap;
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

    public void Move(Cell lcell, int lrow, char lcol, Cell ncell, int nrow, char ncol){
        app.setCellProperties(nrow, ncol, lcell.getPiece(), Color.BLUE, lcell.getTcolor());
        bBoard.put(""+nrow+ncol,new Cell(null, lcell.getPiece(), lcell.getTcolor()));
        bBoard.remove(""+lrow+lcol);
        app.setCellProperties(lrow, lcol, null, null, null);
        lBColor = Color.BLUE;
    }
    public void turn(){}
    public void removePiece(){}
    public void changeBackgroundColor(Cell cell, int row, char col){
        if (lBColor==Color.GREEN){
            Move(lcell, lrow, lcol, cell, row, col);
        }
        if (cell!=null){
            app.changeBackGround(row, col, Color.GREEN);
            lBColor = Color.GREEN;
        }else{
            app.changeBackGround(row, col, Color.blue);
        }if ((row != lrow) || (col != lcol)){
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
            changeBackgroundColor(sCell, row, column);
        }catch (Exception e){
        }
    }
    public void arrangeBoard(){
        for(int i =0; i<pack.num; i++){
            app.setCellProperties(pack.wrow[i], pack.wcol[i], pack.wpiece[i], null, Color.WHITE);
            bBoard.put(""+pack.wrow[i]+pack.wcol[i],new Cell(null, pack.wpiece[i], Color.WHITE));
            app.setCellProperties(pack.brow[i], pack.bcol[i], pack.bpiece[i], null, Color.BLACK);
            bBoard.put(""+pack.brow[i]+pack.bcol[i],new Cell(null, pack.bpiece[i], Color.BLACK));
        }
    }
}
