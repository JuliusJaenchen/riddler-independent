package hwr.oop.riddler.model;

import hwr.oop.riddler.model.component.Cell;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

class SudokuTest {
    private final int[][] unsolvedSudokuArray = {
            {0,0,0, 9,0,0, 4,0,0},
            {5,0,6, 0,0,0, 0,0,0},
            {9,0,0, 3,0,0, 6,8,1},

            {0,2,0, 0,5,0, 1,0,0},
            {0,8,0, 0,7,9, 0,0,0},
            {6,0,7, 0,0,8, 0,0,0},

            {0,0,0, 0,2,0, 0,4,0},
            {0,0,0, 0,9,0, 0,5,0},
            {0,5,0, 0,0,0, 0,0,2},
    };
    private final Sudoku unsolvedSudoku = new Sudoku(unsolvedSudokuArray);


    @Test
    void sudoku_constructorFillsCellsCorrectly() {
        for (int rowIndex = 0; rowIndex < unsolvedSudokuArray.length; rowIndex ++) {
            for (int columnIndex = 0; columnIndex < unsolvedSudokuArray[0].length; columnIndex++) {
                if (unsolvedSudoku.cells[rowIndex][columnIndex].value != unsolvedSudokuArray[rowIndex][columnIndex]) {
                    fail();
                }
            }
        }
    }

    @Test
    void sudoku_getsFirstRow() {
        int[] firstRowValues = {0,0,0, 9,0,0, 4,0,0};
        Cell[] row = unsolvedSudoku.getRow(0);
        for (int i = 0; i < 9; i++) {
            if (row[i].value != firstRowValues[i]) {
                fail();
            }
        }
    }

    @Test
    void sudoku_getsFirstColumn() {
        int[] firstColumnValues = {0,5,9,0,0,6,0,0,0};
        Cell[] column = unsolvedSudoku.getColumn(0);
        for (int i = 0; i < 9; i++) {
            if (column[i].value != firstColumnValues[i]) {
                fail();
            }
        }
    }

    @Test
    void sudoku_getsFirstBox() {
        int[] firstBoxValues = {0,0,0,5,0,6,9,0,0};
        Cell[] box = unsolvedSudoku.getBox(0);
        for (int i = 0; i < 9; i++) {
            if (box[i].value != firstBoxValues[i]) {
                fail();
            }
        }
    }

    @Test
    void sudoku_getsFirstRowValues() {
        Set<Integer> expectedValues = Set.of(9, 4);
        if (!unsolvedSudoku.getRowValues(0).equals(expectedValues)) {
            fail();
        }
    }

    @Test
    void sudoku_getsFirstColumnValues() {
        Set<Integer> expectedValues = Set.of(5, 9, 6);
        if (!unsolvedSudoku.getColumnValues(0).equals(expectedValues)) {
            fail();
        }
    }

    @Test
    void sudoku_getsFirstBoxValues() {
        Set<Integer> expectedValues = Set.of(5, 9, 6);
        if (!unsolvedSudoku.getBoxValues(0).equals(expectedValues)) {
            fail();
        }
    }
}
