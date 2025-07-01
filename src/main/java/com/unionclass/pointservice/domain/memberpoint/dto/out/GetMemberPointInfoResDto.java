package com.unionclass.pointservice.domain.memberpoint.dto.out;

import com.unionclass.pointservice.domain.memberpoint.enums.PointType;
import com.unionclass.pointservice.domain.memberpoint.vo.out.GetMemberPointInfoResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetMemberPointInfoResDto {

    private Long memberPointUuid;
    private Long delta;
    private Long point;
    private PointType type;
    private LocalDateTime createdAt;

    @Builder
    public GetMemberPointInfoResDto(Long memberPointUuid, Long delta, Long point, PointType type, LocalDateTime createdAt) {
        this.memberPointUuid = memberPointUuid;
        this.delta = delta;
        this.point = point;
        this.type = type;
        this.createdAt = createdAt;
    }

    public GetMemberPointInfoResVo toVo() {

        return GetMemberPointInfoResVo.builder()
                .memberPointUuid(memberPointUuid)
                .delta(delta)
                .point(point)
                .type(type)
                .createdAt(createdAt)
                .build();
    }
}
