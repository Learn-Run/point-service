package com.unionclass.pointservice.domain.pointcharge.vo.in;

import lombok.Getter;

@Getter
public class UpdatePointChargeInfoReqVo {

    private Long point;
    private Long bonusPoint;
    private Long paymentAmount;
}
