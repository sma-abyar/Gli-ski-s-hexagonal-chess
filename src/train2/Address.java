package train2;

import jdk.swing.interop.DropTargetContextWrapper;

public class Address {
    public Address(int row,char column) {
        this.row = row;
        this.column = column;

    }
    public int row;
    public char column;

    public String toString(){
        return row + "," + column;
    }
}
