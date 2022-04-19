package hwr.oop.riddler.model;

import hwr.oop.riddler.model.component.*;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {
    public Cell[][] cells;
    private final int size;

    public Sudoku(int[][] input) {
        size = input.length;
        cells = new Cell[size][size];
        fillCells(input);
    }

    private void fillCells(int[][] input) {
        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            int[] row = input[rowIndex];
            for (int columnIndex = 0; columnIndex < size; columnIndex++) {
                int cellValue = row[columnIndex];
                cells[rowIndex][columnIndex] = new Cell(cellValue);
            }
        }
    }

    public Cell[] getRow(int rowIndex) {
        return cells[rowIndex];
    }

    public Cell[] getColumn(int columnIndex) {
        var column = new Cell[size];
        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            column[rowIndex] = cells[rowIndex][columnIndex];
        }
        return column;
    }

    public Cell[] getBox(int boxIndex) {
        var box = new Cell[size];
        int boxLatitude = boxIndex / 3;
        int boxLongitude = boxIndex % 3;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                box[3*y + x] = cells[boxLatitude + y][boxLongitude + x];
            }
        }
        return box;
    }

    public Cell[][] getRows() {
        return cells;
    }

    public Cell[][] getColumns() {
        Cell[][] column = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            column[i] = getColumn(i);
        }
        return column;
    }

    public Cell[][] getBoxes() {
        Cell[][] boxes = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            boxes[i] = getBox(i);
        }
        return boxes;
    }

    public Set<Integer> getRowValues(int rowIndex) {
        Set<Integer> row = new HashSet<>();
        for (Cell cell : getRow(rowIndex)) {
            if (cell.value != 0) {
                row.add(cell.value);
            }
        }
        return row;
    }

    public Set<Integer> getColumnValues(int columnIndex) {
        Set<Integer> column = new HashSet<>();
        for (Cell cell : getColumn(columnIndex)) {
            if (cell.value != 0) {
                column.add(cell.value);
            }
        }
        return column;
    }

    public Set<Integer> getBoxValues(int boxIndex) {
        Set<Integer> box = new HashSet<>();
        for (Cell cell : getBox(boxIndex)) {
            if (cell.value != 0) {
                box.add(cell.value);
            }
        }
        return box;
    }
}
