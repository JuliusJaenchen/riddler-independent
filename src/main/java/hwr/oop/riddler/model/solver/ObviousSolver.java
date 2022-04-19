package hwr.oop.riddler.model.solver;

import hwr.oop.riddler.model.Sudoku;
import hwr.oop.riddler.model.component.Cell;

public class ObviousSolver implements IterativeSudokuSolver {
    @Override
    public boolean doSolvingStep(Sudoku sudoku) {
        for (Cell cell : sudoku.getAllCells()) {
            if (!cell.isSet() && cell.getPossibles().size() == 1) {
                cell.setValue(cell.getPossibles().iterator().next());
                System.out.println("OBVSIO");
                return true;
            }
        }
        return false;
    }
}
