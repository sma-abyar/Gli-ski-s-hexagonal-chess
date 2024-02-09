import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.SystemOutEventListener;
import Classes.PiecePack;
import Classes.Listener;
import Classes.GameManager;

public class Main {
    public static void main(String[] args) {
        PiecePack pack = new PiecePack();
        Application application = new Application();
        GameManager game = new GameManager(application, pack);
        game.arrangeBoard();
        application.registerEventListener(new SystemOutEventListener());
        application.registerEventListener(new Listener(game));
    }
}