package com.unionclass.pointservice.domain.pointcharge.entity;

import com.unionclass.pointservice.common.entity.BaseEntity;
import com.unionclass.pointservice.domain.pointcharge.dto.in.UpdatePointChargeInfoReqDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "point_charge")
public class PointCharge extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("포인트 충전 정보 UUID")
    @Column(nullable = false, unique = true, length = 36)
    private Long uuid;

    @Comment("충전할 포인트")
    @Column(nullable = false)
    private Long point;

    @Comment("보너스 포인트")
    private Long bonusPoint;

    @Comment("포인트 결제금액")
    @Column(nullable = false)
    private Long paymentAmount;

    @Comment("활성 여부")
    @Column(nullable = false)
    private boolean active;

    @Comment("삭제 여부")
    @Column(nullable = false)
    private boolean deleted;

    @Comment("삭제 일시")
    private LocalDateTime deletedAt;

    @Builder
    public PointCharge(
            Long id, Long uuid, Long point, Long bonusPoint, Long paymentAmount,
            boolean active, boolean deleted, LocalDateTime deletedAt
    ) {
        this.id = id;
        this.uuid = uuid;
        this.point = point;
        this.bonusPoint = bonusPoint;
        this.paymentAmount = paymentAmount;
        this.active = active;
        this.deleted = deleted;
        this.deletedAt = deletedAt;
    }

    public void toggleActive() {
        this.active = !active;
    }

    public void updateInfo(UpdatePointChargeInfoReqDto updatePointChargeInfoReqDto) {
        this.point = updatePointChargeInfoReqDto.getPoint() == null ? point : updatePointChargeInfoReqDto.getPoint();
        this.bonusPoint = updatePointChargeInfoReqDto.getBonusPoint() == null ? bonusPoint : updatePointChargeInfoReqDto.getBonusPoint();
        this.paymentAmount = updatePointChargeInfoReqDto.getPaymentAmount() == null ? paymentAmount : updatePointChargeInfoReqDto.getPaymentAmount();
    }
}
