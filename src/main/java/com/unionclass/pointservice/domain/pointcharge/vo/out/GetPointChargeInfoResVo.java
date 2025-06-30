package com.unionclass.pointservice.domain.pointcharge.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPointChargeInfoResVo {

    private Long point;
    private Long bonusPoint;
    private Long totalPoint;
    private Long paymentAmount;

    @Builder
    public GetPointChargeInfoResVo(Long point, Long bonusPoint, Long totalPoint, Long paymentAmount) {
        this.point = point;
        this.bonusPoint = bonusPoint;
        this.totalPoint = totalPoint;
        this.paymentAmount = paymentAmount;
    }
}
