package com.unionclass.pointservice.domain.pointcharge.entity;

import com.unionclass.pointservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

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

    @Builder
    public PointCharge(Long id, Long uuid, Long point, Long bonusPoint, Long paymentAmount, boolean active) {
        this.id = id;
        this.uuid = uuid;
        this.point = point;
        this.bonusPoint = bonusPoint;
        this.paymentAmount = paymentAmount;
        this.active = active;
    }

    public void toggleActive() {
        this.active = !active;
    }
}
