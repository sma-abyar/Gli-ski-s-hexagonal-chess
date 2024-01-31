import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.SystemOutEventListener;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;
import train.PiecePack;
import train.Listener;

import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;
import train2.GameManager;

public class Main {
    public static void main(String[] args) {
        PiecePack pack = new PiecePack();
        Application application = new Application();
        GameManager game = new GameManager(application,pack);
        game.arrangeBoard();
        application.registerEventListener(new SystemOutEventListener());
//        application.setRemovedPieces(new StringColor[]{
//                new StringColor(PieceName.BLACK_BISHOP, StringColor.BLACK),
//                new StringColor(PieceName.WHITE_BISHOP, StringColor.WHITE)
//        });
        
        application.setMessage("White's Turn");
        application.registerEventListener(new Listener(game));
    }
}