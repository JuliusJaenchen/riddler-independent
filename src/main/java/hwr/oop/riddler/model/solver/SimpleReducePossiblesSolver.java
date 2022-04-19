package hwr.oop.riddler.model.solver;

import hwr.oop.riddler.model.Sudoku;
import hwr.oop.riddler.model.component.Cell;
import hwr.oop.riddler.model.component.CellGroup;

public class SimpleReducePossiblesSolver implements IterativeSudokuSolver {
    @Override
    public boolean doSolvingStep(Sudoku sudoku) {
        for (CellGroup box : sudoku.getBoxes()) {
            for (Cell cell : box.getCells()) {
                if (!cell.isSet()) {
                    cell.removeAllPossibles(box.getAllValues());
                }
            }
        }
        return false;
    }
}
