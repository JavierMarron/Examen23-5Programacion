package org.example;

import java.util.Comparator;

public class ComparaPrecio implements Comparator<Coche> {
    @Override
    public int compare(Coche o1, Coche o2) {
        return Integer.compare((int) o2.getPrecio(), (int) o1.getPrecio());
    }
}
