package trian3;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;
import train2.Cell;
import train2.GameManager;

import java.awt.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import static ir.sharif.math.bp02_1.hex_chess.util.PieceName.BLACK_PAWN;
import static ir.sharif.math.bp02_1.hex_chess.util.PieceName.WHITE_PAWN;

public class Rules {
    String charnum;
    Application app;
    Cell sCell;
    char[] chars;
    int row;
    char col;
    int charn;
    int round;
    int[][] rcolored;
    int[][] ccolored;
    Map<String, Cell> board;

    public void Movement(GameManager board, Cell cell) {
        this.sCell = cell;
        this.charnum = board.getCharnum();
        this.app = board.getApp();
        this.chars = board.getChars();
        this.row = cell.getRow();
        this.col = cell.getColumn();
        this.charn = charnum.indexOf(col);
        this.round = cell.getRound();
        this.board = board.getbBoard();
        String name = cell.getPiece();
        if (name.equals(WHITE_PAWN)) {
            whitePawn();
        } else if (name.equals(BLACK_PAWN)) {
            blackPawn();
        } else if (name.equals(PieceName.WHITE_ROCK) || name.equals(PieceName.BLACK_ROCK)) {
            Rock();
        } else if (name.equals(PieceName.BLACK_BISHOP) || name.equals(PieceName.WHITE_BISHOP)) {
            Bishop();
        } else if (name.equals(PieceName.BLACK_QUEEN) || name.equals(PieceName.WHITE_QUEEN)) {
            Queen();
        } else if (name.equals(PieceName.BLACK_KING) || name.equals(PieceName.WHITE_KING)) {
            King();
        }
    }

    private void blackPawn() {
        if (charn == 0) {
            if (board.get("" + (row) + chars[charn + 1]).getPiece() != null) {
                changeBackGroundColor(row, chars[charn + 1], Color.darkGray);
            }
            if (board.get("" + (row - 1) + chars[charn]).getPiece() == null) {
                changeBackGroundColor(row - 1, chars[charn], Color.lightGray);
            }
        } else if (charn == 10) {
            if (board.get("" + (row) + chars[charn - 1]).getPiece() != null) {
                changeBackGroundColor(row, chars[charn - 1], Color.darkGray);
            }
            if (board.get("" + (row - 1) + chars[charn]).getPiece() == null) {
                changeBackGroundColor(row - 1, chars[charn], Color.lightGray);
            }
        } else if (charn == 5) {
            if (board.get("" + (row - 1) + chars[charn + 1]).getPiece() != null) {
                changeBackGroundColor(row - 1, chars[charn + 1], Color.darkGray);
            }

            if (board.get("" + (row - 1) + chars[charn - 1]).getPiece() != null) {
                changeBackGroundColor(row - 1, chars[charn - 1], Color.darkGray);
            }
            if (board.get("" + (row - 1) + chars[charn]).getPiece() == null) {
                changeBackGroundColor(row - 1, chars[charn], Color.lightGray);
            }
        } else if (charn < 5) {
            if (board.get("" + (row) + chars[charn + 1]).getPiece() != null) {
                changeBackGroundColor(row, chars[charn + 1], Color.darkGray);
            }
            if (board.get("" + (row - 1) + chars[charn - 1]).getPiece() != null) {
                changeBackGroundColor(row - 1, chars[charn - 1], Color.darkGray);
            }
            if (board.get("" + (row - 1) + chars[charn]).getPiece() == null) {
                changeBackGroundColor(row - 1, chars[charn], Color.lightGray);
            }
        } else {
            if (board.get("" + (row - 1) + chars[charn + 1]).getPiece() != null) {
                changeBackGroundColor(row - 1, chars[charn + 1], Color.darkGray);
            }
            if (board.get("" + (row) + chars[charn - 1]).getPiece() != null) {
                changeBackGroundColor(row, chars[charn - 1], Color.darkGray);
            }
            if (board.get("" + (row - 1) + chars[charn]).getPiece() == null) {
                changeBackGroundColor(row - 1, chars[charn], Color.lightGray);
            }
        }
        round++;
    }

