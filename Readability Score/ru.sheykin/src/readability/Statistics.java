package readability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Statistics {
    private int counterOfCharacters;
    private int counterOfSentences;
    private int counterOfWords;
    private int counterOfSyllables;
    private int counterOfPolysyllables;

    public void countStatistics(String text) {
        String[] sentences = text.split("[!?.\\n] *");
        String[] words = text.split("[!\\t\\n?]*[\\s]");

        counterOfCharacters = text.replaceAll("[\\n\\t\\s]*", "").length();
        counterOfSentences = sentences.length;
        counterOfWords = words.length;

        Pattern pattern = Pattern.compile("[aeiouyAEIOUY][^aeiouyAEIOU\\s]|[aiouyAIOUY]$");
        counterOfSyllables = 0;
        for (String word : words) {
            counterOfSyllables += count(word, pattern);
        }
    }

    public int getAge(double score) {
        int scoreToCompare = (int) Math.round(score);
        int yearsOld;
        if (scoreToCompare <= 1) yearsOld = 6;
        else if (scoreToCompare <= 2) yearsOld = 7;
        else if (scoreToCompare <= 3) yearsOld = 9;
        else if (scoreToCompare <= 4) yearsOld = 10;
        else if (scoreToCompare <= 5) yearsOld = 11;
        else if (scoreToCompare <= 6) yearsOld = 12;
        else if (scoreToCompare <= 7) yearsOld = 13;
        else if (scoreToCompare <= 8) yearsOld = 14;
        else if (scoreToCompare <= 9) yearsOld = 15;
        else if (scoreToCompare <= 10) yearsOld = 16;
        else if (scoreToCompare <= 11) yearsOld = 17;
        else if (scoreToCompare <= 12) yearsOld = 18;
        else if (scoreToCompare <= 13) yearsOld = 24;
        else yearsOld = 25;
        return yearsOld;
    }

    public int getCounterOfCharacters() {
        return counterOfCharacters;
    }

    public int getCounterOfSentences() {
        return counterOfSentences;
    }

    public int getCounterOfWords() {
        return counterOfWords;
    }

    public int getCounterOfSyllables() {
        return counterOfSyllables;
    }

    public int getCounterOfPolysyllables() {
        return counterOfPolysyllables;
    }

    private int count(String s, Pattern pattern) {
        Matcher matcher = pattern.matcher(s.replaceAll("\\W+", ""));
        int counter = 0;
        while (matcher.find()) counter++;
        if (counter == 0) counter = 1;
        else if (counter > 2) counterOfPolysyllables++;
        return counter;
    }
}
