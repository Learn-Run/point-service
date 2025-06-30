package com.unionclass.pointservice.domain.memberpoint.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.unionclass.pointservice.common.exception.BaseException;
import com.unionclass.pointservice.common.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PointType {

    USE("USE"),
    EARN("EARN"),
    TRANSFER_OUT("TRANSFER_OUT"),
    TRANSFER_IN("TRANSFER_IN"),
    SETTLEMENT("SETTLEMENT")
    ;

    private final String pointType;

    @JsonValue
    public String getPointType() { return pointType; }

    @JsonCreator
    public static PointType fromString(String value) {
        for (PointType pointType : PointType.values()) {
            if (pointType.pointType.equals(value)) {
                return pointType;
            }
        }
        throw new BaseException(ErrorCode.INVALID_POINT_TYPE_VALUE);
    }
}
