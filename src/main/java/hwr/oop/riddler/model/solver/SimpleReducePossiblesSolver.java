package hwr.oop.riddler.model.solver;

import hwr.oop.riddler.model.Sudoku;
import hwr.oop.riddler.model.component.Cell;
import hwr.oop.riddler.model.component.CellGroup;

import java.util.HashSet;

public class SimpleReducePossiblesSolver implements IterativeSudokuSolver {
    @Override
    public boolean doSolvingStep(Sudoku sudoku) {
        var allCellGroups = new HashSet<CellGroup>();
        allCellGroups.addAll(sudoku.getBoxes());
        allCellGroups.addAll(sudoku.getRows());
        allCellGroups.addAll(sudoku.getColumns());
        for (CellGroup box : allCellGroups) {
            for (Cell cell : box.getCells()) {
                if (!cell.isSet()) {
                    if (cell.removeAllPossibles(box.getAllValues())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
