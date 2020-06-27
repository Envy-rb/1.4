package com.envy.day41.service;

import com.envy.day41.entity.CustomArray;
import com.envy.day41.exception.IncorrectInputDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class CustomArrayService {
    private static final String DEFAULT_FILE_PATH = "resources/file/default.txt";
    private static final String USER_FILE_PATH = "resources/file/user.txt";

    private Random randomGenerator = new Random();
    private CustomArray customArray;

    public void fillFromFile() throws IOException, IncorrectInputDataException {
        Path inputFile = Paths.get(USER_FILE_PATH);

        if (!Files.exists(inputFile)) {
            inputFile = Paths.get(DEFAULT_FILE_PATH);
        }
        customArray = new CustomArray(Files.readString(inputFile));
    }

    public void fillRandom(int length, int maxValue) {
        int[] initArray = new int[length];

        for (int i = 0; i < length; i++) {
            initArray[i] = randomGenerator.nextInt(maxValue);
        }
        customArray = new CustomArray(initArray);
    }

    public void fillFromConsole() throws IncorrectInputDataException {
        Scanner consoleScanner = new Scanner(System.in);
        String input = consoleScanner.nextLine();
        customArray = new CustomArray(input);
    }

    public CustomArray getArray() {
        return customArray;
    }

}
