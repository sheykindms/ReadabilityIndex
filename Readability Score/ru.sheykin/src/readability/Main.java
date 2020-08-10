package readability;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        String text = reader.read(args[0]);

        Statistics statistics = new Statistics();
        statistics.countStatistics(text);

        ResultPrinter printer = new ResultPrinter(statistics);
        printer.print();
    }
}
