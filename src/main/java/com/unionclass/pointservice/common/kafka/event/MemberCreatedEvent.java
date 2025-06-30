package com.unionclass.pointservice.common.kafka.event;

import com.unionclass.pointservice.domain.memberpoint.entity.MemberPoint;
import com.unionclass.pointservice.domain.memberpoint.enums.PointType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberCreatedEvent {

    private String memberUuid;
    private String nickname;

    @Builder
    public MemberCreatedEvent(String memberUuid, String nickname) {
        this.memberUuid = memberUuid;
        this.nickname = nickname;
    }

    public MemberPoint toEntity(Long uuid) {

        return MemberPoint.builder()
                .uuid(uuid)
                .memberUuid(memberUuid)
                .delta(0L)
                .point(0L)
                .type(PointType.WELCOME)
                .build();
    }
}
