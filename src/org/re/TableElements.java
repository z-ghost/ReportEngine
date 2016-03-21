package org.re;

import java.util.function.Predicate;

/**
 * Created by V.Zubchevskiy on 08.03.2016.
 */
public class TableElements {

    public static <T> ITableElement<T> simple (String title) {
        return new TableElement(title, o -> true);
    }
    public static <T> ITableElement<T> simple (String title, Predicate<T> predicate) {
       return new TableElement(title, predicate);
   }

    public static TableElementBuilder builder(String title) {
        return new TableElementBuilder(title);
    }

}
