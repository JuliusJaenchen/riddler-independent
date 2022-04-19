package hwr.oop.riddler;

import hwr.oop.riddler.io.FileConverter;
import hwr.oop.riddler.model.Sudoku;
import hwr.oop.riddler.model.solver.BacktrackingSolver;
import hwr.oop.riddler.model.solver.IterativeSudokuSolver;

import java.util.List;

public class Riddler {
    public static void main(String[] args) throws IllegalArgumentException {
        var converter = new FileConverter();

        if (args.length != 1) {
            throw new IllegalArgumentException("USAGE: java Riddler [filepath]");
        }
        String filepath = args[args.length - 1];

        var sudoku = new Sudoku(converter.parseInputFile(filepath));
        List<IterativeSudokuSolver> solverList = List.of(new BacktrackingSolver());
        int solvingIndex = 0;
        while (solvingIndex < solverList.size()) {
            System.out.println("step " + solvingIndex);
            try {
                while (solverList.get(solvingIndex).doSolvingStep(sudoku)) {
                    System.out.println("step succeed");
                    solvingIndex = 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error ");
                sudoku.print();
                System.exit(0);
            }

            solvingIndex++;

        }
        sudoku.print();
    }
}
