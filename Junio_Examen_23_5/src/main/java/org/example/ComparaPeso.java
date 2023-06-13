package org.example;

import java.util.Comparator;

public class ComparaPeso implements Comparator<Camioneta> {
    @Override
    public int compare(Camioneta o1, Camioneta o2) {
        return Integer.compare(o2.getPesoMax(), o1.getPesoMax());
    }
}
