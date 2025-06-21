package com.unionclass.pointservice.domain.pointcharge.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ToggleActiveStatusReqDto {

    private Long pointChargeUuid;

    @Builder
    public ToggleActiveStatusReqDto(Long pointChargeUuid) {
        this.pointChargeUuid = pointChargeUuid;
    }

    public static ToggleActiveStatusReqDto from(Long pointChargeUuid) {
        return ToggleActiveStatusReqDto.builder()
                .pointChargeUuid(pointChargeUuid)
                .build();
    }
}
