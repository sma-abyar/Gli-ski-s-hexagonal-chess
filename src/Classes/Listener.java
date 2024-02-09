package Classes;

import java.io.File;

import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;


public class Listener implements EventListener {
    GameManager game;

    public Listener(GameManager game) {
        this.game = game;
    }

    public void onClick(int row, char col) {
        game.clicked(row, col);
    }

    @Override
    public void onLoad(File file) {
        game.getApp().setRemovedPieces(new StringColor[]{});
        game.clearCells();
        game.arrangeBoardByFile(file);
    }

    @Override
    public void onSave(File file) {
        game.mapToFile(file);
    }

    @Override
    public void onNewGame() {
        game.resetGame();
    }
}
