package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String s) {

        if ( s == null || s.length() == 0 ) {
            return 0;
        }

        Set<Character> characters = new HashSet<>();

        for (char c: s.toCharArray()) {
             if (Character.isDigit(c)) {
                characters.add(c);
            }
        }

        return characters.size();
    }
}