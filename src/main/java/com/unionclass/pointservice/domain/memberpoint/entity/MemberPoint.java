package com.unionclass.pointservice.domain.memberpoint.entity;

import com.unionclass.pointservice.common.entity.BaseEntity;
import com.unionclass.pointservice.domain.memberpoint.enums.PointType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member_point")
public class MemberPoint extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long uuid;

    private String memberUuid;

    private Long delta;

    private Long point;

    private PointType type;

    @Builder
    public MemberPoint(Long id, Long uuid, String memberUuid, Long delta, Long point, PointType type) {
        this.id = id;
        this.uuid = uuid;
        this.memberUuid = memberUuid;
        this.delta = delta;
        this.point = point;
        this.type = type;
    }
}
