package org.example;

import java.util.Comparator;

public class ComparaCilindrada implements Comparator<Moto> {
    @Override
    public int compare(Moto o1, Moto o2) {
        return  Integer.compare(o2.getCilindrada() , o1.getCilindrada());
    }
}
