package com.incube;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] tokens = numbers.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;

        for (String token : tokens) {
            int num = toInt(token.trim());
            if (num < 0) {
                negativeNumbers.add(num);
            }
            sum += num;
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException(
                    "Negative numbers not allowed: " + negativeNumbers);
        }

        return sum;
    }

    private int toInt(String token) {
        return token.isEmpty() ? 0 : Integer.parseInt(token);
    }
}
