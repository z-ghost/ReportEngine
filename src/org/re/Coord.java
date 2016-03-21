package org.re;

/**
 * Created by V.Zubchevskiy on 22.03.2016.
 */
public class Coord {
    final int colNumber;
    final int rowNumber;

    public Coord(int colNumber, int rowNumber) {
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
    }

    public int getColNumber() {
        return colNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coord coord = (Coord) o;

        return colNumber == coord.colNumber && rowNumber == coord.rowNumber;

    }

    @Override
    public int hashCode() {
        int result = colNumber;
        result = 31 * result + rowNumber;
        return result;
    }

    @Override
    public String toString() {
        return "Coord("+ colNumber +
                "," + rowNumber +')';
    }
}
