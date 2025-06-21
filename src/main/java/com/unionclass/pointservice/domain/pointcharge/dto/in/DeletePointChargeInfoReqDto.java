package com.unionclass.pointservice.domain.pointcharge.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeletePointChargeInfoReqDto {

    private Long pointChargeUuid;

    @Builder
    public DeletePointChargeInfoReqDto(Long pointChargeUuid) {
        this.pointChargeUuid = pointChargeUuid;
    }

    public static DeletePointChargeInfoReqDto from(Long pointChargeUuid) {
        return DeletePointChargeInfoReqDto.builder()
                .pointChargeUuid(pointChargeUuid)
                .build();
    }
}
