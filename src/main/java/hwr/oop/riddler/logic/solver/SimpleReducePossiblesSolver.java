package hwr.oop.riddler.logic.solver;

import hwr.oop.riddler.model.Sudoku;
import hwr.oop.riddler.model.component.Cell;
import hwr.oop.riddler.model.component.CellGroup;

import java.util.HashSet;

public class SimpleReducePossiblesSolver implements IterativeSudokuSolver {

    public boolean doSolvingStep(Sudoku sudoku) {
        var allCellGroups = new HashSet<CellGroup>();
        allCellGroups.addAll(sudoku.getBoxes());
        allCellGroups.addAll(sudoku.getRows());
        allCellGroups.addAll(sudoku.getColumns());
        for (CellGroup cellGroup : allCellGroups) {
            for (Cell cell : cellGroup.getCells()) {
                if (cell.removeAllPossibles(cellGroup.getAllValues())) {
                    return true;
                }
            }
        }
        return false;
    }
}
