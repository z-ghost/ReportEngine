package org.re;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by V.Zubchevskiy on 22.03.2016.
 */
public class ReportEngine {

    private final ITableElement[] columns;
    private final ITableElement[] rows;
    private final IProvider provider;
    private final IStrategy strategy;

    public ReportEngine(ITableElement[] columns, ITableElement[] rows, IProvider provider, IStrategy strategy) {
        this.columns = columns;
        this.rows = rows;
        this.provider = provider;
        this.strategy = strategy;
    }

    public Report make() {
        Report report = new Report();
        List load = provider.load();

        report.setColumns(Arrays.stream(columns).map(ITableElement::getTitle).collect(Collectors.toList()));
        report.setRows(Arrays.stream(rows).map(ITableElement::getTitle).collect(Collectors.toList()));


        for (int colNumber = 0; colNumber < columns.length; colNumber++) {
            ITableElement column = columns[colNumber];

            IStrategy strategy = this.strategy;
            List withColumnFilter = (List) load.stream().filter(column.getPredicate()).collect(Collectors.toList());
            for (int rowNumber = 0; rowNumber < rows.length; rowNumber++) {
                ITableElement row = rows[rowNumber];
                List result = (List) withColumnFilter.stream().filter(row.getPredicate()).collect(Collectors.toList());
                report.addCell(new Coord(colNumber, rowNumber), strategy.calc(result));
            }
        }
        return report;
    }
}
