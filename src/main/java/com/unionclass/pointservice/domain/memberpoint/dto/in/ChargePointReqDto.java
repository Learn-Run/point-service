package com.unionclass.pointservice.domain.memberpoint.dto.in;

import com.unionclass.pointservice.domain.memberpoint.entity.MemberPoint;
import com.unionclass.pointservice.domain.memberpoint.enums.PointType;
import com.unionclass.pointservice.domain.memberpoint.vo.in.ChargePointReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChargePointReqDto {

    private String memberUuid;
    private Long pointDelta;

    @Builder
    public ChargePointReqDto(String memberUuid, Long pointDelta) {
        this.memberUuid = memberUuid;
        this.pointDelta = pointDelta;
    }

    public static ChargePointReqDto of(String memberUuid, ChargePointReqVo vo) {

        return ChargePointReqDto.builder()
                .memberUuid(memberUuid)
                .pointDelta(vo.getPointDelta())
                .build();
    }

    public MemberPoint updateEntity(MemberPoint memberPoint) {

        return MemberPoint.builder()
                .id(memberPoint.getId())
                .uuid(memberPoint.getUuid())
                .delta(pointDelta)
                .point(memberPoint.getPoint() + pointDelta)
                .type(PointType.EARN)
                .build();
    }
}
