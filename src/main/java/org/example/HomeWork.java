package org.example;


import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу https://codeforces.com/problemset/problem/1324/C
     */
    @SneakyThrows
    public void frogSteps(InputStream in, OutputStream out) {
        List<String> frogList = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.toList());

        int steps = Integer.parseInt(frogList.get(0));

        System.out.println(frogList);

        List<Integer> res = new ArrayList<>(steps);

        for (int i = 1; i <= steps; i++) {
            res.add(findMax(frogList.get(i).toCharArray()));

        }

        String resStr = res.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator();
        out.write(resStr.getBytes(StandardCharsets.UTF_8));
    }

    private Integer findMax(char[] charArray) {
        int maxStep = 0;
        int currentStep = 0;
        for (char c : charArray) {
            if (c == 'L') {
                currentStep++;
                maxStep = Math.max(maxStep, currentStep);
            } else currentStep = 0;
        }
        return maxStep + 1;
    }


}
