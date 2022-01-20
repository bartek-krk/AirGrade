package pl.bart.airgrade.data.impl.util;

import java.util.ArrayList;

public class SafeList<T> extends ArrayList<T> {
    public T getOrNull(int index) {
        try {
            return this.get(index);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return null;
        }
    }
}
