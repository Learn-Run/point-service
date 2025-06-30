package com.unionclass.pointservice.domain.pointcharge.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPointChargeInfoResVo {

    private Long point;
    private Long bonusPoint;
    private Long paymentAmount;

    @Builder
    public GetPointChargeInfoResVo(Long point, Long bonusPoint, Long paymentAmount) {
        this.point = point;
        this.bonusPoint = bonusPoint;
        this.paymentAmount = paymentAmount;
    }
}
