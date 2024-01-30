package trian3;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;
import train2.Cell;
import train2.GameManager;
import java.awt.*;
import java.util.Map;

public class Rules {
    String charnum;
    Application app;
    char[] chars;
    int row;
    char col;
    int charn;
    int turn;
    Map<String, Cell> board;
    public void Movement(GameManager board, Cell cell){
        this.charnum = board.getCharnum();
        this.app = board.getApp();
        this.chars = board.getChars();
        this.row = cell.getRow();
        this.col = cell.getColumn();
        this.charn = charnum.indexOf(col);
        this.turn = cell.getTurn();
        this.board = board.getbBoard();
        String name = cell.getPiece();
        if (name.equals(PieceName.WHITE_PAWN)){
            whitePawn();
        }else if(name.equals(PieceName.BLACK_PAWN)){
            blackPawn();
        }else if(name.equals(PieceName.WHITE_ROCK) || name.equals(PieceName.BLACK_ROCK)){
            Rock();
        }else if (name.equals(PieceName.BLACK_BISHOP) || name.equals(PieceName.WHITE_BISHOP)) {
            Bishop();
        } else if (name.equals(PieceName.BLACK_QUEEN) || name.equals(PieceName.WHITE_QUEEN)) {
            Queen();
        } else if (name.equals(PieceName.BLACK_KING) || name.equals(PieceName.WHITE_KING)) {
            King();
        }
    }

    private void blackPawn() {
        if( charn == 5){
            changeBackGroundColor(row-1,chars[charn+1], Color.lightGray);
            changeBackGroundColor(row-1,chars[charn-1], Color.lightGray);
            changeBackGroundColor(row-1,chars[charn], Color.lightGray);
        }else if (charn<5){
            changeBackGroundColor(row,chars[charn+1], Color.lightGray);
            changeBackGroundColor(row-1,chars[charn-1], Color.lightGray);
            changeBackGroundColor(row-1,chars[charn], Color.lightGray);
        }else{
            changeBackGroundColor(row-1,chars[charn+1], Color.lightGray);
            changeBackGroundColor(row,chars[charn-1], Color.lightGray);
            changeBackGroundColor(row-1,chars[charn], Color.lightGray);
        }
    }

    private void whitePawn() {
        /*if(turn == 0){
            changeBackGroundColor(row+2,chars[charn], Color.lightGray);
        }*/if(charn == 0){
            changeBackGroundColor(row+1,chars[charn+1], Color.lightGray);
            changeBackGroundColor(row+1,chars[charn], Color.lightGray);
//            changeBackGroundColor(row+1,chars[charn], Color.lightGray);
        } else if (charn==10) {
            changeBackGroundColor(row+1,chars[charn], Color.lightGray);
            changeBackGroundColor(row+1,chars[charn-1], Color.lightGray);
//            changeBackGroundColor(row+1,chars[charn], Color.lightGray);
            
        } else if( charn == 5){
            changeBackGroundColor(row,chars[charn+1], Color.lightGray);
            changeBackGroundColor(row,chars[charn-1], Color.lightGray);
            changeBackGroundColor(row+1,chars[charn], Color.lightGray);
        }else if (charn<5){
            changeBackGroundColor(row+1,chars[charn+1], Color.lightGray);
            changeBackGroundColor(row,chars[charn-1], Color.lightGray);
            changeBackGroundColor(row+1,chars[charn], Color.lightGray);
        }else{
            changeBackGroundColor(row,chars[charn+1], Color.lightGray);
            changeBackGroundColor(row+1,chars[charn-1], Color.lightGray);
            changeBackGroundColor(row+1,chars[charn], Color.lightGray);
            }
        turn ++;
    }

