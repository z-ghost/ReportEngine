package org.re;

import java.util.function.Predicate;

/**
 * Created by V.Zubchevskiy on 09.03.2016.
 */
public class TableElementBuilder {

    private final String title;
    private Predicate predicate;

    public TableElementBuilder(String title) {
        this.title = title;
    }

    public <T> TableElementBuilder predicate(Predicate<T> p) {
        predicate = p;
        return this;
    }

    public TableElementBuilder calcStrategy(IStrategy strategy) {
        return this;
    }

    public TableElementBuilder cssClass(String cssClass) {
        return this;
    }

    public TableElement create() {
        return new TableElement(title, predicate);
    }
}
