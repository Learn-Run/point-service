package com.unionclass.pointservice.domain.pointcharge.dto.out;

import com.unionclass.pointservice.domain.pointcharge.vo.out.GetPaymentInfoResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPaymentInfoResDto {

    private String orderId;
    private String orderName;
    private Long amount;

    @Builder
    public GetPaymentInfoResDto(String orderId, String orderName, Long amount) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.amount = amount;
    }

    public static GetPaymentInfoResDto of(String orderId, String orderName, Long amount) {
        return GetPaymentInfoResDto.builder()
                .orderId(orderId)
                .orderName(orderName)
                .amount(amount)
                .build();
    }

    public GetPaymentInfoResVo toVo() {
        return GetPaymentInfoResVo.builder()
                .orderId(orderId)
                .orderName(orderName)
                .amount(amount)
                .build();
    }
}
