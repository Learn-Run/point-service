package com.unionclass.pointservice.domain.pointcharge.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPaymentInfoReqDto {

    private Long pointChargeUuid;

    @Builder
    public GetPaymentInfoReqDto(Long pointChargeUuid) {
        this.pointChargeUuid = pointChargeUuid;
    }

    public static GetPaymentInfoReqDto from(Long pointChargeUuid) {
        return GetPaymentInfoReqDto.builder()
                .pointChargeUuid(pointChargeUuid)
                .build();
    }
}
