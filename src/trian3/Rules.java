package trian3;

import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;
import train2.Cell;
import train2.GameManager;
import java.awt.*;
import java.util.Arrays;
import java.util.Map;

public class Rules {
    String charnum;
    Application app;
    char[] chars;
    int row;
    char col;
    int charn;
    int turn;
    int[][] rcolored;
    int[][] ccolored;
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
        rcolored = new int[6][11];
        ccolored = new int[6][11];
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
            addToArray(rcolored, ccolored, 1, i,row+i, charnum.indexOf(col));
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
            //سمت راست بالا
            for (int i =1; i<=11; i++){
                addToArray(rcolored, ccolored, 1, i,row, charnum.indexOf(chars[charn+i]));
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
//            System.out.println(Arrays.deepToString(colored));
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
        if(charn==5){
            //بالا چپ
            for(int i = 1; i<11; i++){
                try{
                    cell = board.get(""+(row+i)+chars[charn-i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row+i, chars[charn-i], Color.LIGHT_GRAY);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row+i, chars[charn-i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
            //بالا راست
            for(int i = 1; i<11; i++){
                try{
                    cell = board.get(""+(row+i)+chars[charn+i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row+i, chars[charn+i], Color.LIGHT_GRAY);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row+i, chars[charn+i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
            //پایین چپ
            for(int i = 1; i<11; i++){
                try{
                    cell = board.get(""+(row-2*i)+chars[charn-i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row-2*i, chars[charn-i], Color.LIGHT_GRAY);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row-2*i, chars[charn-i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
            //پایین راست
            for(int i = 1; i<11; i++){
                try{
                    cell = board.get(""+(row-2*i)+chars[charn+i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row-2*i, chars[charn+i], Color.LIGHT_GRAY);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row-2*i, chars[charn+i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
            //افقی
            for(int i = 1; i<11; i++){
                try{
                    cell = board.get(""+(row-i)+chars[charn+2*i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row-i, chars[charn+2*i], Color.LIGHT_GRAY);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row-i, chars[charn+2*i], Color.DARK_GRAY);
                        break;
                    }
                    cell = board.get(""+(row-i)+chars[charn-2*i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row-i, chars[charn-2*i], Color.LIGHT_GRAY);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row-i, chars[charn-2*i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
        }
        if (charn>5){
            //بالا چپ
            int b4 = 1;
            for(int i = 1; i<15; i++){
                if (charn-i>=5){
                    try{
                        cell = board.get(""+(row+2*i)+chars[charn-i]);
                        if(cell.getPiece()==null){
                            changeBackGroundColor(row+2*i, chars[charn-i], Color.LIGHT_GRAY);
                        }else if(cell.getPiece()!=null){
                            changeBackGroundColor(row+2*i, chars[charn-i], Color.DARK_GRAY);
                            break;
                        }
                    }catch (Exception e){
                        System.out.println(charn-i);
                    }
                }else {
                    try{
                        System.out.println(".");
                        cell = board.get(""+(row+2*i-b4)+chars[charn-i]);
                        if(cell.getPiece()==null){
                            changeBackGroundColor(row+2*i-b4, chars[charn-i], Color.LIGHT_GRAY);
                            b4++;
                        }else if(cell.getPiece()!=null){
                            changeBackGroundColor(row+2*i-b4, chars[charn-i], Color.DARK_GRAY);
                            break;
                        }
                    }catch (Exception e){
                    }
                }
            }
            //بالا راست
            for(int i = 1; i<11; i++){
                try{
                    cell = board.get(""+(row+i)+chars[charn+i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row+i, chars[charn+i], Color.LIGHT_GRAY);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row+i, chars[charn+i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
            int b3=1;
            //پایین چپ
            for(int i = 1; i<11; i++){
                if (charn-i>=5){
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
                else if(charn-i<5) {
                    try{
                        cell = board.get(""+(row-i-b3)+chars[charn-i]);
                        if(cell.getPiece()==null){
                            changeBackGroundColor(row-i-b3, chars[charn-i], Color.lightGray);
                        }else if(cell.getPiece()!=null){
                            changeBackGroundColor(row-i-b3, chars[charn-i], Color.DARK_GRAY);
                            break;
                        }
                        b3++;
                    }catch (Exception e){
                    }
                }
            }
            //پایین راست
            for(int i = 1; i<11; i++){
                try{
                    cell = board.get(""+(row-2*i)+chars[charn+i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row-2*i, chars[charn+i], Color.LIGHT_GRAY);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row-2*i, chars[charn+i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
            //افقی
            for(int i = 1; i<11; i++){
                try{
                    cell = board.get(""+(row-i)+chars[charn+2*i]);
                    if(cell.getPiece()==null){
                        changeBackGroundColor(row-i, chars[charn+2*i], Color.LIGHT_GRAY);
                    }else if(cell.getPiece()!=null){
                        changeBackGroundColor(row-i, chars[charn+2*i], Color.DARK_GRAY);
                        break;
                    }
                }catch (Exception e){
                }
            }
            /*int b1 =-1;
            int b2 = 0;
            for (int i=1; i<11; i++){
                if (charn-2*i>=5){
                    try{
                        cell = board.get(""+(row+i)+chars[charn-2*i]);
                        if(cell.getPiece()==null){
                            changeBackGroundColor(row+i, chars[charn-2*i], Color.LIGHT_GRAY);
                        }else if(cell.getPiece()!=null){
                            changeBackGroundColor(row+i, chars[charn-2*i], Color.DARK_GRAY);
                            break;
                        }
                    }catch (Exception e){
                    }
                }else if (charn-2*i<5){
                    if(charn%2==0){
                        try{
                            cell = board.get(""+(row-b1)+chars[charn-2*i]);
                            if(cell.getPiece()==null){
                                changeBackGroundColor(row-b1, chars[charn-2*i], Color.LIGHT_GRAY);
                            }else if(cell.getPiece()!=null){
                                changeBackGroundColor(row-b1, chars[charn-2*i], Color.DARK_GRAY);
                                break;
                            }
                            System.out.println(row-b1);
                            b1++;
                        }catch (Exception e){
                            cell = board.get(""+(row-b2)+chars[charn-2*i]);
                            if(cell.getPiece()==null){
                                changeBackGroundColor(row-b2, chars[charn-2*i], Color.LIGHT_GRAY);
                            }else if(cell.getPiece()!=null){
                                changeBackGroundColor(row-b2, chars[charn-2*i], Color.DARK_GRAY);
                                break;
                            }
                            System.out.println(row-b1);
                            b2++;
                        }
                    }if (charn%2==1){

                    }
                }
            }*/
        }
    }
    private void mObliqueMove(){
        Cell cell;
        StraightMove();
        for (int i = 0; i<11; i++){
            Cell cell1;
            Cell cell2;
            int[] row = new int[3];
            int[] col = new int[3];
            try {
                row[0] = rcolored[1][i];
                row[1] = rcolored[2][i];
                col[0] = ccolored[1][i];
                col[1] = ccolored[2][i];
                row[2] = (row[0] + row[1]) /2;
                col[2] = (col[0] + col[1]) /2;
                changeBackGroundColor(row[2], chars[col[2]], Color.lightGray);
            }catch (Exception e){
                continue;
            }

        }
    }

    private void addToArray(int[][] rarr, int[][] carr, int dir, int num, int row, int col){
        rarr[dir][num] = row;
        carr[dir][num] = col;

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
    /*private void movementChange(int rchange, int cchange){
        Cell cell;
        try{
            cell = board.get(""+(row+rchange)+chars[charn+cchange]);
            if(cell.getPiece()==null){
                changeBackGroundColor(row+rchange, chars[charn+cchange], Color.LIGHT_GRAY);
            }else if(cell.getPiece()!=null){
                changeBackGroundColor(row+rchange, chars[charn+cchange], Color.DARK_GRAY);
                break;
            }
        }catch (Exception e){
        }
    }*/
}

