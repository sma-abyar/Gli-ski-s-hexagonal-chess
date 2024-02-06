package trian3;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;
import train2.Cell;
import train2.GameManager;

import java.awt.*;
import java.util.HashMap;
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
    Map<String, Cell> knightTarget = new HashMap<>();

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
        } else if (name.equals(PieceName.BLACK_KNIGHT) || name.equals(PieceName.WHITE_KNIGHT)) {
            Knight();
        }
    }

    private void Rock() {
        direct_movement(false);
    }

    private void Bishop() {
        oblique_movement(false);
    }

    private void blackPawn() {
        if (sCell.getRound() == 1) {
            if (board.get("" + (row - 2) + chars[charn]).getPiece() == null) {
                changeBackGroundColor(row - 2, chars[charn], Color.lightGray);
            }
        }
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
        if (sCell.getRound() == 1) {
            if (board.get("" + (row + 2) + chars[charn]).getPiece() == null) {
                changeBackGroundColor(row + 2, chars[charn], Color.lightGray);
            }
        }
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

    private void direct_movement(boolean limited) {
        Cell cell = board.get("" + row + col);
        int[][] changes_rate_array;
        if (charn > 5) {
            changes_rate_array = new int[][]{{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}};
        } else if (charn == 5) {
            changes_rate_array = new int[][]{{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};
        } else {
            changes_rate_array = new int[][]{{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}};
        }

        for (int[] cell_change_rate : changes_rate_array) {
            recursive_direct_movement(cell, cell_change_rate, limited);
        }
    }

    private void oblique_movement(boolean limited) {
        Cell cell = board.get("" + row + col);
        int[][] changes_rate_array;

        if (charn > 5) {
            changes_rate_array = new int[][]{{1, 1}, {2, -1}, {1, -2}, {-1, -1}, {-2, 1}, {-1, 2}};
        } else if (charn == 5) {
            changes_rate_array = new int[][]{{1, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-1, 1}};
        } else {
            changes_rate_array = new int[][]{{1, 2}, {2, 1}, {1, -1}, {-1, -2}, {-2, -1}, {-1, 1}};
        }

        for (int[] cell_change_rate : changes_rate_array) {
            recursive_oblique_movement(cell, cell_change_rate, limited);
        }
    }

    private void Queen() {
        direct_movement(false);
        oblique_movement(false);
    }

    private void King() {
        oblique_movement(true);
        direct_movement(true);
    }

    int j = 0;

    private void Knight() {
        knightTarget.clear();
        Cell cell = board.get("" + row + col);
        int[][] changes_rate_array;
        if (charn > 5) {
            changes_rate_array = new int[][]{{1, 1}, {2, -1}, {1, -2}, {-1, -1}, {-2, 1}, {-1, 2}};
        } else if (charn == 5) {
            changes_rate_array = new int[][]{{1, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-1, 1}};
        } else {
            changes_rate_array = new int[][]{{1, 2}, {2, 1}, {1, -1}, {-1, -2}, {-2, -1}, {-1, 1}};
        }

        for (int[] cell_change_rate : changes_rate_array) {
            int newRow = cell.getRow() + cell_change_rate[1];
            int newColumn = charnum.indexOf(cell.getColumn()) + cell_change_rate[0];
            if (newColumn == 5 && (cell_change_rate[1] == 2 || cell_change_rate[1] == -1)) {
                cell_change_rate[1]--;

            } else if (cell_change_rate[0] == 2 || cell_change_rate[0] == -2) {

                if (newColumn == 5) {
                    cell_change_rate[1] -= 2;
                } else if (newColumn == 4 || newColumn == 6) {
                    cell_change_rate[1] = 0;
                    if (charn == 4 || charn == 6) {
                        newRow = row;
                    }
                    if ((charn < 5 && newColumn > 5) || charn > 5 && newColumn < 5) {
                        cell_change_rate[1] = -1;
                    }
                }
            }
            KnightLv2(newRow, newColumn);
        }

        for (Cell target_cell : knightTarget.values()) {
            try {
                int target_row = target_cell.getRow();
                int target_column = charnum.indexOf(target_cell.getColumn());
                changeBackGroundColor(target_row, chars[target_column], Color.lightGray);

            } catch (Exception e) {

            }
        }
    }

    private void KnightLv2(int row, int column) {
        int[][] changes_rate_array;

        if (column > 5) {
            changes_rate_array = new int[][]{{0, 1}, {1, 0}, {1, -1}, {0, -1},
                    {-1, 0}, {-1, 1}};
        } else if (column == 5) {
            changes_rate_array = new int[][]{{0, 1}, {1, 0}, {1, -1}, {0, -1},
                    {-1, -1}, {-1, 0}};
        } else {
            changes_rate_array = new int[][]{{0, 1}, {1, 1}, {1, 0}, {0, -1}, {
                    -1, -1}, {-1, 0}};
        }

        for (int[] cell_change_rate : changes_rate_array) {
            add_to_targets(row, column, cell_change_rate);
        }
    }

    private void add_to_targets(int row, int column, int[] cell_change_rate) {

        int newRow = row + cell_change_rate[1];
        int newColumn = column + cell_change_rate[0];

        if ((newRow >= 1 && newRow <= 11) && (newColumn >= 0 && newColumn <= 10)) {
            Cell cell = board.get("" + newRow + chars[newColumn]);
            String key = "" + newRow + chars[newColumn];
            try {
                if (!knightTarget.containsKey(key)) {
                    knightTarget.put(key, cell);
                } else {
                    knightTarget.remove(key);
                }
            } catch (Exception e) {
            }

        }
    }

    private void recursive_direct_movement(Cell cell, int[] cell_change_rate, boolean limited) {
        int row = cell.getRow();
        int column = charnum.indexOf(cell.getColumn());
        int newRow = row + cell_change_rate[1];
        int newColumn = column + cell_change_rate[0];

        if (newColumn == 5 && cell_change_rate[0] != 0) {
            cell_change_rate[1]--;
        }

        try {
            changeBackGroundColor(newRow, chars[newColumn], Color.lightGray);
            Cell newCell = board.get("" + newRow + chars[newColumn]);
            if (newCell.getPiece() != null || limited) {
                return;
            }

            recursive_direct_movement(newCell, cell_change_rate, limited);
        } catch (Exception e) {

        }
    }

    private void recursive_oblique_movement(Cell cell, int[] cell_change_rate, boolean limited) {
        int row = cell.getRow();
        int column = charnum.indexOf(cell.getColumn());
        int newRow = row + cell_change_rate[1];
        int newColumn = column + cell_change_rate[0];

        if (newColumn == 5 && (cell_change_rate[1] == 2 || cell_change_rate[1] == -1)) {
            cell_change_rate[1]--;

        } else if (cell_change_rate[0] == 2 || cell_change_rate[0] == -2) {

            if (newColumn == 5) {
                cell_change_rate[1] -= 2;
            } else if (newColumn == 4 || newColumn == 6) {
                cell_change_rate[1] = 0;
                if (column == 4 || column == 6) {
                    newRow = row;
                }
                if ((column < 5 && newColumn > 5) || column > 5 && newColumn < 5) {
                    cell_change_rate[1] = -1;
                }
            }
        }

        try {
            changeBackGroundColor(newRow, chars[newColumn], Color.lightGray);
            Cell newCell = board.get("" + newRow + chars[newColumn]);
            if (newCell.getPiece() != null || limited) {
                return;
            }
            recursive_oblique_movement(newCell, cell_change_rate, limited);
        } catch (Exception e) {

        }
    }

    private void changeBackGroundColor(int row, char col, Color color) {
        try {
            Cell cell = board.get("" + row + col);
            if (sCell.getTcolor() != cell.getTcolor()) {
                cell.setBcolor(color);
                app.changeBackGround(row, col, color);
                if (cell.getPiece() != null && (!Objects.equals(sCell.getPiece(), BLACK_PAWN)
                        && !Objects.equals(sCell.getPiece(), WHITE_PAWN))) {
                    cell.setBcolor(Color.DARK_GRAY);
                    app.changeBackGround(row, col, Color.DARK_GRAY);
                }
            }
        } catch (Exception e) {
        }
    }
}