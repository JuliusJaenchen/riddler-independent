package hwr.oop.riddler.model.component;

import java.util.HashSet;
import java.util.Set;

public class Cell {
    private int value;
    private Set<Integer> possibles;

    public Cell(int value) {
        this.value = value;
    }

    public Cell() {
        possibles = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public boolean isSet() {
        return value != 0;
    }

    public int getValue() {
        return value;
    }

    public boolean removePossible(int possible) {
        return possibles.remove(possible);
    }

    public Set<Integer> getPossibles() {
        return possibles;
    }

    public boolean removeAllPossibles(Set<Integer> allValues) {
        return possibles.removeAll(allValues);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "value=" + value +
                ", possibles=" + possibles +
                '}';
    }
}
