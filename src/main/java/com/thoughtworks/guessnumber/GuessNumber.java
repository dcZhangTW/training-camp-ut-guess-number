package com.thoughtworks.guessnumber;

import lombok.Getter;

import java.util.ArrayList;

@Getter
class GuessNumber {
    private ArrayList<Integer> answer;
    private int guessCount = 0;

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

        if (checkInputString(input)) {
            return "Wrong Input, input again";
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
                return "Game over";
            }
        }

        if (guessCount > 6) {
            return "Game over";
        }

        return resultA + "A" + resultB + "B";
    }
}
