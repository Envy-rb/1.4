package com.envy.day41.service;

import com.envy.day41.entity.OperationWithRow;

import java.util.Random;

public class JaggedArrayService {
    private static final int MAX_RAND_NUMBER = 4;
    private static final int MAX_ROW_SIZE = 5;
    private static final int MIN_ROW_SIZE = 3;


    private int[][] array;
    private Random randomGenerator = new Random();

    public void initArray(int rows) {
        array = new int[rows][];

        for (int i = 0; i < rows; i++) {
            array[i] = new int[randomGenerator.nextInt(MAX_ROW_SIZE - MIN_ROW_SIZE) + MIN_ROW_SIZE];
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = randomGenerator.nextInt(MAX_RAND_NUMBER);
            }
        }
    }

    public static int indexOfRowElementByCondition(int[] row, boolean findMax) {
        int value = Integer.MAX_VALUE;
        if (findMax) {
            value = Integer.MIN_VALUE;
        }

        for (int i = 0; i < row.length; i++) {
            if (findMax == (row[i] > value)) {
                value = row[i];
            }
        }
        return value;
    }

    private void unsafetySwap(int row0, int row1) {
        int[] buffer = array[row0];
        array[row0] = array[row1];
        array[row1] = buffer;
    }

    public void bubbleSort(OperationWithRow operation, boolean byAscending) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int unsortedArea = length - i - 1;
            for (int j = 0; j < unsortedArea; j++) {
                int value0 = operation.apply(array[j]);
                int value1 = operation.apply(array[j + 1]);
                if ((value0 > value1) == byAscending) {
                    unsafetySwap(j, j + 1);
                }
            }
        }
    }
}
