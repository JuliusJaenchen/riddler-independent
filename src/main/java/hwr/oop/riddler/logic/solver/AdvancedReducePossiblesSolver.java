package hwr.oop.riddler.logic.solver;

import hwr.oop.riddler.model.Sudoku;
import hwr.oop.riddler.model.component.Cell;
import hwr.oop.riddler.model.component.CellGroup;

import java.util.HashSet;
import java.util.Set;

public class AdvancedReducePossiblesSolver implements IterativeSudokuSolver {
    @Override
    public boolean doSolvingStep(Sudoku sudoku) {
        for (CellGroup box : sudoku.getBoxes()) {
            for (int i = 1; i <= 9; i++) {
                Set<CellGroup> rows = new HashSet<>();
                for (Cell cell : box.getCells()) {
                    if (!cell.isSet() && cell.getPossibles().contains(i)) {
                        rows.add(getRow(cell, sudoku));
                    }
                }
                if (removePossibleFromGroupByCols(sudoku, box, i, rows)) return true;


                Set<CellGroup> cols = new HashSet<>();
                for (Cell cell : box.getCells()) {
                    if (!cell.isSet() && cell.getPossibles().contains(i)) {
                        cols.add(getCol(cell, sudoku));
                    }
                }
                if (removePossibleFromGroupByCols(sudoku, box, i, cols)) return true;
            }
        }
        return false;
    }

    private boolean removePossibleFromGroupByCols(Sudoku sudoku, CellGroup box, int i, Set<CellGroup> cols) {
        if (cols.size() == 1) {
            CellGroup col = cols.iterator().next();
            for (Cell cell : col.getCells()) {
                if (!cell.isSet() && !getBoxOfCell(cell, sudoku).equals(box) && cell.getPossibles().contains(i)) {
                    cell.removePossible(i);
                    return true;
                }
            }
        }
        return false;
    }

    public CellGroup getBoxOfCell(Cell cell, Sudoku sudoku) {
        for (CellGroup box : sudoku.getBoxes()) {
            if (box.getCells().contains(cell)) return box;
        }
        return null;
    }

    public CellGroup getRow(Cell cell, Sudoku sudoku) {
        for (CellGroup box : sudoku.getRows()) {
            if (box.getCells().contains(cell)) return box;
        }
        return null;
    }

    public CellGroup getCol(Cell cell, Sudoku sudoku) {
        for (CellGroup box : sudoku.getColumns()) {
            if (box.getCells().contains(cell)) return box;
        }
        return null;
    }
}
