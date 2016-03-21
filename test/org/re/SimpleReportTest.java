package org.re;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by V.Zubchevskiy on 22.03.2016.
 */
public class SimpleReportTest {

    private List<Day> data;

    @Before
    public void createData()
    {
        data = Arrays.asList(new Day(true, 1), new Day(false, 1), new Day(true, 1),  new Day(true, 1),  new Day(false, 1), new Day(true, 1), new Day(true, 1),
                             new Day(true, 2), new Day(false, 2), new Day(false, 2), new Day(false, 2), new Day(false, 2), new Day(true, 2), new Day(true, 2));
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
        Report report = new ReportBuilder()
                .columns(
                        TableElements.simple("Sunny", Day::isSunny),
                        TableElements.simple("Rainy", Day::isRainy)
                )
                .rows(TableElements.<Day>simple("week1", d -> d.week == 1),
                        TableElements.<Day>simple("week2", d -> d.week == 2))
                .provider(SimpleProvider.create(data))
                .calcStrategy(Strategies.count())
                .build();
        Assert.assertEquals(5, report.getCellValue("Sunny", "week1"));
        Assert.assertEquals(2, report.getCellValue("Rainy", "week1"));
        Assert.assertEquals(3, report.getCellValue("Sunny", "week2"));
        Assert.assertEquals(4, report.getCellValue("Rainy", "week2"));
    }
}
