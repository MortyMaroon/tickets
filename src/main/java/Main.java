import models.Ticket;
import services.CalculationService;
import services.ReadingService;
import services.implementation.AverageTimeCalculator;
import services.implementation.PercentileCalculator;
import services.implementation.SimpleFileReaderService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<CalculationService> calculationServices = new HashSet<>() {{
            add(new AverageTimeCalculator());
            add(new PercentileCalculator());
        }};
        ReadingService readingService = new SimpleFileReaderService();
        Collection<Ticket> tickets = readingService.read();

        calculationServices.forEach(calculationService -> calculationService.calculate(tickets));
    }
}
