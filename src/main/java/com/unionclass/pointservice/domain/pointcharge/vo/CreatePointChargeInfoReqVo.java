package com.unionclass.pointservice.domain.pointcharge.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreatePointChargeInfoReqVo {

    @NotNull(message = "충전할 포인트는 필수입력입니다.")
    private Long point;
    private Long bonusPoint;

    @NotNull(message = "결제금액은 필수입력입니다.")
    private Long paymentAmount;

    @NotNull(message = "활성여부는 필수입력입니다.")
    private boolean active;
}
