package train;

import java.awt.Color;
import java.io.File;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;


public class changeBackColor implements EventListener {
    Application app;
    PiecePack data;
    int lrow;
    char lcol;

    public changeBackColor(Application app, PiecePack data) {
        this.app = app;
        this.data = data;
    }

    public void onClick(int row, char col) {
        app.changeBackGround(row, col, Color.BLUE);
        System.out.println(row+""+col);
        if ((row != lrow) || (col != lcol)){
            app.changeBackGround(lrow, lcol, null);
        }
        lrow = row;
        lcol = col;

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
