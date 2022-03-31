package services.implementation;

import models.Ticket;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import services.CalculationService;
import utils.LocationZoneIdEnum;
import utils.TimeUtils;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class PercentileCalculator implements CalculationService {

    private final static Double QUANTILE_90 = 90d;
    private final Percentile percentile;

    public PercentileCalculator() {
        percentile = new Percentile(QUANTILE_90);
    }

    public PercentileCalculator(Double quantile) {
        percentile = new Percentile(quantile);
    }

    @Override
    public void calculate(Collection<Ticket> tickets) {
        double[] sortedFlightDuration = tickets.stream()
                .mapToLong(TimeUtils::getFlightDuration)
                .boxed()
                .sorted()
                .mapToDouble(Long::doubleValue)
                .toArray();

        percentile.setData(sortedFlightDuration);
        double result = percentile.evaluate();
        System.out.println("90th percentile of flight time between Vladivostok and Tel Aviv: " +
                TimeUtils.getTimeBySeconds(result));
    }
}
