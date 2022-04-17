package hwr.oop.riddler.model.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class CellTest {
    @Test
    public void cell_blankCellHasPossibles() {
        var cell = new Cell(0);
        for (int i = 1; i < 10; i++) {
            if (!cell.possibles.contains(i)) {
                fail();
            }
        }
    }

    @Test
    public void cell_filledCellDoesNotHavePossibles() {
        for (int i = 1; i < 10; i++) {
            var cell = new Cell(i);
            if (cell.possibles != null) {
                fail();
            }
        }
    }
}
