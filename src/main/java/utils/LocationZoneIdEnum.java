package utils;

import lombok.Getter;

import java.time.ZoneId;

@Getter
public enum LocationZoneIdEnum {

    VLADIVOSTOK("Владивосток", ZoneId.of("Asia/Vladivostok")),
    TEL_AVIV("Тель-Авив", ZoneId.of("Asia/Jerusalem"));

    private final String russianName;
    private final ZoneId zoneId;

    LocationZoneIdEnum(String russianName, ZoneId zoneId) {
        this.russianName = russianName;
        this.zoneId = zoneId;
    }

    public static LocationZoneIdEnum valueFor(String russianName) {
        if (russianName == null) {
            return null;
        }

        for (LocationZoneIdEnum locationZoneIdEnum : LocationZoneIdEnum.values()) {
            if (locationZoneIdEnum.getRussianName().equalsIgnoreCase(russianName)) {
                return locationZoneIdEnum;
            }
        }

        return null;
    }
}
