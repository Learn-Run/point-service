package com.unionclass.pointservice.domain.pointcharge.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPointChargeUuidResVo {

    private Long pointChargeUuid;

    @Builder
    public GetPointChargeUuidResVo(Long pointChargeUuid) {
        this.pointChargeUuid = pointChargeUuid;
    }
}
