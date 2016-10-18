package com.rajanish;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajanish on 16/10/16.
 */
public class MatrixIslandFinder {

    // in a given matrix, the 1's are treated as islands. The 1s which are next to each other is same row or column
    // is treated as part of same island. Count number of islands in given matrix
    // givenMatrix =
    //                  1 0 1 1
    //                  0 0 0 0
    //                  1 0 0 1
    //                  0 1 0 0
    // the example has : 5 islands.
    // another example
    // givenMatrix =
    //                  1 0 1 1
    //                  1 1 1 0
    //                  1 0 1 1
    //                  0 1 1 0
    // the example has : 1 islands.


    public static void main(String a[]) {
        MatrixIslandFinder matrixIslandFinder = new MatrixIslandFinder();
        String[][] givenMatrix = {
                {"1", "0", "1", "1"},
                {"0", "0", "0", "0"},
                {"1", "0", "0", "1"},
                {"0", "1", "0", "0"}
        };

        Integer noOfIslands = matrixIslandFinder.countIslands(givenMatrix);
        System.out.println(noOfIslands);

    }

    public Integer countIslandsDepthFirst(String[][] givenMatrix) {

        List<Element> processedElements = new ArrayList<Element>();
        int islandCount = 0;
        for (int columnIndex = 0; columnIndex < givenMatrix.length; columnIndex++) {
            for (int rowIndex = 0; rowIndex < givenMatrix[columnIndex].length; rowIndex++) {
                islandCount = countDepthFirst(givenMatrix, processedElements, islandCount, columnIndex, rowIndex);
            }
        }
        return islandCount;
    }

    private int countDepthFirst(String[][] givenMatrix, List<Element> processedElements, int islandCount, int columnIndex, int rowIndex) {
        String field = givenMatrix[columnIndex][rowIndex];
        Element e = new Element(columnIndex, rowIndex, field);
        if (!processedElements.contains(e) && field.equals("1")) {
            islandCount++;
            System.out.println("Counting : " + columnIndex + "," + rowIndex);
            markAllConnectedAsProcessed(givenMatrix, processedElements, islandCount, columnIndex, rowIndex);
        }
        return islandCount;
    }

    private void markAllConnectedAsProcessed(String[][] givenMatrix, List<Element> processedElements, int islandCount, int columnIndex, int rowIndex) {

        System.out.println("Verifying : " + columnIndex + "," + rowIndex);
        Element e = new Element(columnIndex, rowIndex, givenMatrix[columnIndex][rowIndex]);
        if (!processedElements.contains(e) && e.getValue().equals("1")) {
            processedElements.add(e);
        } else {
            return;
        }

        if (givenMatrix[0].length - 1 > rowIndex) {
            markAllConnectedAsProcessed(givenMatrix, processedElements, islandCount, columnIndex, rowIndex + 1);
        }

        if (givenMatrix.length - 1 > columnIndex) {
            markAllConnectedAsProcessed(givenMatrix, processedElements, islandCount, columnIndex + 1, rowIndex);
        }

        if (rowIndex > 0) {
            markAllConnectedAsProcessed(givenMatrix, processedElements, islandCount, columnIndex, rowIndex - 1);
        }

        if (columnIndex > 0) {
            markAllConnectedAsProcessed(givenMatrix, processedElements, islandCount, columnIndex - 1, rowIndex);
        }
    }

    public Integer countIslands(String[][] givenMatrix) {

        List<Element> processedElements = new ArrayList<Element>();
        int islandCount = 0;
        int columnIndex = 0;
        for (String[] columns : givenMatrix) {
            int rowIndex = 0;
            for (String field : columns) {
                Element e = new Element(columnIndex, rowIndex, field);
                if (!processedElements.contains(e) && field.equals("1")) {
                    processedElements.add(e);
                    if (!processedElements.contains(new Element(columnIndex, rowIndex - 1))
                            && !processedElements.contains(new Element(columnIndex - 1, rowIndex))) {
                        islandCount++;
                        System.out.println(columnIndex + "," + rowIndex);
                    }
                }
                rowIndex++;
            }
            columnIndex++;
        }
        return islandCount;
    }

    public class Element {
        Integer rowNum;
        Integer columnNum;

        String value;

        public Element(Integer rowNum, Integer columnNum, String value) {
            this.rowNum = rowNum;
            this.columnNum = columnNum;
            this.value = value;
        }

        public Element(Integer rowNum, Integer columnNum) {
            this.rowNum = rowNum;
            this.columnNum = columnNum;
        }

        public Integer getRowNum() {
            return rowNum;
        }

        public void setRowNum(Integer rowNum) {
            this.rowNum = rowNum;
        }

        public Integer getColumnNum() {
            return columnNum;
        }

        public void setColumnNum(Integer columnNum) {
            this.columnNum = columnNum;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "rowNum=" + rowNum +
                    ", columnNum=" + columnNum +
                    ", value='" + value + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Element)) return false;

            Element element = (Element) o;

            if (!columnNum.equals(element.columnNum)) return false;
            if (!rowNum.equals(element.rowNum)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = rowNum.hashCode();
            result = 31 * result + columnNum.hashCode();
            result = 31 * result + value.hashCode();
            return result;
        }
    }
}
