package org.re;

import java.util.function.Predicate;

/**
 * Created by V.Zubchevskiy on 08.03.2016.
 */
public class TableElement implements ITableElement {
    private String title;
    private Predicate predicate;

    public TableElement(String title, Predicate predicate) {
        this.title = title;
        this.predicate = predicate;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Predicate getPredicate() {
        return predicate;
    }
}
