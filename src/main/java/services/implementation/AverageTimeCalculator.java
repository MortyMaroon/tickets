package services.implementation;

import models.Ticket;
import services.CalculationService;
import utils.LocationZoneIdEnum;
import utils.TimeUtils;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.OptionalDouble;
import java.util.concurrent.TimeUnit;

public class AverageTimeCalculator implements CalculationService {

    @Override
    public void calculate(Collection<Ticket> tickets) {
        tickets.stream()
                .mapToLong(TimeUtils::getFlightDuration)
                .average()
                .ifPresent(d -> System.out.println("Average flight time between Vladivostok and Tel Aviv: " +
                        TimeUtils.getTimeBySeconds(d)));
    }
}
