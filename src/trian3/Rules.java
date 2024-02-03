package trian3;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;
import train2.Cell;
import train2.GameManager;

import java.awt.*;
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
                changeBackGroundColor(row, chars[charn + 1], Color.darkGray);
            }
            if (board.get("" + row + chars[charn - 1]).getPiece() != null) {
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
        Cell cell = board.get("" + row + col);
        int[][] hamsade;
        if (charn > 5) {
            hamsade = new int[][]{{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}};
        } else if (charn == 5) {
            hamsade = new int[][]{{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};
        } else {
            hamsade = new int[][]{{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}};
        }
        rockMove(cell, hamsade);
    }

    int[][] hamsadeR;
    int[][] hamsadeC;
    int[][] hamsadeL;

    private void Bishop() {
        Cell cell = board.get("" + row + col);
        if (charn > 5) {
            hamsadeR = new int[][]{{1, 1}, {2, -1}, {1, -2}, {-1, -1}, {-2, 1}, {-1, 2}};
            bishopMove(cell, hamsadeR);
        } else if (charn == 5) {
            hamsadeC = new int[][]{{1, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-1, 1}};
            bishopMove(cell, hamsadeC);
        } else {
            hamsadeL = new int[][]{{1, 2}, {2, 1}, {1, -1}, {-1, -2}, {-2, -1}, {-1, 1}};
            bishopMove(cell, hamsadeL);
        }
    }

    private void Queen() {
        Rock();
        Bishop();
    }

    private void King() {
        Cell cell = board.get("" + row + col);
        int[][] hamsade;
        if (charn > 5) {
            hamsade = new int[][]{{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}};
            hamsadeR = new int[][]{{1, 1}, {2, -1}, {1, -2}, {-1, -1}, {-2, 1}, {-1, 2}};
            kingMove(cell, hamsadeR, "oblique");
        } else if (charn == 5) {
            hamsade = new int[][]{{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};
            hamsadeC = new int[][]{{1, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-1, 1}};
            kingMove(cell, hamsadeC, "oblique");
        } else {
            hamsade = new int[][]{{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}};
            hamsadeL = new int[][]{{1, 2}, {2, 1}, {1, -1}, {-1, -2}, {-2, -1}, {-1, 1}};
            kingMove(cell, hamsadeL, "oblique");
        }
        kingMove(cell, hamsade, "straight");
    }

    private void kingMove(Cell cell, int[][] arr, String kind) {
        int i = 0;
        boolean recursive = false;
        if (kind.equals("oblique")) {
            for (int[] next : arr) {
                bishopMoveRecursive(cell, next, recursive, i, false);
                i++;
            }
        } else if (kind.equals("straight")) {
            for (int[] next : arr) {
                rockMoveRecursive(cell, next, recursive, false);
            }
        }
    }

    private void rockMove(Cell cell, int[][] arr) {
        boolean recursive = false;
        for (int[] next : arr) {
            rockMoveRecursive(cell, next, recursive, true);
        }
    }

    private void rockMoveRecursive(Cell cell, int[] arr, boolean recursive, boolean isContinue) {
        int row = cell.getRow();
        int column = charnum.indexOf(cell.getColumn());
        if (column == 5 && recursive && arr[0] != 0) {
            arr[1]--;
        }
        row += arr[1];
        column += arr[0];
        try {
            changeBackGroundColor(row, chars[column], Color.lightGray);
            Cell newCell = board.get("" + row + chars[column]);
            if (newCell.getPiece() != null) {
                return;
            }
            recursive = true;
            if (isContinue) {
                rockMoveRecursive(newCell, arr, recursive, true);
            }
        } catch (Exception e) {

        }
    }

    private void bishopMove(Cell cell, int[][] arr) {
        boolean recursive = false;
        int i = 0;
        for (int[] next : arr) {
            bishopMoveRecursive(cell, next, recursive, i, true);
            i++;
        }
    }

    boolean corrected = false;

    private void bishopMoveRecursive(Cell cell, int[] arr, boolean recursive, int index, boolean isContinue) {
        try {
            int row = cell.getRow();
            int column = charnum.indexOf(cell.getColumn());
            if (column == 5 && recursive) {
                arr[1] = hamsadeC[index][1];
                arr[0] = hamsadeC[index][0];
            }
            if (charn == 6 && index == 4) {
                column += arr[0];
                changeBackGroundColor(row, chars[column], Color.lightGray);
                Cell newCell = board.get("" + row + chars[column]);
                arr[1] = hamsadeC[index][1];
                arr[0] = hamsadeC[index][0];
                charn = 8;
                if (isContinue) {
                    bishopMoveRecursive(newCell, arr, recursive, index, true);
                }
                return;
            }
            if (charn == 4 && index == 1) {
                column += arr[0];
                changeBackGroundColor(row, chars[column], Color.lightGray);
                Cell newCell = board.get("" + row + chars[column]);
                arr[1] = hamsadeC[index][1];
                arr[0] = hamsadeC[index][0];
                charn = 8;
                if (isContinue) {
                    bishopMoveRecursive(newCell, arr, recursive, index, true);
                }
                return;
            }
            if (((column == 6 && index == 4) || (column == 4 && index == 1)) && recursive && (charn % 2 == 0)) {
                column += arr[0];
                changeBackGroundColor(row, chars[column], Color.lightGray);
                Cell newCell = board.get("" + row + chars[column]);
                arr[1] = hamsadeC[index][1];
                arr[0] = hamsadeC[index][0];
                if (isContinue) {
                    bishopMoveRecursive(newCell, arr, recursive, index, true);
                }
                return;
            }
            recursive = true;
            row += arr[1];
            column += arr[0];
            changeBackGroundColor(row, chars[column], Color.lightGray);
            Cell newCell = board.get("" + row + chars[column]);
            if (newCell.getPiece() != null) {
                return;
            }
            if (isContinue) {
                bishopMoveRecursive(newCell, arr, recursive, index, true);
            }
        } catch (Exception e) {

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
}