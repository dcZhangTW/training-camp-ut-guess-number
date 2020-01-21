package com.thoughtworks.guessnumber;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Scanner;

@Getter
class GuessNumber {
    private ArrayList<Integer> answer;
    private int guessCount = 0;

    public static String WRONG_INPUT_MSG = "Wrong Input, input again";
    public static String GAME_OVER = "Game over";

    GuessNumber() {
        this.answer = generateAnswer();
    }

    GuessNumber(ArrayList<Integer> answer) {
        this.answer = answer;
    }

    private ArrayList<Integer> generateAnswer() {
        ArrayList<Integer> answer = new ArrayList<>();
        while (answer.size() < 4) {
            Integer num = (int) Math.floor(Math.random() * 10);
            if (!answer.contains(num)) {
                answer.add(num);
            }
        }
        return answer;
    }

    private boolean checkInputString(String input) {
        int inputCount = 0;

        if (input.length() != 4) return true;
        boolean result = false;

        while (inputCount < input.length()) {
            String number = input.substring(inputCount, inputCount + 1);
            if (input.indexOf(number) != input.lastIndexOf(number)) {
                result = true;
                break;
            }
            inputCount++;
        }

        return result;
    }

    String guessNumber(String input) {
        int inputCount = 0;
        int resultA = 0;
        int resultB = 0;

        if (guessCount > 6) {
            return GAME_OVER;
        }

        if (checkInputString(input)) {
            return WRONG_INPUT_MSG;
        }

        while (inputCount < input.length()) {
            String number = input.substring(inputCount, inputCount + 1);
            String answerNumber = answer.get(inputCount).toString();
            if (answerNumber.equals(number)) {
                resultA += 1;
            } else if (answer.contains(Integer.valueOf(number))) {
                resultB += 1;
            }
            inputCount ++;
        }

        if (resultA < 4) {
            guessCount ++;
            if (guessCount == 6) {
                return GAME_OVER + "Answer:" + answer;
            }
        }

        return resultA + "A" + resultB + "B";
    }

    public static void main(String[] args) {
        String lastResult = "";
        ArrayList<String> results = new ArrayList<>();
        GuessNumber guessNumber = new GuessNumber();
        System.out.println("Welcome to guess number game, please input your first guess:");
        Scanner scanner = new Scanner(System.in);
        while (!lastResult.equals(GuessNumber.GAME_OVER) && !lastResult.equals("4A0B")) {
            String firstInput = scanner.nextLine();
            String firstResult = guessNumber.guessNumber(firstInput);
            if (results.size() > 0) {
                results.forEach(System.out::println);
            }
            System.out.println("本次输入结果：" + firstResult);
            results.add(firstResult);
            lastResult = firstResult;
        }
    }
}
