package readability;

import java.util.Scanner;

public class ResultPrinter {
    private final Statistics statistics;

    public ResultPrinter(Statistics statistics) {
        this.statistics = statistics;
    }

    public void print() {
        System.out.printf("Words: %d\n" +
                        "Sentences: %d\n" +
                        "Characters: %d\n" +
                        "Syllables: %d\n" +
                        "Polysyllables: %d\n", statistics.getCounterOfWords(), statistics.getCounterOfSentences(),
                statistics.getCounterOfCharacters(), statistics.getCounterOfSyllables(),
                statistics.getCounterOfPolysyllables());
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): \n");
        String userInput = readUserInput();

        switch (userInput) {
            case "ARI":
                printResult(new AutomatedReadabilityIndex(statistics));
                break;
            case "FK":
                printResult(new FleschKincaidReadabilityIndex(statistics));
                break;
            case "SMOG":
                printResult(new GobbledygookReadabilityIndex(statistics));
                break;
            case "CL":
                printResult(new ColemanLiauIndex(statistics));
                break;
            case "all":
                printResult(new AutomatedReadabilityIndex(statistics));
                printResult(new FleschKincaidReadabilityIndex(statistics));
                printResult(new GobbledygookReadabilityIndex(statistics));
                printResult(new ColemanLiauIndex(statistics));
                printResult(new AverageAgeCounter(statistics));
                break;
        }
    }

    private void printResult(ReadabilityIndex index) {
        index.printResult();
    }

    private String readUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