    private void whitePawn() {
        if (charn == 0) {
            if (board.get("" + (row + 1) + chars[charn + 1]).getPiece() != null) {
                changeBackGroundColor(row + 1, chars[charn + 1], Color.darkGray);
            }
            if (board.get("" + (row + 1) + chars[charn]).getPiece() == null) {
                changeBackGroundColor(row + 1, chars[charn], Color.lightGray);
            }
        } else if (charn == 10) {
            if (board.get("" + (row + 1) + chars[charn - 1]).getPiece() != null) {
                changeBackGroundColor(row, chars[charn + 1], Color.darkGray);
            }
            if (board.get("" + (row + 1) + chars[charn]).getPiece() == null) {
                changeBackGroundColor(row + 1, chars[charn], Color.lightGray);
            }
        } else if (charn == 5) {
            if (board.get("" + (row) + chars[charn + 1]).getPiece() != null) {
                if (board.get("" + (row + 1) + chars[charn]).getPiece() == null) {
                    changeBackGroundColor(row + 1, chars[charn], Color.lightGray);
                }
            }
            if (board.get("" + (row) + chars[charn - 1]).getPiece() != null) {
                changeBackGroundColor(row, chars[charn - 1], Color.darkGray);
            }
            if (board.get("" + (row + 1) + chars[charn]).getPiece() == null) {
                changeBackGroundColor(row + 1, chars[charn], Color.lightGray);
            }
        } else if (charn < 5) {
            if (board.get("" + (row + 1) + chars[charn + 1]).getPiece() != null) {
                changeBackGroundColor(row + 1, chars[charn + 1], Color.darkGray);
            }
            if (board.get("" + (row) + chars[charn - 1]).getPiece() != null) {
                changeBackGroundColor(row, chars[charn - 1], Color.darkGray);
            }
            if (board.get("" + (row + 1) + chars[charn]).getPiece() == null) {
                changeBackGroundColor(row + 1, chars[charn], Color.lightGray);
            }
        } else {
            if (board.get("" + (row) + chars[charn + 1]).getPiece() != null) {
                changeBackGroundColor(row, chars[charn + 1], Color.darkGray);
            }
            if (board.get("" + (row + 1) + chars[charn - 1]).getPiece() != null) {
                changeBackGroundColor(row + 1, chars[charn - 1], Color.darkGray);
            }
            if (board.get("" + (row + 1) + chars[charn]).getPiece() == null) {
                changeBackGroundColor(row + 1, chars[charn], Color.lightGray);
            }
        }
        round++;
    }

