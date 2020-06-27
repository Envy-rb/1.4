package com.envy.day41.entity;

import com.envy.day41.exception.CustomNegativeArraySizeException;
import com.envy.day41.exception.IncorrectInputDataException;
import com.envy.day41.exception.OutOfRangeException;

import java.util.ArrayList;
import java.util.List;


public class CustomArray {
    // TODO: 26.06.2020 think about using get/set unsafe methods instead of array[index]
    private  int[] array;
    private static final int SIZE_DEFAULT = 0;

    public CustomArray(int[] array) {
        this.array = array;
    }

    public CustomArray(int length) throws CustomNegativeArraySizeException {
        checkLength(length);
        array = new int[length];
    }

    public CustomArray() {
        array = new int[SIZE_DEFAULT];
    }

    public CustomArray(String input) throws IncorrectInputDataException {
        String[] values;
        values = input.split("[^0-9-]+");
        int arrayLength = values.length;


        if (values.length <= 0) {
            throw new IncorrectInputDataException();
        }
        array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = Integer.parseInt(values[i]);
        }
    }
    //CHECKS
    public void checkLength(int length) throws CustomNegativeArraySizeException {
        if (length < 0) {
            throw new CustomNegativeArraySizeException();
        }
    }

    public void checkIndex(int index) throws OutOfRangeException {
        if (index >= array.length || index < 0) {
            throw new OutOfRangeException();
        }
    }
    //GETTERS/SETTERS
    private int getUnsafe(int index) {
        int result;

        result = array[index];
        return result;
    }

    public int get(int index) throws OutOfRangeException {
        int result;

        checkIndex(index);
        result = array[index];
        return result;
    }

    public void set(int index, int value) throws OutOfRangeException {
        checkIndex(index);
        array[index] = value;
    }
    //SERVICE
    private void swapElements(int index0, int index1) {
        int buffer;

        buffer = array[index0];
        array[index0] = array[index1];
        array[index1] = buffer;
    }

    private int indexOfElementInRangeByCondition(int indexFrom, int indexTo, boolean findMax) {
        int value = Integer.MAX_VALUE;
        if (findMax) {
            value = Integer.MIN_VALUE;
        }
        int result = 0;

        for (int i = indexFrom; i < indexTo + 1; i++) {
            if (findMax == (array[i] > value)) {
                value = array[i];
                result = i;
            }
        }
        return result;
    }

    private int sum() {
        int sum = 0;

        for (int item : array) {
            sum += item;
        }
        return sum;
    }

    public int length() {
        return array.length;
    }

    //SORTING
    public void bubbleSort(boolean byAscending) {
        int length = length();

        for (int i = 0; i < length - 1; i++) {
            int unsortedArea = length - i - 1;
            for (int j = 0; j < unsortedArea; j++) {
                if ((array[j] > array[j + 1]) == byAscending) {
                    swapElements(j, j+1);
                }
            }
        }
    }

    public void shakerSort(boolean byAscending) {
        boolean swapped = true;
        int startPos = 0;
        int endPos = length();

        while (swapped) {
            swapped = false;
            for (int i = startPos; i < endPos - 1; ++i) {
                if ((array[i] > array[i + 1]) == byAscending) {
                    swapElements(i, i + 1);
                    swapped = true;
                }
            }
            if (swapped)
                break;
            swapped = false;
            endPos = endPos - 1;
            for (int i = endPos - 1; i >= startPos; i--) {
                if ((array[i] > array[i + 1]) == byAscending) {
                    swapElements(i, i + 1);
                    swapped = true;
                }
            }
            startPos = startPos + 1;
        }
    }

    public void selectionSort(boolean byAscending) {
        int length = length();

        for (int i = 0; i < length - 1; i++) {
            int index = indexOfElementInRangeByCondition(i, length - 1, !byAscending);
            swapElements(i, index);
        }
    }
    //SEARCH
    public int binarySearch(int key) {//SORTED ARRAY ONLY
        int low = 0;
        int high = length() - 1;
        int index = -1;//not found code

        while (low <= high) {
            int middle = (low + high) / 2;
            int centerValue = array[middle];
            if (centerValue < key)
                low = middle + 1;
            else if (centerValue > key)
                high = middle - 1;
            else
                index = middle;
        }
        return index;
    }

    public int max() {
        int result;

        result = indexOfElementInRangeByCondition(0, length() - 1, true);
        return result;
    }

    public int min() {
        int result;

        result = indexOfElementInRangeByCondition(0, length() - 1, false);
        return result;
    }

    public List<Integer> primeNumbers() {
        List<Integer> result = new ArrayList<>(0);

        for (int num : array  ) {
            if (IntExtension.isPrime(num)) {
                result.add(num);
            }
        }
        return result;
    }

    public List<Integer> fibonacciNumbers() {
        List<Integer> result = new ArrayList<>(0);

        for (int num : array  ) {
            if (IntExtension.isFibonacci(num)) {
                result.add(num);
            }
        }
        return result;
    }

    public List<Integer> uniqueDigitsNumbers() {
        List<Integer> result = new ArrayList<>(0);

        for (int num : array) {
            if (IntExtension.isThreeDigitUnique(num)) {
                result.add(num);
            }
        }
        return result;
    }
    //OVERRIDE METHODS
    @Override
    public boolean equals(Object o) {
        CustomArray equalArray = (CustomArray) o;
        boolean result = true;

        if (o == null) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (equalArray.getUnsafe(i) != array[i]) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return sum() * length();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length(); i++) {
            result.append(String.valueOf(array[i]));
            if (i != length() - 1)
            {
                result.append(", ");
            }
        }
        return result.toString();
    }
}
