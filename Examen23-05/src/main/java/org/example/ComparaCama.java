package org.example;

import java.util.Comparator;

public class ComparaCama implements Comparator<Autocaravana> {
    @Override
    public int compare(Autocaravana o1, Autocaravana o2) {
        return Integer.compare(o2.getCamas(), o1.getCamas());
    }
}
