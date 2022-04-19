package hwr.oop.riddler.model;

import hwr.oop.riddler.model.component.Cell;
import hwr.oop.riddler.model.component.CellGroup;

import java.util.*;
import java.util.function.IntFunction;

public class Sudoku {
    private Cell[][] cells;
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

    public Set<Cell> getAllCells() {
        var collectedCells = new HashSet<Cell>();
        for (Cell[] rows : cells) {
            Collections.addAll(collectedCells, rows);
        }
        return collectedCells;
    }

    public CellGroup getRow(int rowIndex) {
        return new CellGroup(List.of(cells[rowIndex]));
    }

    public CellGroup getColumn(int columnIndex) {
        var column = new ArrayList<Cell>();
        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            column.add(this.cells[rowIndex][columnIndex]);
        }
        return new CellGroup(column);
    }

    public CellGroup getBox(int boxIndex) {
        var boxCells = new ArrayList<Cell>(9);
        int boxLatitude = boxIndex / 3;
        int boxLongitude = boxIndex % 3;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                boxCells.add(cells[boxLatitude + y][boxLongitude + x]);
            }
        }
        return new CellGroup(boxCells);
    }

    public Set<CellGroup> getRows() {
        return getGroup(this::getRow);
    }

    public Set<CellGroup> getColumns() {
        return getGroup(this::getColumn);
    }

    public Set<CellGroup> getBoxes() {
        return getGroup(this::getBox);
    }

    private Set<CellGroup> getGroup(IntFunction<CellGroup> function) {
        var group = new HashSet<CellGroup>(9);
        for (int i = 0; i < size; i++) {
            group.add(function.apply(i));
        }
        return group;
    }

    public Cell getCellAt(int row, int column) {
        return cells[row][column];
    }
}
