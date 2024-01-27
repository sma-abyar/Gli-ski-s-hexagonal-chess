package trian3;

import train2.Cell;
import train2.GameManager;

import java.awt.*;

public class Rock implements Rules{

    @Override
    public void accessed(GameManager board, Cell cell) {
        int row = cell.getRow();
        char col = cell.getColumn();
        for (int i = 0; i<11; i++){
            try{
                board.app.changeBackGround(row-i, col, Color.GRAY);
                board.app.changeBackGround(row+i, col, Color.GRAY);
            }catch (Exception e){

            }
        }
    }
}
