package org.re;

import java.util.function.Predicate;

/**
 * Created by V.Zubchevskiy on 08.03.2016.
 */
public interface ITableElement<T> {

    String getTitle();

    Predicate getPredicate();
}
