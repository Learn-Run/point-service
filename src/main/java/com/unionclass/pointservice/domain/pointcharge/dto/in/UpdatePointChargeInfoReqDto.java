package com.unionclass.pointservice.domain.pointcharge.dto.in;

import com.unionclass.pointservice.domain.pointcharge.vo.in.UpdatePointChargeInfoReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdatePointChargeInfoReqDto {

    private Long pointChargeUuid;
    private Long point;
    private Long bonusPoint;
    private Long paymentAmount;

    @Builder
    public UpdatePointChargeInfoReqDto(
            Long pointChargeUuid, Long point, Long bonusPoint, Long paymentAmount
    ) {
        this.pointChargeUuid = pointChargeUuid;
        this.point = point;
        this.bonusPoint = bonusPoint;
        this.paymentAmount = paymentAmount;
    }

    public static UpdatePointChargeInfoReqDto of(Long pointChargeUuid, UpdatePointChargeInfoReqVo updatePointChargeInfoReqVo) {
        return UpdatePointChargeInfoReqDto.builder()
                .pointChargeUuid(pointChargeUuid)
                .point(updatePointChargeInfoReqVo.getPoint())
                .bonusPoint(updatePointChargeInfoReqVo.getBonusPoint())
                .paymentAmount(updatePointChargeInfoReqVo.getPaymentAmount())
                .build();
    }
}