    private void Rock(){
        StraightMove();
    }
    private void Bishop(){
        ObliqueMove();
    }
    private void Queen(){
        StraightMove();
        ObliqueMove();
    }
    private void King(){
        whitePawn();
        blackPawn();
        Cell cell;
        if (charn==5){
            try {
                cell = board.get("" + (row-1) + chars[charn+2]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row-1, chars[charn+2], Color.lightGray);
                }if(cell.getPiece()!=null){
                    changeBackGroundColor(row-1, chars[charn+2], Color.darkGray);
                }
                cell = board.get("" + (row-1) + chars[charn-2]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row-1, chars[charn-2], Color.lightGray);
                }if(cell.getPiece()!=null){
                    changeBackGroundColor(row-1, chars[charn-2], Color.darkGray);
                }
                cell = board.get("" + (row+1) + chars[charn+1]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row+1, chars[charn+1], Color.lightGray);
                }if(cell.getPiece()!=null){
                    changeBackGroundColor(row+1, chars[charn+1], Color.darkGray);
                }
                cell = board.get("" + (row+1) + chars[charn-1]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row+1, chars[charn-1], Color.lightGray);
                }if(cell.getPiece()!=null){
                    changeBackGroundColor(row+1, chars[charn-1], Color.darkGray);
                }
                cell = board.get("" + (row-2) + chars[charn+1]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row-2, chars[charn+1], Color.lightGray);
                }if(cell.getPiece()!=null){
                    changeBackGroundColor(row-2, chars[charn+1], Color.darkGray);
                }
                cell = board.get("" + (row-2) + chars[charn-1]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row-2, chars[charn-1], Color.lightGray);
                }if(cell.getPiece()!=null){
                    changeBackGroundColor(row-2, chars[charn-1], Color.darkGray);
                }
            }catch (Exception e){
            }
        }
        //سمت راست
        else if (charn>5) {
            try {
                cell = board.get("" + (row-1) + chars[charn+2]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row-1, chars[charn+2], Color.lightGray);
                }if(cell.getPiece()!=null){
                    changeBackGroundColor(row-1, chars[charn+2], Color.darkGray);
                }
                cell = board.get("" + (row) + chars[charn-2]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row, chars[charn-2], Color.lightGray);
                }if(cell.getPiece()!=null){
                    changeBackGroundColor(row, chars[charn-2], Color.darkGray);
                }
                cell = board.get("" + (row+1) + chars[charn+1]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row+1, chars[charn+1], Color.lightGray);
                }if(cell.getPiece()!=null){
                    changeBackGroundColor(row+1, chars[charn+1], Color.darkGray);
                }
                cell = board.get("" + (row+1) + chars[charn-1]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row+1, chars[charn-1], Color.lightGray);
                }if(cell.getPiece()!=null){
                    changeBackGroundColor(row+1, chars[charn-1], Color.darkGray);
                }
                cell = board.get("" + (row-2) + chars[charn+1]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row-2, chars[charn+1], Color.lightGray);
                }if(cell.getPiece()!=null){
                    changeBackGroundColor(row-2, chars[charn+1], Color.darkGray);
                }
                cell = board.get("" + (row-1) + chars[charn-1]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row-1, chars[charn-1], Color.lightGray);
                }if(cell.getPiece()!=null){
                    changeBackGroundColor(row-1, chars[charn-1], Color.darkGray);
                }
                cell = board.get("" + (row+2) + chars[charn-1]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row+2, chars[charn-1], Color.lightGray);
                }if(cell.getPiece()!=null){
                    changeBackGroundColor(row+2, chars[charn-1], Color.darkGray);
                }
            }catch (Exception e){
            }
        }

    }

//    private void straightMove() {
//        checkAndHighlightCellsInDirection(-1, 0); // Up
//        checkAndHighlightCellsInDirection(1, 0);  // Down
//        checkAndHighlightCellsInDirection(0, -1); // Left
//        checkAndHighlightCellsInDirection(0, 1);  // Right
//
//        // If the piece is in the middle of the board
//        if (charn == 5) {
//            checkAndHighlightCellsInDirection(0, -1); // Horizontal left
//            checkAndHighlightCellsInDirection(0, 1);  // Horizontal right
//        } else {
//            // If the piece is on the left side of the board
//            if (charn < 5) {
//                checkAndHighlightCellsInDirection(-1, -1); // Diagonal left up
//                checkAndHighlightCellsInDirection(1, 1);   // Diagonal right down
//                checkAndHighlightCellsInDirection(-1, 1);  // Diagonal right up
//            }
//            // If the piece is on the right side of the board
//            else if (charn > 5) {
//                checkAndHighlightCellsInDirection(-1, -1); // Diagonal left up
//                checkAndHighlightCellsInDirection(1, -1);  // Diagonal left down
//                checkAndHighlightCellsInDirection(-1, 1);  // Diagonal right up
//            }
//        }
//    }
//
//    private void checkAndHighlightCellsInDirection(int rowChange, int colChange) {
//        Cell cell;
//        for (int i = 1; i <= 11; i++) {
//            try {
//                int newRow = row + i * rowChange;
//                int newCol = charn == 5 ? col : chars[charn] + i * colChange;
//
//                cell = board.get("" + newRow + newCol);
//                if (cell.getPiece() == null) {
//                    changeBackgroundColor(newRow, chars[newCol], Color.lightGray);
//                } else {
//                    changeBackgroundColor(newRow, chars[newCol], Color.DARK_GRAY);
//                    break;
//                }
//            } catch (Exception e) {
//                // Handle exceptions if necessary
//            }
//        }
//    }


