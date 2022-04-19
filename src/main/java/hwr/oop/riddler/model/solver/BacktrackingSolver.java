package hwr.oop.riddler.model.solver;

import hwr.oop.riddler.logic.SudokuValidator;
import hwr.oop.riddler.model.Sudoku;
import hwr.oop.riddler.model.component.Cell;

import java.util.Stack;

public class BacktrackingSolver implements IterativeSudokuSolver {

    private final Stack<Cell> backtrackingStack = new Stack<>();

    @Override
    public boolean doSolvingStep(Sudoku sudoku) {
        while (true) {
            var cell = getNextUnsolved(backtrackingStack.size(), sudoku);
            if (cell == null) break;
            backtrackingStack.push(cell);
            //sudoku.print();
            cell.setAssumedValue(cell.getAssumedPossibles().get(0));
            if (!new SudokuValidator().isValid(sudoku)) {
                System.out.println("tried " + cell.getPossibles().get(0) + " but lead to invalid sudoku");
                //System.out.println(cell);
                var popped = backtrackingStack.pop();
                popped.removeAssumedPossible(popped.getAssumedValue());
                while (popped.getAssumedPossibles().isEmpty() && backtrackingStack.size() > 1) {
                    popped.resetAssumption();
                    popped = backtrackingStack.pop();
                    popped.removeAssumedPossible(popped.getAssumedValue());
                }
                if (popped.getAssumedPossibles().isEmpty()) {
                    popped.resetAssumption();
                    popped = backtrackingStack.pop();
                }
                //sudoku.print();
                if (backtrackingStack.isEmpty()) {
                    popped.removePossible(popped.getAssumedValue());
                    popped.resetAssumption();
                    System.out.println("back: removed possible");
                    return true;
                }
                popped.setAssumedValue(0);
            }
        }
        return false;
    }

    public void cleanUp() {
        while (!backtrackingStack.isEmpty()) {
            backtrackingStack.pop().setAssumedValue(0);
        }
    }

    private Cell getNextUnsolved(int index, Sudoku sudoku) {
        var cells = sudoku.getAllCells();
        //System.out.println("SIZE: " + cells.size() + " + " + Arrays.toString(cells.toArray()));
        for (int i = index; i < cells.size(); i++) {
            var cell = cells.get(i);
            //System.out.println(i + ": " + cell);
            if (!cell.isSet()) return cell;
        }
        //System.out.println("NULL");
        return null;
    }
}