    private void Rock() {
        Cell cell = board.get(""+row+col);
//        StraightMove();
        int[][] hamsade = new int[6][2];
        if(charn>5){
            hamsade = new int[][]{{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}};
        }else if (charn==5){
            hamsade = new int[][]{{0,1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};
        }else{
            hamsade = new int[][]{{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}};
        }
        test1(cell, hamsade);
    }

    private void Bishop() {
        ObliqueMove();
    }

    private void Queen() {
        StraightMove();
        ObliqueMove();
    }

    private void King() {
        whitePawn();
        blackPawn();
        Cell cell;
        if (charn == 5) {
            try {
                cell = board.get("" + (row - 1) + chars[charn + 2]);
                if (cell.getPiece() == null) {
                    changeBackGroundColor(row - 1, chars[charn + 2], Color.lightGray);
                }
                if (cell.getPiece() != null) {
                    changeBackGroundColor(row - 1, chars[charn + 2], Color.darkGray);
                }
                cell = board.get("" + (row - 1) + chars[charn - 2]);
                if (cell.getPiece() == null) {
                    changeBackGroundColor(row - 1, chars[charn - 2], Color.lightGray);
                }
                if (cell.getPiece() != null) {
                    changeBackGroundColor(row - 1, chars[charn - 2], Color.darkGray);
                }
                cell = board.get("" + (row + 1) + chars[charn + 1]);
                if (cell.getPiece() == null) {
                    changeBackGroundColor(row + 1, chars[charn + 1], Color.lightGray);
                }
                if (cell.getPiece() != null) {
                    changeBackGroundColor(row + 1, chars[charn + 1], Color.darkGray);
                }
                cell = board.get("" + (row + 1) + chars[charn - 1]);
                if (cell.getPiece() == null) {
                    changeBackGroundColor(row + 1, chars[charn - 1], Color.lightGray);
                }
                if (cell.getPiece() != null) {
                    changeBackGroundColor(row + 1, chars[charn - 1], Color.darkGray);
                }
                cell = board.get("" + (row - 2) + chars[charn + 1]);
                if (cell.getPiece() == null) {
                    changeBackGroundColor(row - 2, chars[charn + 1], Color.lightGray);
                }
                if (cell.getPiece() != null) {
                    changeBackGroundColor(row - 2, chars[charn + 1], Color.darkGray);
                }
                cell = board.get("" + (row - 2) + chars[charn - 1]);
                if (cell.getPiece() == null) {
                    changeBackGroundColor(row - 2, chars[charn - 1], Color.lightGray);
                }
                if (cell.getPiece() != null) {
                    changeBackGroundColor(row - 2, chars[charn - 1], Color.darkGray);
                }
            } catch (Exception e) {
            }
        }
        //سمت راست
        else if (charn > 5) {
            try {
                cell = board.get("" + (row - 1) + chars[charn + 2]);
                if (cell.getPiece() == null) {
                    changeBackGroundColor(row - 1, chars[charn + 2], Color.lightGray);
                }
                if (cell.getPiece() != null) {
                    changeBackGroundColor(row - 1, chars[charn + 2], Color.darkGray);
                }
                cell = board.get("" + (row) + chars[charn - 2]);
                if (cell.getPiece() == null) {
                    changeBackGroundColor(row, chars[charn - 2], Color.lightGray);
                }
                if (cell.getPiece() != null) {
                    changeBackGroundColor(row, chars[charn - 2], Color.darkGray);
                }
                cell = board.get("" + (row + 1) + chars[charn + 1]);
                if (cell.getPiece() == null) {
                    changeBackGroundColor(row + 1, chars[charn + 1], Color.lightGray);
                }
                if (cell.getPiece() != null) {
                    changeBackGroundColor(row + 1, chars[charn + 1], Color.darkGray);
                }
                cell = board.get("" + (row + 1) + chars[charn - 1]);
                if (cell.getPiece() == null) {
                    changeBackGroundColor(row + 1, chars[charn - 1], Color.lightGray);
                }
                if (cell.getPiece() != null) {
                    changeBackGroundColor(row + 1, chars[charn - 1], Color.darkGray);
                }
                cell = board.get("" + (row - 2) + chars[charn + 1]);
                if (cell.getPiece() == null) {
                    changeBackGroundColor(row - 2, chars[charn + 1], Color.lightGray);
                }
                if (cell.getPiece() != null) {
                    changeBackGroundColor(row - 2, chars[charn + 1], Color.darkGray);
                }
                cell = board.get("" + (row - 1) + chars[charn - 1]);
                if (cell.getPiece() == null) {
                    changeBackGroundColor(row - 1, chars[charn - 1], Color.lightGray);
                }
                if (cell.getPiece() != null) {
                    changeBackGroundColor(row - 1, chars[charn - 1], Color.darkGray);
                }
                cell = board.get("" + (row + 2) + chars[charn - 1]);
                if (cell.getPiece() == null) {
                    changeBackGroundColor(row + 2, chars[charn - 1], Color.lightGray);
                }
                if (cell.getPiece() != null) {
                    changeBackGroundColor(row + 2, chars[charn - 1], Color.darkGray);
                }
            } catch (Exception e) {
            }
        }

    }


    private void StraightMove() {

    }
    private void test1(Cell cell, int[][] arr){
        String piece = cell.getPiece();
        boolean reverse = false;
        for (int[] next: arr){
            test2(cell, next, reverse);
        }
    }
    private void test2(Cell cell, int[] arr, boolean reverse){
        int row = cell.getRow();
        int column = charnum.indexOf(cell.getColumn());
        if (column == 5 && reverse){
            arr[1]--;
        }
        row += arr[1];
        column += arr[0];
        try{
            changeBackGroundColor(row, chars[column], Color.lightGray);
            Cell newCell = board.get(""+row+chars[column]);
            if(newCell.getPiece()!=null){
                return;
            }
            reverse = true;
            test2(newCell, arr, reverse);
        }catch (Exception e){

        }
    }

    private void ObliqueMove() {
    }

    private void mObliqueMove() {
        Cell cell;
        StraightMove();
        for (int i = 0; i < 11; i++) {
            Cell cell1;
            Cell cell2;
            int[] row = new int[3];
            int[] col = new int[3];
            try {
                row[0] = rcolored[1][i];
                row[1] = rcolored[2][i];
                col[0] = ccolored[1][i];
                col[1] = ccolored[2][i];
                row[2] = (row[0] + row[1]) / 2;
                col[2] = (col[0] + col[1]) / 2;
                changeBackGroundColor(row[2], chars[col[2]], Color.lightGray);
            } catch (Exception e) {
                continue;
            }

        }
    }

    private void changeBackGroundColor(int row, char col, Color color) {
        try {
            Cell cell = board.get("" + row + col);
            if (sCell.getTcolor() != cell.getTcolor()) {
                cell.setBcolor(color);
                app.changeBackGround(row, col, color);
                if (cell.getPiece() != null && (!Objects.equals(sCell.getPiece(), BLACK_PAWN) && !Objects.equals(sCell.getPiece(), WHITE_PAWN))) {
                    cell.setBcolor(Color.DARK_GRAY);
                    app.changeBackGround(row, col, Color.DARK_GRAY);
                }
            }
        } catch (Exception e) {
        }
    }
    private void testChangeColor(Cell cell){

    }
}