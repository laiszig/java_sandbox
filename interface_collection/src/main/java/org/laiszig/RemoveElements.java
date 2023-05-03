package org.laiszig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class RemoveElements {

    public static void main(String[] args) {

        Collection<Integer> line = new ArrayList<>();
        Collection<Integer> line2 = new ArrayList<>();

        line2.add(312);
        line2.add(9);

        line.add(255);
        line.add(312);
        line.add(883);
        line.add(122);
        line.add(9);

        System.out.println("Line numbers: " + line);
        System.out.println("line 2: " + line2);
//        line.remove(312); //REMOVE OBJECT 312
//        line.removeIf(Predicate.isEqual(255));
        line.removeAll(line2);

        System.out.println("Updated line numbers: " + line);
    }
}
