package org.example;

import java.util.Comparator;

public class ComparaPrecio implements Comparator<Coche> {

    @Override
    public int compare(Coche o1, Coche o2) {
        if (o2.getPrecio()> o1.getPrecio()){
            return 1;
        } else if (o2.getPrecio()< o1.getPrecio()) {
            return -1;
        }

        return 0;

    }
}
