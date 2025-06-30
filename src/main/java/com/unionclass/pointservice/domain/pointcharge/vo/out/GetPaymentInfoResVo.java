package com.unionclass.pointservice.domain.pointcharge.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPaymentInfoResVo {

    private String orderId;
    private String orderName;
    private Long amount;

    @Builder
    public GetPaymentInfoResVo(String orderId, String orderName, Long amount) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.amount = amount;
    }
}
