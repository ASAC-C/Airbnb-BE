package acac.airbnb.be.enums;

import lombok.Getter;

public enum ResType {
    NONE(-1),
    SUCCESS(0),
    FAIL_EXCEPTION(1),
    FAIL_ENTITY_NOT_FOUND_EXCEPTION(2);

    // ================================================ //

    @Getter
    private final Integer number;

    ResType(Integer number) {
        this.number = number;
    }
}