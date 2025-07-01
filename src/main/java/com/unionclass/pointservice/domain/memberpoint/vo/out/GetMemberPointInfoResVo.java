package com.unionclass.pointservice.domain.memberpoint.vo.out;

import com.unionclass.pointservice.domain.memberpoint.enums.PointType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetMemberPointInfoResVo {

    private Long memberPointUuid;
    private Long delta;
    private Long point;
    private PointType type;
    private LocalDateTime createdAt;

    @Builder
    public GetMemberPointInfoResVo(Long memberPointUuid, Long delta, Long point, PointType type, LocalDateTime createdAt) {
        this.memberPointUuid = memberPointUuid;
        this.delta = delta;
        this.point = point;
        this.type = type;
        this.createdAt = createdAt;
    }
}
