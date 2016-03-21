package org.re;

import org.junit.Assert;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

/**
 * Created by V.Zubchevskiy on 22.11.2015.
 * re.org
 */
public class TableBuilderTest {

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

    @org.junit.Test
    public void testBuilder() throws Exception {
        Report report = new ReportBuilder()
                .columns(
                        /* TODO: java-html-dsl like
                        TableElements.custom(name -> "Sunny",
                                       predicate -> Day::::isSunny,
                                       calc -> Strategies.count(),
                                       casClass -> "yellow")*/
                        TableElements.builder("Sunny")
                                .predicate(Day::isSunny)
                                .calcStrategy(Strategies.count())
                                .cssClass("yellow")
                                .create(),

                        TableElements.builder("Rainy")
                                .predicate(Day::isSunny)
                                .calcStrategy(list -> 7 - list.size())
                                .cssClass("blue")
                                .create()
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
