package com.unionclass.pointservice.domain.memberpoint.presentation;

import com.unionclass.pointservice.common.response.BaseResponseEntity;
import com.unionclass.pointservice.common.response.ResponseMessage;
import com.unionclass.pointservice.domain.memberpoint.application.MemberPointService;
import com.unionclass.pointservice.domain.memberpoint.dto.in.ChargePointReqDto;
import com.unionclass.pointservice.domain.memberpoint.vo.in.ChargePointReqVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/member-point")
@Tag(name = "member-point")
public class MemberPointController {

    private final MemberPointService memberPointService;

    @Operation(
            summary = "회원 포인트 충전"
    )
    @PostMapping("/charge")
    public BaseResponseEntity<Void> chargePoint(
            @RequestHeader("X-Member-UUID") String memberUuid,
            @RequestBody ChargePointReqVo vo
    ) {
        memberPointService.chargePoint(ChargePointReqDto.of(memberUuid, vo));
        return new BaseResponseEntity<>(ResponseMessage.SUCCESS_CHARGE_MEMBER_POINT.getMessage());
    }
}
