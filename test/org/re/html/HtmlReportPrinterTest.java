package org.re.html;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.re.*;

import java.util.List;

/**
 * Created by Vitaly on 27.03.2016.
 */
public class HtmlReportPrinterTest {
    private Report report;

    @Before
    public void createData()
    {
        List<Day> data = new WeatherBuilder().week(5).week(3).getList();
        report = new ReportBuilder()
                .columns(
                        TableElements.simple("Sunny", Day::isSunny),
                        TableElements.simple("Rainy", Day::isRainy)
                )
                .rows(TableElements.<Day>simple("week1", d -> d.getWeek() == 1),
                        TableElements.<Day>simple("week2", d -> d.getWeek() == 2))
                .provider(SimpleProvider.create(data))
                .calcStrategy(Strategies.count())
                .build();
    }

    /**
     * Make a simple report
     *
     * +---------+-------+-------+
     * |         | Sunny | Rainy |
     * |---------+-------+-------+
     * | week1   |  5    |   2   |
     * | week2   |  3    |   4   |
     * +---------+-------+-------+
     */
    @Test
    public void test()
    {
        Assert.assertEquals("<table>\n" +
                "<tr>\n" +
                "\t<th></th>\n" +
                "\t<th>Sunny</th>\n" +
                "\t<th>Rainy</th>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "\t<td>week1</td>\n" +
                "\t<td>5</td>\n" +
                "\t<td>2</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "\t<td>week2</td>\n" +
                "\t<td>3</td>\n" +
                "\t<td>4</td>\n" +
                "</tr>\n" +
                "</table>", new HtmlReportPrinter().print(report));
    }

}