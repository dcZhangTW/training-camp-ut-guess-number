package com.thoughtworks.guessnumber;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class GuessNumber {
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

    public String guessNumber() {
        return "";
    }
}
