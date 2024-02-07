package Classes;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class GameManager {
    public GameManager(Application app, PiecePack pack) {
        this.app = app;
        this.pack = pack;
        setKingLoc(0, "1g");
        setKingLoc(1, "10g");
        fileToMap();
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
    Map<String, Cell> whitePieces = new HashMap<>();
    Map<String, Cell> blackPieces = new HashMap<>();

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
        changePiece();
        lcell.setPiece(null);
        lcell.setTcolor(null);
        lcell.setBcolor(null);
        if (ncell.getPiece().equals(PieceName.BLACK_KING)) {
            setKingLoc(1, "" + ncell.getRow() + ncell.getColumn());
        }
        if (ncell.getPiece().equals(PieceName.WHITE_KING)) {
            setKingLoc(0, "" + ncell.getRow() + ncell.getColumn());
        }
        app.setCellProperties(ncell.getRow(), ncell.getColumn(), ncell.getPiece(), null, ncell.getTcolor());
        app.setCellProperties(lcell.getRow(), lcell.getColumn(), null, null, null);
        lBColor = null;
        ClearBackGrounds();
        changeCheckColor();
        mapToFile();
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
        cell.setRound(3);
        StringColor[] temp = new StringColor[removed.length + 1];
        for (int i = 0; i < removed.length; i++) {
            temp[i] = removed[i];
        }
        if (cell.getTcolor() == Color.BLACK) {
            temp[temp.length - 1] = new StringColor(cell.getPiece(), StringColor.BLACK);
            blackPieces.remove("" + row + column);
        } else {
            temp[temp.length - 1] = new StringColor(cell.getPiece(), StringColor.WHITE);
            whitePieces.remove("" + row + column);
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
                isCheck();
                ClearBackGrounds();
                changeCheckColor();
                changeBackgroundColor(sCell, row, column, Color.BLUE);
            }
        } catch (Exception e) {

        }
    }

    public void createNewBoard(){

    }
    public void arrangeBoard() {
        app.setMessage(turn + "'s Turn");
        for (char c : chars) {
            col.add(c);
            for (int i = 1; i <= 11; i++) {
                try {
                    bBoard.put("" + i + c, new Cell(null, null, null, i, c, 2));
                } catch (Exception e) {

                }
            }
        }
        for (int i = 0; i < pack.num; i++) {
            int round = 2;
            if (pack.wpiece[i].equals(PieceName.WHITE_PAWN) || pack.bpiece[i].equals(PieceName.BLACK_PAWN)) {
                round = 1;
            }
            app.setCellProperties(pack.wrow[i], pack.wcol[i], pack.wpiece[i], null, Color.WHITE);
            bBoard.put("" + pack.wrow[i] + pack.wcol[i], new Cell(null, pack.wpiece[i], Color.WHITE, pack.wrow[i], pack.wcol[i], round));
            whitePieces.put("" + pack.wrow[i] + pack.wcol[i], new Cell(null, pack.wpiece[i], Color.WHITE, pack.wrow[i], pack.wcol[i], round));
            app.setCellProperties(pack.brow[i], pack.bcol[i], pack.bpiece[i], null, Color.BLACK);
            bBoard.put("" + pack.brow[i] + pack.bcol[i], new Cell(null, pack.bpiece[i], Color.BLACK, pack.brow[i], pack.bcol[i], round));
            blackPieces.put("" + pack.brow[i] + pack.bcol[i], new Cell(null, pack.bpiece[i], Color.BLACK, pack.brow[i], pack.bcol[i], round));
        }
    }

    private void isCheck() {
        whiteCheck();
        blackCheck();
    }

    boolean whiteCheck = false;
    boolean blackCheck = false;

    private void changeCheckColor() {
        if (whiteCheck) {
            app.changeBackGround(bBoard.get(kingLoc[0]).getRow(), bBoard.get(kingLoc[0]).getColumn(), Color.YELLOW);
        } else if (blackCheck) {
            app.changeBackGround(bBoard.get(kingLoc[1]).getRow(), bBoard.get(kingLoc[1]).getColumn(), Color.YELLOW);
            mapToFile();
        }
    }

    private void whiteCheck() {
        for (Cell cell : blackPieces.values()) {
            checkRule(cell);
            if (bBoard.get(kingLoc[0]).getBcolor() == Color.darkGray) {
                whiteCheck = true;
                break;
            } else {
                whiteCheck = false;
            }
        }
    }

    private void blackCheck() {
        for (Cell cell : whitePieces.values()) {
            checkRule(cell);
            if (bBoard.get(kingLoc[1]).getBcolor() == Color.darkGray) {
                blackCheck = true;
            } else {
                blackCheck = false;
            }
        }
    }

    private void changePiece() {
        if (lcell.getTcolor() == Color.white) {
            whitePieces.put("" + row + column, new Cell(null, lcell.getPiece(), lcell.getTcolor(), row, column, 1));
            whitePieces.remove("" + lrow + lcol);
        } else if (lcell.getTcolor() == Color.BLACK) {
            blackPieces.put("" + row + column, new Cell(null, lcell.getPiece(), lcell.getTcolor(), row, column, 1));
            blackPieces.remove("" + lrow + lcol);
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

    String[] kingLoc = new String[2];

    public void setKingLoc(int i, String location) {
        this.kingLoc[i] = location;
    }

    public void mapToFile() {
        try {
            // مسیر فولدر خروجی
            String outputFolderPath = "src/data/";

            // ایجاد شیء File برای فولدر خروجی
            File outputFolder = new File(outputFolderPath);

            // ایجاد فولدر اگر وجود نداشته باشد
            outputFolder.mkdirs();

            // مسیر فایل خروجی
            String outputFile = outputFolderPath + "cache.txt";

            // ایجاد FileWriter برای نوشتن در فایل خروجی
            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Cell cell : bBoard.values()) {
                String color = null;
                if (cell.getTcolor() == Color.BLACK) {
                    color = "Black";
                } else if (cell.getTcolor() == Color.WHITE) {
                    color = "White";
                }
                bufferedWriter.write(cell.getKey() + ": " + cell.getRow() + ", " + cell.getColumn() + ", " + cell.getPiece() + ", " + color + ", " + cell.getRound());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Success!");
        } catch (IOException e) {
            System.out.println("Failed!");
        }
    }

    public void fileToMap() {
        try {
            String outputFolderPath = "src/data/";
            String outputFile = outputFolderPath + "cache.txt";
            FileReader fileReader = new FileReader(outputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // جدا کردن اطلاعات مختلف از هر خط
                String[] parts = line.split(": ");
                String key = parts[0];
                String[] cellData = parts[1].split(", ");
                int row = Integer.parseInt(cellData[0]);
                char column = cellData[1].charAt(0);
                String piece = cellData[2];
                String tcolor = cellData[3];
                int round = Integer.parseInt(cellData[4]);
                Color color = null;
                if (tcolor.equals("Black")) {
                    color = Color.BLACK;
                } else if (tcolor.equals("White")) {
                    color = Color.WHITE;
                }
                Cell cell = new Cell(null, piece, color, row, column, round);
                bBoard.put(key, cell);
            }
            bufferedReader.close();
            fileReader.close();
            System.out.println("Success!");
        } catch (IOException e) {
            System.out.println("Failed!");
        }
    }

    public void arrangeBoardByFile() {
        for (Cell cell : bBoard.values()) {
            try {
                if (!Objects.equals(cell.getPiece(), "null")) {
                    app.setCellProperties(cell.getRow(), cell.getColumn(), cell.getPiece(), null, cell.getTcolor());
                }
            } catch (Exception e) {

            }
        }
    }
}

