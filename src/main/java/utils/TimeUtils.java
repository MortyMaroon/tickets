package utils;

import exception.LocationZoneException;
import models.Ticket;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class TimeUtils {

    public static String getTimeBySeconds(Double seconds) {
        Duration duration = Duration.ofMinutes(seconds.longValue());
        return LocalTime.MIN.plus(duration).toString();
    }

    public static Long getFlightDuration(Ticket ticket) {
        ZonedDateTime zonedDepartureTime = ZonedDateTime.of(
                ticket.getDepartureDate(),
                ticket.getDepartureTime(),
                getZoneIdByRussianName(ticket.getOriginName()));

        ZonedDateTime zonedArrivalTime = ZonedDateTime.of(
                ticket.getArrivalDate(),
                ticket.getArrivalTime(),
                getZoneIdByRussianName(ticket.getDestinationName()));

        long epochSecondDeparture = zonedDepartureTime.toInstant().getEpochSecond();
        long epochSecondArrival = zonedArrivalTime.toInstant().getEpochSecond();
        return TimeUnit.SECONDS.toMinutes(epochSecondArrival - epochSecondDeparture);
    }

    private static ZoneId getZoneIdByRussianName(String russianName) {
        return Optional.ofNullable(LocationZoneIdEnum.valueFor(russianName))
                .orElseThrow(() -> new LocationZoneException(russianName))
                .getZoneId();
    }
}
