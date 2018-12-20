package com.bravi.demo.match_sequence;

import java.util.HashMap;


public class Sequence {


    private String[] openBrackets = {"(", "{", "["};
    private String[] closedBrackets = {")", "}", "]"};
    private HashMap<String, String> matchvalues;

    public Sequence() {

        matchvalues = new HashMap<>();
        matchvalues.put(openBrackets[0], closedBrackets[0]);
        matchvalues.put(openBrackets[1], closedBrackets[1]);
        matchvalues.put(openBrackets[2], closedBrackets[2]);
    }

    /**
     * Test if the specified array of brackets is valid
     *
     * @param brackets An array containing a sequence of brackets
     * @return true if is a valid sequence , false otherwise
     * @ since 0.1
     */
    public boolean isValidSequence(String[] brackets) {

        int leftIndex;
        int rightIndex = 0;
        if (isOpenBracket(brackets[rightIndex])) {
            for (int i = 0; i < brackets.length; i++) {
                rightIndex = i;
                int count = 0;
                if (!isOpenBracket(brackets[rightIndex])) {
                    return false;
                }
                while (isOpenBracket(brackets[rightIndex])) {
                    rightIndex++;
                    count++;
                    if (rightIndex == brackets.length) {
                        return false;
                    }
                }
                leftIndex = rightIndex - 1;
                while (count != 0) {
                    if (isMatch(brackets, leftIndex, rightIndex)) {
                        leftIndex--;
                        rightIndex++;
                        count--;
                        if (rightIndex > brackets.length - 1 && count != 0) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                i = rightIndex - 1;

            }

        } else {
            return false;
        }
        return true;
    }

    private boolean isOpenBracket(String bracket) {
        for (String openBracket : openBrackets) {
            if (openBracket.equals(bracket)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatch(String[] brackets, int leftIndex, int rightIndex) {
        String match = matchvalues.get(brackets[leftIndex]);
        return brackets[rightIndex].equals(match);
    }

}
