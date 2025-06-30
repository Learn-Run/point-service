package com.unionclass.pointservice.domain.pointcharge.dto.out;

import com.unionclass.pointservice.domain.pointcharge.entity.PointCharge;
import com.unionclass.pointservice.domain.pointcharge.vo.out.GetPointChargeInfoResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPointChargeInfoResDto {

    private Long point;
    private Long bonusPoint;
    private Long paymentAmount;

    @Builder
    public GetPointChargeInfoResDto(Long point, Long bonusPoint, Long paymentAmount) {
        this.point = point;
        this.bonusPoint = bonusPoint;
        this.paymentAmount = paymentAmount;
    }

    public static GetPointChargeInfoResDto from(PointCharge pointCharge) {
        return GetPointChargeInfoResDto.builder()
                .point(pointCharge.getPoint())
                .bonusPoint(pointCharge.getBonusPoint())
                .paymentAmount(pointCharge.getPaymentAmount())
                .build();
    }

    public GetPointChargeInfoResVo toVo() {
        return GetPointChargeInfoResVo.builder()
                .point(point)
                .bonusPoint(bonusPoint)
                .paymentAmount(paymentAmount)
                .build();
    }
}
