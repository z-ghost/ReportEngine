package org.re.html;

import org.re.Report;

/**
 * Created by Vitaly on 27.03.2016.
 */
public class HtmlReportPrinter {

    public String print(Report report) {
        HtmlTableBuilder builder = new HtmlTableBuilder();
        builder.tr().th("");
        for (String col : report.getColumns()) {
            builder.th(col);
        }
        for (String row : report.getRows()) {
            builder.tr();
            builder.td(row);
            for (String col : report.getColumns()) {
                builder.td(report.getCellValue(col, row));
            }
        }
        return builder.getHtml();
    }
}
