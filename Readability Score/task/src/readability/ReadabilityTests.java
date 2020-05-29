package readability;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ReadabilityTests {

    int counterOfCharacters;
    int counterOfSentences;
    int counterOfWords;
    int counterOfSyllables;
    int counterOfPolysyllables;

    protected void countStatistics(String inputString) {

        String[] sentences = inputString.split("[!?.\\n] *");
        String[] words = inputString.split("[!\\t\\n?]*[\\s]");

        counterOfCharacters = inputString.replaceAll("[\\n\\t\\s]*", "").length();
        counterOfSentences = sentences.length;
        counterOfWords = words.length;

        Pattern pattern = Pattern.compile("[aeiouyAEIOUY][^aeiouyAEIOU\\s]|[aiouyAIOUY]$");
        counterOfSyllables = 0;
        for (String word : words) {
            counterOfSyllables += count(word, pattern);
        }
    }

    protected void resultPrinter() {
        System.out.printf("Words: %d\n" +
                "Sentences: %d\n" +
                "Characters: %d\n" +
                "Syllables: %d\n" +
                "Polysyllables: %d\n", counterOfWords, counterOfSentences, counterOfCharacters, counterOfSyllables, counterOfPolysyllables);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): \n");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        switch (userInput) {
            case "ARI":
                System.out.printf("Automated Readability Index: %.2f  (about %d year olds).\n", automatedReadabilityIndex(), getAge(automatedReadabilityIndex()));
                break;
            case "FK":
                System.out.printf("Flesch–Kincaid readability tests: %.2f  (about %d year olds).\n", fkReadabilityIndex(), getAge(fkReadabilityIndex()));
                break;
            case "SMOG":
                System.out.printf("Simple Measure of Gobbledygook: %.2f  (about %d year olds).\n", smogReadabilityIndex(), getAge(smogReadabilityIndex()));
                break;
            case "CL":
                System.out.printf("Coleman–Liau index: %.2f  (about %d year olds).\n", clReadabilityIndex(), getAge(clReadabilityIndex()));
                break;
            case "all":
                System.out.printf("Automated Readability Index: %.2f  (about %d year olds).\n", automatedReadabilityIndex(), getAge(automatedReadabilityIndex()));
                System.out.printf("Flesch–Kincaid readability tests: %.2f  (about %d year olds).\n", fkReadabilityIndex(), getAge(fkReadabilityIndex()));
                System.out.printf("Simple Measure of Gobbledygook: %.2f  (about %d year olds).\n", smogReadabilityIndex(), getAge(smogReadabilityIndex()));
                System.out.printf("Coleman–Liau index: %.2f  (about %d year olds).\n", clReadabilityIndex(), getAge(clReadabilityIndex()));
                System.out.printf("\n" +
                        "This text should be understood in average by %.2f years olds.", averageAgeCounter());
                break;
        }
    }

    protected double averageAgeCounter() {
        int autoRead = getAge(automatedReadabilityIndex());
        int fkRead = getAge(fkReadabilityIndex());
        int smogRead = getAge(smogReadabilityIndex());
        int clREad = getAge(clReadabilityIndex());
        return (autoRead + fkRead + smogRead + clREad) / 4.0;
    }

    protected int count(String s, Pattern pattern) {
        Matcher matcher = pattern.matcher(s.replaceAll("\\W+", ""));
        int counter = 0;
        while (matcher.find()) counter++;
        if (counter == 0) counter = 1;
        else if (counter > 2) counterOfPolysyllables++;
        return counter;
    }

    protected double automatedReadabilityIndex() {
        return 4.71 * counterOfCharacters / counterOfWords + 0.5 *
                counterOfWords / counterOfSentences - 21.43;
    }

    protected double fkReadabilityIndex() {
        return 0.39 * counterOfWords / counterOfSentences +
                11.8 * counterOfSyllables / counterOfWords - 15.59;
    }

    protected double smogReadabilityIndex() {
        return 1.043 *
                Math.sqrt(counterOfPolysyllables * 30.0 / counterOfSentences)
                + 3.1291;
    }

    protected double clReadabilityIndex() {
        return 0.0588 * counterOfCharacters * 100 / counterOfWords
                - 0.296 * counterOfSentences * 100 / counterOfWords - 15.8;
    }

    protected int getAge(double score) {
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
}