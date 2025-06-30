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
    private Long totalPoint;
    private Long paymentAmount;

    @Builder
    public GetPointChargeInfoResDto(Long point, Long bonusPoint, Long totalPoint, Long paymentAmount) {
        this.point = point;
        this.bonusPoint = bonusPoint;
        this.totalPoint = totalPoint;
        this.paymentAmount = paymentAmount;
    }

    public static GetPointChargeInfoResDto from(PointCharge pointCharge) {
        return GetPointChargeInfoResDto.builder()
                .point(pointCharge.getPoint())
                .bonusPoint(pointCharge.getBonusPoint())
                .totalPoint(pointCharge.getTotalPoint())
                .paymentAmount(pointCharge.getPaymentAmount())
                .build();
    }

    public GetPointChargeInfoResVo toVo() {
        return GetPointChargeInfoResVo.builder()
                .point(point)
                .bonusPoint(bonusPoint)
                .totalPoint(totalPoint)
                .paymentAmount(paymentAmount)
                .build();
    }
}
