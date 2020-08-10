package readability;

import java.util.ArrayList;
import java.util.List;

public class AverageAgeCounter extends ReadabilityIndex {
    private final List<ReadabilityIndex> indexList = new ArrayList<>();

    public AverageAgeCounter(Statistics statistics) {
        super(statistics);
        indexList.add(new AutomatedReadabilityIndex(statistics));
        indexList.add(new GobbledygookReadabilityIndex(statistics));
        indexList.add(new FleschKincaidReadabilityIndex(statistics));
        indexList.add(new ColemanLiauIndex(statistics));
    }

    @Override
    public double getIndex() {
        int result = 0;
        for (ReadabilityIndex index : indexList) {
            result += statistics.getAge(index.getIndex());
        }
        return result / 4.0;
    }

    @Override
    public void printResult() {
        double index = getIndex();
        System.out.printf("\n" +
                "This text should be understood in average by %.2f years olds.", index);
    }
}
