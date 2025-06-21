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
public class PointCharge extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("충전 포인트 UUID")
    @Column(nullable = false, unique = true, length = 36)
    private Long uuid;

    @Comment("충전할 포인트")
    @Column(nullable = false)
    private Long point;

    @Comment("보너스 포인트")
    private Long bonusPoint;

    @Comment("포인트 지불가격")
    @Column(nullable = false)
    private Long price;

    @Comment("활성 여부")
    @Column(nullable = false)
    private boolean active;

    @Builder
    public PointCharge(Long id, Long uuid, Long point, Long bonusPoint, Long price, boolean active) {
        this.id = id;
        this.uuid = uuid;
        this.point = point;
        this.bonusPoint = bonusPoint;
        this.price = price;
        this.active = active;
    }
}
