package org.re;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by V.Zubchevskiy on 09.03.2016.
 */
public class Strategies {
    public static IStrategy count() {
        return List::size;
    }
}
