package com.thoughtworks.guessnumber;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class GuessNumberTest {

    private static ArrayList<Integer> testAnswer;

    @Before
    public void setUp() {
        testAnswer = new ArrayList<>();
        testAnswer.add(1);
        testAnswer.add(2);
        testAnswer.add(3);
        testAnswer.add(4);
    }

    @Test
    public void should_generate_answer_when_new_guess_number() {
        GuessNumber guessNumber = new GuessNumber();
        Assert.assertEquals(guessNumber.getAnswer().size(), 4);
    }

    @Test
    public void should_return_4A0B_when_all_number_and_position_right() {
        GuessNumber guessNumber = new GuessNumber(testAnswer);
        String result = guessNumber.guessNumber("1234");
        Assert.assertEquals("4A0B", result);
    }

    @Test
    public void should_return_0A0B_when_all_number_and_position_wrong() {
        GuessNumber guessNumber = new GuessNumber(testAnswer);
        String result = guessNumber.guessNumber("5678");
        Assert.assertEquals("0A0B", result);
    }

    @Test
    public void should_return_2A2B_when_two_number_right_position_and_two_number_wrong_position() {
        GuessNumber guessNumber = new GuessNumber(testAnswer);
        String result = guessNumber.guessNumber("1243");
        Assert.assertEquals("2A2B", result);
    }

    @Test
    public void should_return_wrong_input_when_not_give_4_number() {
        GuessNumber guessNumber = new GuessNumber(testAnswer);
        String result = guessNumber.guessNumber("12");
        Assert.assertEquals("Wrong Input, input again", result);
    }
}
