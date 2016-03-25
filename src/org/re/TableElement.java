package org.re;

import java.util.function.Predicate;

/**
 * Created by V.Zubchevskiy on 08.03.2016.
 */
public class TableElement implements ITableElement {
    private String title;
    private Predicate predicate;
    private IStrategy strategy;

    public TableElement(String title, Predicate predicate) {
        this.title = title;
        this.predicate = predicate;
    }

    public TableElement(String title, Predicate predicate, IStrategy strategy) {
        this.title = title;
        this.predicate = predicate;
        this.strategy = strategy;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Predicate getPredicate() {
        return predicate;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public IStrategy getStrategy() {
        return strategy;
    }
}
