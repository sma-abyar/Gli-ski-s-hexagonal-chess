package train;

import java.awt.Color;
import java.io.File;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.HexagonCell;
import ir.sharif.math.bp02_1.hex_chess.graphics.panel.BoardPanel;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

public class changeBackColor implements EventListener {
    Application app;
    PiecePack data;
    BoardPanel panel;
    int lrow;
    char lcol;
    Color dtcolor;
    String dPiece;

    public changeBackColor(Application app, PiecePack data) {
        this.app = app;
        this.data = data;
    }

    public void onClick(int row, char col) {
        app.changeBackGround(row, col, Color.BLUE);
        if ((row != lrow) || (col != lcol)){
            app.changeBackGround(lrow, lcol, null);
        }
        lrow = row;
        lcol = col;
//        HexagonCell cell = new HexagonCell();
//        cell.setBackGroundColor(Color.BLUE);
        /*
         * for (int i = 0; i < data.row.length; i++){
         * try {
         * if (row == data.row[i]) {
         * for (int j = 0; j<data.col.length ; j++){
         * if (col == data.col[j]) {
         * System.out.println(data.row[i]);
         * dPiece = data.name[i];
         * dtcolor = data.tColor[i];
         * System.out.println(dtcolor);
         * app.setCellProperties(row, col, dPiece, Color.blue, dtcolor);
         * app.setCellProperties(lrow, lcol, null, null, Color.white);
         * lrow = row;
         * lcol = col;
         * }
         * }
         * 
         * }
         * } catch (Exception e) {
         * // TODO: handle exception
         * }
         * }
         
        for (int i = 0; i < data.row.length; i++) {
            try {
                if (row == data.row[i]) {
                    for (int j = 0; j < data.col.length; j++) {
                        if (col == data.col[j]) {
                            dPiece = data.piece[i];
                            dtcolor = data.tColor[i];
                            app.setCellProperties(row, col, dPiece, Color.blue, dtcolor);
                            System.out.println(dPiece);
                        }
                    }
                }if(row != data.row[i]){
                    dPiece = null;
                    dtcolor = null;
                    app.setCellProperties(row, col, dPiece, Color.blue, dtcolor);
                    app.setCellProperties(lrow, lcol, dPiece, null, dtcolor);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
        lrow = row;
        lcol = col;
        */
    }

    @Override
    public void onLoad(File file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onLoad'");
    }

    @Override
    public void onSave(File file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onSave'");
    }

    @Override
    public void onNewGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onNewGame'");
    }
}
