package com.unionclass.pointservice.common.kafka.event;

import com.unionclass.pointservice.domain.memberpoint.entity.MemberPoint;
import com.unionclass.pointservice.domain.memberpoint.enums.PointType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PaymentCreatedEvent {

    private String memberUuid;
    private Long point;

    @Builder
    public PaymentCreatedEvent(String memberUuid, Long point) {
        this.memberUuid = memberUuid;
        this.point = point;
    }

    public MemberPoint toEntity(Long uuid, MemberPoint memberPoint) {

        return MemberPoint.builder()
                .uuid(uuid)
                .memberUuid(memberUuid)
                .delta(point)
                .point(memberPoint.getPoint() + point)
                .type(PointType.EARN)
                .build();
    }
}
