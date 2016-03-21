package org.re;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by V.Zubchevskiy on 09.03.2016.
 */
public interface IStrategy {
    Number calc(List cellStream);
}
