package readability;

public class AutomatedReadabilityIndex extends ReadabilityIndex {

    public AutomatedReadabilityIndex(Statistics statistics) {
        super(statistics);
    }

    @Override
    public double getIndex() {
        return 4.71 * statistics.getCounterOfCharacters() / statistics.getCounterOfWords() + 0.5 *
                statistics.getCounterOfWords() / statistics.getCounterOfSentences() - 21.43;
    }

    @Override
    public void printResult() {
        double index = getIndex();
        System.out.printf("Automated Readability Index: %.2f  (about %d year olds).\n", index, statistics.getAge(index));
    }
}
