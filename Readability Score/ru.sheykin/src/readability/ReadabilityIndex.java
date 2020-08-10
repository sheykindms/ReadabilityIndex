package readability;

public abstract class ReadabilityIndex {
    Statistics statistics;

    public ReadabilityIndex(Statistics statistics) {
        this.statistics = statistics;
    }

    public abstract double getIndex();

    public abstract void printResult();
}
