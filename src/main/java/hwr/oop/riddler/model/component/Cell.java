package hwr.oop.riddler.model.component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ToString
public class Cell {
    private int value;
    @Getter
    private List<Integer> possibles;

    public Cell(int value) {
        //TODO value between 1 and 9
        this.value = value;
    }

    public Cell() {
        this.possibles = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        resetAssumption();
    }


    @Getter
    @Setter
    private int assumedValue;
    @Getter
    @Setter
    private List<Integer> assumedPossibles;

    public void resetAssumption() {
        this.assumedPossibles = new ArrayList<>(possibles);
        this.assumedValue = 0;
    }

    public boolean isSet() {
        return getValue() != 0;
    }

    public void setValue(int value) {
        if (this.value != 0) throw new IllegalArgumentException("Value was already set");
        this.value = value;
        this.assumedValue = 0;
    }

    public boolean removePossible(int possible) {
        removeAssumedPossible(possible);
        var iterator = possibles.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == possible) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean removeAssumedPossible(int possible) {
        var iterator = assumedPossibles.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == possible) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean removeAllPossibles(Set<Integer> allValues) {
        assumedPossibles.removeAll(allValues);
        return possibles.removeAll(allValues);
    }

    public int getValue() {
        if (value != 0) return value;
        if (assumedValue != 0) return assumedValue;
        return 0;
    }
}
