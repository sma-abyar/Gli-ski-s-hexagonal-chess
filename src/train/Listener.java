package train;

import java.awt.Color;
import java.io.File;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;
import train2.Cell;
import train2.GameManager;


public class Listener implements EventListener {
     Cell cell;
     Cell lcell;
    GameManager game;
    int lrow;
    char lcol;
    Color lBColor;

    public Listener(GameManager game) {
        this.game = game;
    }

    public void onClick(int row, char col) {
        game.clicked(row,col);
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
