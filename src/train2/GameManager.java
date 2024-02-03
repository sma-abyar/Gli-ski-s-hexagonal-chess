package train2;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;
import train.PiecePack;
import trian3.Rules;

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
    protected Rules rules = new Rules();
    StringColor[] removed = new StringColor[0];
    int lastRemovedItem = 0;
    Map<String, Cell> bBoard = new HashMap<>();
    int lrow;
    char lcol;
    Color lBColor;
    public List<Character> col = new ArrayList<>();
    char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l'};
    String charnum = "abcdefghikl";
    String turn = "White";


    private void Move(Cell lcell, Cell ncell) {
        ncell.setPiece(lcell.getPiece());
        ncell.setTcolor(lcell.getTcolor());
        lcell.setPiece(null);
        lcell.setTcolor(null);
        lcell.setBcolor(null);
        app.setCellProperties(ncell.getRow(), ncell.getColumn(), ncell.getPiece(), null, ncell.getTcolor());
        app.setCellProperties(lcell.getRow(), lcell.getColumn(), null, null, null);
        lBColor = null;
        ClearBackGrounds();
        turnDetect();
    }

    public void turnDetect() {
        if (turn.equals("White")) {
            turn = "Black";
        } else if (turn.equals("Black")) {
            turn = "White";
        }
        app.setMessage(turn + "'s Turn");
    }

    private void removePiece(Cell cell) {
        StringColor[] temp = new StringColor[removed.length + 1];
        for (int i = 0; i < removed.length; i++) {
            temp[i] = removed[i];
        }
        if (cell.getTcolor() == Color.BLACK) {
            temp[temp.length - 1] = new StringColor(cell.getPiece(), StringColor.BLACK);
        } else {
            temp[temp.length - 1] = new StringColor(cell.getPiece(), StringColor.WHITE);
        }
        lastRemovedItem++;
        removed = temp;
        try {
            app.setRemovedPieces(removed);
        } catch (Exception e) {
        }
    }

    private void changeBackgroundColor(Cell cell, int row, char col, Color color) {
        if ((row != lrow) || (col != lcol)) {
            app.changeBackGround(lrow, lcol, null);
        }
        app.changeBackGround(row, col, color);
        lrow = row;
        lcol = col;
        lcell = cell;
        lBColor = color;
    }

    public void clicked(int row, char column) {
        this.row = row;
        this.column = column;
        try {
            sCell = bBoard.get("" + row + column);
            if (lBColor == Color.GREEN) {
                if (sCell.getTcolor() != lcell.getTcolor()) {
                    if (sCell.getBcolor() == Color.darkGray) {
                        removePiece(sCell);
                        Move(lcell, sCell);
                    }
                    if (sCell.getBcolor() == Color.lightGray) {
                        Move(lcell, sCell);
                    }
                }
            }
            if (sCell.getTcolor() != null && (lBColor == Color.BLUE)) {
                ClearBackGrounds();
                if ((sCell.getTcolor() == Color.white && turn.equals("White")) || ((sCell.getTcolor() == Color.black && turn.equals("Black")))) {
                    changeBackgroundColor(sCell, row, column, Color.GREEN);
                    checkRule(sCell);
                    System.out.println(row + "" + column + sCell.getPiece());
                }
            } else {
                ClearBackGrounds();
                changeBackgroundColor(sCell, row, column, Color.BLUE);
            }
        } catch (Exception e) {

        }
    }

    public void arrangeBoard() {
        app.setMessage(turn + "'s Turn");
        for (char c : chars) {
            col.add(c);
            for (int i = 0; i < 11; i++) {
                try {
                    bBoard.put("" + i + c, new Cell(null, null, null, i, c));
                } catch (Exception e) {

                }
            }
        }
        for (int i = 0; i < pack.num; i++) {
            app.setCellProperties(pack.wrow[i], pack.wcol[i], pack.wpiece[i], null, Color.WHITE);
            bBoard.put("" + pack.wrow[i] + pack.wcol[i], new Cell(null, pack.wpiece[i], Color.WHITE, pack.wrow[i], pack.wcol[i]));
            app.setCellProperties(pack.brow[i], pack.bcol[i], pack.bpiece[i], null, Color.BLACK);
            bBoard.put("" + pack.brow[i] + pack.bcol[i], new Cell(null, pack.bpiece[i], Color.BLACK, pack.brow[i], pack.bcol[i]));
        }

    }

    public void checkRule(Cell cell) {
        rules.Movement(this, cell);
    }

    public void ClearBackGrounds() {
        for (char c : chars) {
            for (int i = 1; i <= 11; i++) {
                try {
                    app.changeBackGround(i, c, null);
                    bBoard.get("" + i + c).setBcolor(null);
                } catch (Exception e) {
                }
            }
        }
    }

    public Application getApp() {
        return app;
    }

    public String getCharnum() {
        return charnum;
    }

    public char[] getChars() {
        return chars;
    }

    public Map<String, Cell> getbBoard() {
        return bBoard;
    }

}
