package org.re;

import java.util.List;

/**
 * Created by V.Zubchevskiy on 09.03.2016.
 */
public interface IProvider<T> {
    List<T> load();
}
