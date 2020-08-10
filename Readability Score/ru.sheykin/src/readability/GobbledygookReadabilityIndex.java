package readability;

public class GobbledygookReadabilityIndex extends ReadabilityIndex {

    public GobbledygookReadabilityIndex(Statistics statistics) {
        super(statistics);
    }

    @Override
    public double getIndex() {
        return 1.043 *
                Math.sqrt(statistics.getCounterOfPolysyllables() * 30.0 / statistics.getCounterOfSentences())
                + 3.1291;
    }

    @Override
    public void printResult() {
        double index = getIndex();
        System.out.printf("Simple Measure of Gobbledygook: %.2f  (about %d year olds).\n", index, statistics.getAge(index));
    }
}
