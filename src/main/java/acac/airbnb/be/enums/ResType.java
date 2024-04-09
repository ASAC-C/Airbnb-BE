package acac.airbnb.be.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResType {
    NONE(-1),
    SUCCESS(0),
    FAIL_EXCEPTION(1),
    FAIL_NO_SUCH_ELEMENT_EXCEPTION(2),
    FAIL_EMPTY_RESULT_DATA_ACCESS_EXCEPTION(3);

    @JsonValue
    private final Integer number;
}