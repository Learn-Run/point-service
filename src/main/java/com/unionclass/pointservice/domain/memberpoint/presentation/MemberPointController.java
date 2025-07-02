package com.unionclass.pointservice.domain.memberpoint.presentation;

import com.unionclass.pointservice.common.response.BaseResponseEntity;
import com.unionclass.pointservice.common.response.CursorPage;
import com.unionclass.pointservice.common.response.ResponseMessage;
import com.unionclass.pointservice.domain.memberpoint.application.MemberPointService;
import com.unionclass.pointservice.domain.memberpoint.dto.in.ChargePointReqDto;
import com.unionclass.pointservice.domain.memberpoint.dto.in.CursorPageParamReqDto;
import com.unionclass.pointservice.domain.memberpoint.dto.out.GetMemberPointInfoResDto;
import com.unionclass.pointservice.domain.memberpoint.vo.in.ChargePointReqVo;
import com.unionclass.pointservice.domain.memberpoint.vo.out.GetMemberPointInfoResVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/member-point")
@Tag(name = "member-point")
public class MemberPointController {

    private final MemberPointService memberPointService;

    @Operation(
            summary = "회원 포인트 충전",
            hidden = true
    )
    @PostMapping("/charge")
    public BaseResponseEntity<Void> chargePoint(
            @RequestHeader("X-Member-UUID") String memberUuid,
            @RequestBody ChargePointReqVo vo
    ) {
        memberPointService.chargePoint(ChargePointReqDto.of(memberUuid, vo));
        return new BaseResponseEntity<>(ResponseMessage.SUCCESS_CHARGE_MEMBER_POINT.getMessage());
    }

    @GetMapping("/info")
    public BaseResponseEntity<CursorPage<GetMemberPointInfoResVo>> getAllMemberPointInfo(
            @RequestHeader("X-Member-UUID") String memberUuid,
            @RequestParam String cursor,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return new BaseResponseEntity<>(
                ResponseMessage.SUCCESS_GET_ALL_MEMBER_POINT_INFO.getMessage(),
                memberPointService
                        .getAllMemberPointInfo(
                                CursorPageParamReqDto
                                        .of(memberUuid, cursor, size, startDate, endDate)
                        )
                        .map(GetMemberPointInfoResDto::toVo)
        );
    }
}
