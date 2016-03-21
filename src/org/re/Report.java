package org.re;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by V.Zubchevskiy on 09.03.2016.
 */
public class Report {
    Map<Coord, Number> cellMap = new HashMap<>();
    private List<String> columns;
    private List<String> rows;

    public Number getCellValue(String col, String row) {
        return cellMap.get(new Coord(columns.indexOf(col), rows.indexOf(row)));
    }

    public void addCell(Coord coord, Number calc) {
        cellMap.put(coord, calc);
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public void setRows(List<String> rows) {
        this.rows = rows;
    }
}
