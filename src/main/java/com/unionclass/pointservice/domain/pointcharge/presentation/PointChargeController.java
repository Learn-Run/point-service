package com.unionclass.pointservice.domain.pointcharge.presentation;

import com.unionclass.pointservice.common.response.BaseResponseEntity;
import com.unionclass.pointservice.common.response.ResponseMessage;
import com.unionclass.pointservice.domain.pointcharge.application.PointChargeService;
import com.unionclass.pointservice.domain.pointcharge.dto.CreatePointChargeInfoReqDto;
import com.unionclass.pointservice.domain.pointcharge.dto.ToggleActiveStatusReqDto;
import com.unionclass.pointservice.domain.pointcharge.vo.CreatePointChargeInfoReqVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/point-charge")
public class PointChargeController {

    private final PointChargeService pointChargeService;

    /**
     * /api/v1/point-charge
     *
     * 1. 포인트 충전 정보 생성
     * 2. 포인트 충전 정보 - 활성 여부 변경
     */

    /**
     * 1. 포인트 충전 정보 생성
     *
     * @param createPointChargeInfoReqVo
     * @return
     */
    @Operation(
            summary = "포인트 충전 정보 생성",
            description = """
                    사용자가 충전할 포인트 정보를 미리 생성하는 API 입니다.
                    생성된 정보는 결제 전 사용자 화면에 노출됩니다.
                    이 API 는 관리자 또는 내부 시스템에서 호출됩니다.
                   
                    [요청 바디]
                    - point : (필수입력) 충전할 포인트
                    - bonusPoint : (선택입력) 추가로 지급할 보너스 포인트
                    - paymentAmount : (필수입력) 결제 요청 금액 (단위: 원)
                    - active : (필수입력) 이 충전 정보가 활성화되어 사용자에게 노출될지 여부
                      * true : 사용자에게 노출
                      * false : 사용자에게 미노출
                    
                    [처리 방식]
                    - 입력값으로 포인트 충전 정보 저장
                    
                    [예외 상황]
                    - FAILED_TO_CREATE_POINT_CHARGE : 포인트 충전 정보 생성 중 알 수 없는 오류 발생
                    """
    )
    @PostMapping("/info")
    public BaseResponseEntity<Void> createPointChargeInfo(
            @RequestBody CreatePointChargeInfoReqVo createPointChargeInfoReqVo
    ) {
        pointChargeService.createPointChargeInfo(CreatePointChargeInfoReqDto.from(createPointChargeInfoReqVo));
        return new BaseResponseEntity<>(ResponseMessage.SUCCESS_CREATE_POINT_CHARGE.getMessage());
    }

    /**
     * 2. 포인트 충전 정보 - 활성 여부 변경
     *
     * @param pointChargeUuid
     * @return
     */
    @Operation(
            summary = "포인트 충전 정보 - 활성 여부 변경",
            description = """
                    포인트 충전 정보의 'active' 상태를 토글 형식으로 변경하는 API 입니다.
                    이 API 는 관리자 또는 내부 시스템에서 호출되어 특정 충전 정보를 사용자에게 노출할지에 대한 여부를 제어합니다.
                    
                    [요청 경로]
                    - Path Variable: pointChargeUuid (Long) \s
                      * 활성 상태를 변경할 포인트 충전 정보의 UUID 입니다.
                    
                    [처리 방식]
                    - UUID 로 충전 정보를 조회합니다.
                    - 현재 active 값을 반대로 토글하여 저장합니다.
                      (true → false / false → true)
                    
                    [예외 상황]
                    - FAILED_TO_FIND_POINT_CHARGE : 해당 UUID 에 대한 포인트 충전 정보를 찾을 수 없는 경우
                    - FAILED_TO_TOGGLE_ACTIVE_STATUS : 포인트 충전 정보의 활성 여부 변경 중 알 수 없는 오류 발생
                    """
    )
    @PutMapping("/{pointChargeUuid}/toggle/active")
    public BaseResponseEntity<Void> toggleActiveStatus(
            @PathVariable Long pointChargeUuid
    ) {
        pointChargeService.toggleActiveStatus(ToggleActiveStatusReqDto.from(pointChargeUuid));
        return new BaseResponseEntity<>(ResponseMessage.SUCCESS_TOGGLE_ACTIVE_STATUS.getMessage());
    }
}
