package com.bravi.demo.match_sequence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatchSequenceApplicationTests {


    @Test
    public void matchSequence1() {
        String[] sequence = new String[]{"(", ")", "{", "}", "[", "]"};
        Sequence validade = new Sequence();
        Assert.isTrue(validade.isValidSequence(sequence), "Sequence array of brackets is valid!");
    }

    @Test
    public void matchSequence2() {
        String[] sequence = new String[]{"[", "{", "(", ")", "}", "]"};
        Sequence validade = new Sequence();
        Assert.isTrue(validade.isValidSequence(sequence), "Sequence array of brackets is valid!");
    }

    @Test
    public void matchSequence3() {
        String[] sequence = new String[]{"[", "]", "{", "(", ")"};
        Sequence validade = new Sequence();
        Assert.isTrue(!validade.isValidSequence(sequence), "Sequence array of brackets is not valid!");
    }

    @Test
    public void matchSequence4() {
        String[] sequence = new String[]{"[", "{", ")", "]"};
        Sequence validade = new Sequence();
        Assert.isTrue(!validade.isValidSequence(sequence), "Sequence array of brackets is not valid!");
    }

    @Test
    public void matchSequence5() {
        String[] sequence = new String[]{"[", "(", "("};
        Sequence validade = new Sequence();
        Assert.isTrue(!validade.isValidSequence(sequence), "Sequence array of brackets is not valid!");
    }

    @Test
    public void matchSequence6() {
        String[] sequence = new String[]{"(", ")", ")", ")"};
        Sequence validade = new Sequence();
        validade.isValidSequence(sequence);
    }

}

