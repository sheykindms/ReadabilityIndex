package readability;

public class ColemanLiauIndex extends ReadabilityIndex {

    public ColemanLiauIndex(Statistics statistics) {
        super(statistics);
    }

    @Override
    public double getIndex() {
        return 0.0588 * statistics.getCounterOfCharacters() * 100 / statistics.getCounterOfWords()
                - 0.296 * statistics.getCounterOfSentences() * 100 / statistics.getCounterOfWords() - 15.8;
    }

    @Override
    public void printResult() {
        double index = getIndex();
        System.out.printf("Coleman–Liau index: %.2f  (about %d year olds).\n", index, statistics.getAge(index));
    }
}
