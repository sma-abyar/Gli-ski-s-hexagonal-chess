import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.SystemOutEventListener;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;
import train.PiecePack;
import train.changeBackColor;

import java.awt.*;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;

public class Main {
    public static void main(String[] args) {
        PiecePack data = new PiecePack();
        Application application = new Application();
        application.registerEventListener(new SystemOutEventListener());
        application.setCellProperties(6, 'l', PieceName.WHITE_BISHOP, null, Color.WHITE);
        application.setCellProperties(data.row[6], data.col[6], data.piece[6], null, Color.WHITE);
        application.setRemovedPieces(new StringColor[]{
                new StringColor(PieceName.BLACK_BISHOP, StringColor.BLACK),
                new StringColor(PieceName.WHITE_BISHOP, StringColor.WHITE)
        });
        
        application.setMessage("White's Turn");
        application.registerEventListener(new changeBackColor(application, data));
        data.setPieces(application);
    }
}