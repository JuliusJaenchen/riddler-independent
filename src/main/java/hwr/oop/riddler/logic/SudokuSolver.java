package hwr.oop.riddler.logic;

import hwr.oop.riddler.logic.solver.*;
import hwr.oop.riddler.model.Sudoku;

import java.util.List;

public class SudokuSolver {
    List<IterativeSudokuSolver> solvingComponents;

    public SudokuSolver() {
        solvingComponents = List.of(
                new SimpleReducePossiblesSolver(),
                new AdvancedReducePossiblesSolver(),
                new ObviousSolver(),
                new BacktrackingSolver()
        );
    }

    public Sudoku solve(Sudoku sudoku) {
        for (int solvingStepIndex = 0; solvingStepIndex < solvingComponents.size(); solvingStepIndex++) {
            //System.out.println("step " + solvingIndex);
            try {
                if (solvingComponents.get(solvingStepIndex).doSolvingStep(sudoku))
                    solvingStepIndex = 0;
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        }

        return sudoku;
    }
}
