package com.thoughtworks.guessnumber;

import org.junit.Assert;
import org.junit.Test;

public class GuessNumberTest {

    @Test
    public void should_generate_answer_when_new_guess_number() {
        GuessNumber guessNumber = new GuessNumber();
        Assert.assertEquals(guessNumber.getAnswer().size(), 4);
    }
}
