package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@ToString
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ticket {

    private String origin;

    @JsonProperty("origin_name")
    @NonNull
    private String originName;

    private String destination;

    @JsonProperty("destination_name")
    @NonNull
    private String destinationName;

    @JsonProperty("departure_date")
    @JsonFormat(pattern = "d.MM.yy")
    @NonNull
    private LocalDate departureDate;

    @JsonProperty("departure_time")
    @JsonFormat(pattern = "H:m")
    @NonNull
    private LocalTime departureTime;

    @JsonProperty("arrival_date")
    @JsonFormat(pattern = "d.MM.yy")
    @NonNull
    private LocalDate arrivalDate;

    @JsonProperty("arrival_time")
    @NonNull
    private LocalTime arrivalTime;

    private String carrier;

    private int stops;

    private BigDecimal price;
}