//    private void changeBackgroundColor(int row, char col, Color color) {
//        // Implement the logic to change the background color
//        try{
//            Cell cell = board.get(""+row+col);
//            cell.setBcolor(color);
//            app.changeBackGround(row, col, color);
//            if(cell.getPiece()!=null){
//                cell.setBcolor(Color.DARK_GRAY);
//                app.changeBackGround(row, col, Color.DARK_GRAY);
//            }
//        }catch (Exception e){}
//    }



    //===============================


    private void StraightMove(){
        Cell cell;
        //خطوط بالا و پایین
        for (int i = 1; i<11; i++){
            try{
                cell = board.get(""+(row-i)+col);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row-i, col, Color.lightGray);
                }else if(cell.getPiece()!=null){
                    changeBackGroundColor(row-i, col, Color.DARK_GRAY);
                    break;
                }
            }catch (Exception e){
            }
        }
        for (int i = 1; i<=11; i++){
            try{
                cell = board.get(""+(row+i)+col);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row+i, col, Color.lightGray);
                }else if(cell.getPiece()!=null){
                    changeBackGroundColor(row+i, col, Color.DARK_GRAY);
                    break;
                }
            }catch (Exception e){
            }
        }
        //اگر وسط صفحه بود
        if(charn == 5){
            for (int i =1; i<=11; i++){
                try{
                    cell = board.get(""+(row)+chars[charn+i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row, chars[charn+i], Color.lightGray);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row, chars[charn+i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
            for (int i =1; i<=11; i++){
                try{
                    cell = board.get(""+(row)+chars[charn-i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row, chars[charn-i], Color.lightGray);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row, chars[charn-i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
            //سمت چپ پایین
            for (int i =1; i<=11; i++){
                try{
                    cell = board.get(""+(row-i)+chars[charn-i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row-i, chars[charn-i], Color.LIGHT_GRAY);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row-i, chars[charn-i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
            //سمت راست پایین

            for (int i =1; i<=11; i++){
                try{
                    cell = board.get(""+(row-i)+chars[charn+i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row-i, chars[charn+i], Color.LIGHT_GRAY);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row-i, chars[charn+i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }

            }

        }
        //اگر سمت چپ صفحه بود
        else if(charn<5){
            //سمت چپ بالا
            for (int i =1; i<=11; i++){
                try{
                    cell = board.get(""+(row)+chars[charn-i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row, chars[charn-i], Color.lightGray);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row, chars[charn-i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
            //سمت راست بالا
            int k1 = 1;
            for (int i =1; i<=11; i++){
                try{
                    if (charn+i<=5){
                        cell = board.get(""+(row+i)+chars[charn+i]);
                        if(cell.getPiece()==null){
                            changeBackGroundColor(row+i, chars[charn+i], Color.lightGray);
                        }else if(cell.getPiece()!=null){
                            changeBackGroundColor(row+i, chars[charn+i], Color.DARK_GRAY);
                            break;
                        }
                    }else if (charn+i>5){
                        cell = board.get(""+(row+i-k1)+chars[charn+i]);
                        if(cell.getPiece()==null){
                            changeBackGroundColor(row+i-k1, chars[charn+i], Color.lightGray);
                        }else if(cell.getPiece()!=null){
                            changeBackGroundColor(row+i-k1, chars[charn+i], Color.DARK_GRAY);
                            break;
                        }
                        k1++;
                    }

                }catch (Exception e){
                }
            }
            //سمت چپ پایین
            for (int i =1; i<=11; i++){
                try{
                    cell = board.get(""+(row-i)+chars[charn-i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row-i, chars[charn-i], Color.LIGHT_GRAY);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row-i, chars[charn-i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
            //سمت راست پایین
            int k2 = 1;
            for (int i =1; i<=11; i++){
                if (charn+i<=5){
                    try{
                        cell = board.get(""+(row)+chars[charn+i]);
                        if(cell.getPiece()==null){
                            changeBackGroundColor(row, chars[charn+i], Color.LIGHT_GRAY);
                        }else if(cell.getPiece()!=null){
                            changeBackGroundColor(row, chars[charn+i], Color.DARK_GRAY);
                            break;
                        }
                    }catch (Exception e){
                    }
                }else if (charn+i>5){
                    try{
                        cell = board.get(""+(row-k2)+chars[charn+i]);
                        if(cell.getPiece()==null){
                            changeBackGroundColor(row-k2, chars[charn+i], Color.lightGray);
                        }else if(cell.getPiece()!=null){
                            changeBackGroundColor(row-k2, chars[charn+i], Color.DARK_GRAY);
                            break;
                        }
                    }catch (Exception e){
                    }
                    k2++;
                }

            }
        }
        //اگر سمت راست صفحه بود
        else if (charn>5) {
            //سمت چپ بالا
            int j1 =1;
            for (int i =1; i<=11; i++){
                if (charn-i>5){
                    try{
                        cell = board.get(""+(row+i)+chars[charn-i]);
                        if(cell.getPiece()==null){
                            changeBackGroundColor(row+i, chars[charn-i], Color.lightGray);
                        }else if(cell.getPiece()!=null){
                            changeBackGroundColor(row+i, chars[charn-i], Color.DARK_GRAY);
                            break;
                        }
                        j1++;
                    }catch (Exception e){
                    }
                } else if (charn-i<=5) {
                    try{
                        cell = board.get(""+(row+j1)+chars[charn-i]);
                        if(cell.getPiece()==null){
                            changeBackGroundColor(row+j1, chars[charn-i], Color.lightGray);
                        }else if(cell.getPiece()!=null){
                            changeBackGroundColor(row+j1, chars[charn-i], Color.DARK_GRAY);
                            break;
                        }
                    }catch (Exception e){
                    }
                }

            }
            //سمت راست بالا
            for (int i =1; i<=11; i++){
                try{
                    cell = board.get(""+(row)+chars[charn+i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row, chars[charn+i], Color.lightGray);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row, chars[charn+i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
            //سمت چپ پایین
            int j2 = 1;
            for (int i =1; i<=11; i++){
                if (charn-i>=5){
                    try{
                        cell = board.get(""+(row)+chars[charn-i]);
                        if(cell.getPiece()==null){
                            changeBackGroundColor(row, chars[charn-i], Color.LIGHT_GRAY);
                        }else if(cell.getPiece()!=null){
                            changeBackGroundColor(row , chars[charn-i], Color.DARK_GRAY);
                            break;
                        }
                    }catch (Exception e){
                    }
                } else if (charn-i<5) {
                    try{
                        cell = board.get(""+(row-j2)+chars[charn-i]);
                        if(cell.getPiece()==null){
                            changeBackGroundColor(row-j2, chars[charn-i], Color.LIGHT_GRAY);
                        }else if(cell.getPiece()!=null){
                            changeBackGroundColor(row-j2, chars[charn-i], Color.DARK_GRAY);
                            break;
                        }
                        j2++;
                    }catch (Exception e){
                    }
                }

            }
            //سمت راست پایین
            for (int i =1; i<=11; i++){
                try{
                    cell = board.get(""+(row-i)+chars[charn+i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row-i, chars[charn+i], Color.LIGHT_GRAY);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row-i, chars[charn+i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
                try{
                    cell = board.get(""+(row)+chars[charn+i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row, chars[charn+i], Color.lightGray);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row, chars[charn+i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
        }
    }
    private void ObliqueMove(){
        Cell cell;
        //خط افقی
        for (int i = 1; i<11; i++){
            try{
                cell = board.get(""+(row-i)+ chars[charn-2*i]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row-i, chars[charn-2*i], Color.lightGray);
                }else if(cell.getPiece()!=null){
                    changeBackGroundColor(row-i, chars[charn-2*i], Color.DARK_GRAY);
                    break;
                }
            }catch (Exception e){
            }
        }
        for (int i = 1; i<=11; i++){
            try{
                cell = board.get(""+(row+i)+chars[charn+2*i]);
                if(cell.getPiece()==null){
                    changeBackGroundColor(row+i, chars[charn+2*i], Color.lightGray);
                }else if(cell.getPiece()!=null){
                    changeBackGroundColor(row+i, chars[charn+2*i], Color.DARK_GRAY);
                    break;
                }
            }catch (Exception e){
            }
        }
    }
    private void changeBackGroundColor(int row, char col, Color color){
        try{
            Cell cell = board.get(""+row+col);
            cell.setBcolor(color);
            app.changeBackGround(row, col, color);
            if(cell.getPiece()!=null){
                cell.setBcolor(Color.DARK_GRAY);
                app.changeBackGround(row, col, Color.DARK_GRAY);
            }
        }catch (Exception e){}
    }
}

