package com.unionclass.pointservice.domain.pointcharge.dto.in;

import com.unionclass.pointservice.domain.pointcharge.entity.PointCharge;
import com.unionclass.pointservice.domain.pointcharge.vo.in.CreatePointChargeInfoReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreatePointChargeInfoReqDto {

    private Long point;
    private Long bonusPoint;
    private Long paymentAmount;
    private boolean active;

    @Builder
    public CreatePointChargeInfoReqDto(Long point, Long bonusPoint, Long paymentAmount, boolean active) {
        this.point = point;
        this.bonusPoint = bonusPoint;
        this.paymentAmount = paymentAmount;
        this.active = active;
    }

    public static CreatePointChargeInfoReqDto from(CreatePointChargeInfoReqVo createPointChargeInfoReqVo) {
        return CreatePointChargeInfoReqDto.builder()
                .point(createPointChargeInfoReqVo.getPoint())
                .bonusPoint(createPointChargeInfoReqVo.getBonusPoint())
                .paymentAmount(createPointChargeInfoReqVo.getPaymentAmount())
                .active(createPointChargeInfoReqVo.isActive())
                .build();
    }

    public PointCharge toEntity(Long uuid) {

        long bonus = bonusPoint != null ? bonusPoint : 0L;

        return PointCharge.builder()
                .uuid(uuid)
                .point(point)
                .bonusPoint(bonus)
                .totalPoint(point + bonus)
                .paymentAmount(paymentAmount)
                .active(active)
                .deleted(false)
                .build();
    }
}
