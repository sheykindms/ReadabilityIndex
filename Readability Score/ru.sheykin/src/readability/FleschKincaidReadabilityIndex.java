package readability;

public class FleschKincaidReadabilityIndex extends ReadabilityIndex {

    public FleschKincaidReadabilityIndex(Statistics statistics) {
        super(statistics);
    }

    @Override
    public double getIndex() {
        return 0.39 * statistics.getCounterOfWords() / statistics.getCounterOfSentences() +
                11.8 * statistics.getCounterOfSyllables() / statistics.getCounterOfWords() - 15.59;
    }

    @Override
    public void printResult() {
        double index = getIndex();
        System.out.printf("Flesch–Kincaid readability tests: %.2f  (about %d year olds).\n", index, statistics.getAge(index));
    }
}
