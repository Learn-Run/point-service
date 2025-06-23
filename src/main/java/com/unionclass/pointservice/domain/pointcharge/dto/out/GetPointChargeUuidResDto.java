package com.unionclass.pointservice.domain.pointcharge.dto.out;

import com.unionclass.pointservice.domain.pointcharge.vo.out.GetPointChargeUuidResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPointChargeUuidResDto {

    private Long pointChargeUuid;

    @Builder
    public GetPointChargeUuidResDto(Long pointChargeUuid) {
        this.pointChargeUuid = pointChargeUuid;
    }

    public GetPointChargeUuidResVo toVo() {
        return GetPointChargeUuidResVo.builder()
                .pointChargeUuid(pointChargeUuid)
                .build();
    }
}
