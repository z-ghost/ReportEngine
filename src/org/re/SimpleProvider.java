package org.re;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by V.Zubchevskiy on 09.03.2016.
 */
public class SimpleProvider<T> implements IProvider<T> {

    private final List<T> items;

    public static <T> SimpleProvider<T> create(T ... items) {
        return new SimpleProvider<>(Arrays.asList(items));
    }

    public static <T> SimpleProvider<T> create(List<T> items) {
        return new SimpleProvider<>(items);
    }



    public SimpleProvider(List<T> items) {
        this.items = items;
    }

    @Override
    public List<T> load()
    {
        return items;
    }
}
