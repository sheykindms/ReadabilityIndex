package readability;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

class Reader {

    protected void run(String fileAddress) {
        ReadabilityTests readabilityTests = new ReadabilityTests();
        String inputString = read(fileAddress);
        readabilityTests.countStatistics(inputString);
        readabilityTests.resultPrinter();
        }

    protected String read(String fileAddress) {

        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream =
                     Files.lines(Paths.get(fileAddress), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}