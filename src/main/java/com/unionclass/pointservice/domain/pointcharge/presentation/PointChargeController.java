package com.unionclass.pointservice.domain.pointcharge.presentation;

import com.unionclass.pointservice.common.response.BaseResponseEntity;
import com.unionclass.pointservice.common.response.ResponseMessage;
import com.unionclass.pointservice.domain.pointcharge.application.PointChargeService;
import com.unionclass.pointservice.domain.pointcharge.dto.in.*;
import com.unionclass.pointservice.domain.pointcharge.vo.in.CreatePointChargeInfoReqVo;
import com.unionclass.pointservice.domain.pointcharge.vo.in.UpdatePointChargeInfoReqVo;
import com.unionclass.pointservice.domain.pointcharge.vo.out.GetPaymentInfoResVo;
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
     * 3. 포인트 충전 정보 변경
     * 4. 포인트 충전 정보 삭제
     * 5. 포인트 결제 요청 정보 조회
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
                    포인트 충전 정보의 `active` 상태를 토글 형식으로 변경하는 API 입니다.
                    이 API 는 관리자 또는 내부 시스템에서 호출되어 특정 충전 정보를 사용자에게 노출할지에 대한 여부를 제어합니다.
                    
                    [요청 경로]
                    - Path Variable: (Long) pointChargeUuid
                    
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

    /**
     * 3. 포인트 충전 정보 변경
     *
     * @param pointChargeUuid
     * @param updatePointChargeInfoReqVo
     * @return
     */
    @Operation(
            summary = "포인트 충전 정보 변경",
            description = """
                    포인트 충전 정보를 변경하는 API 입니다.
                    이 API 는 관리자 또는 내부 시스템에서 호출되며 충전 포인트, 보너스 포인트, 결제 금액을 변경할 수 있습니다.
                    
                    [요청 경로]
                    - Path Variable: (Long) pointChargeUuid
                    
                    [요청 바디]
                    - point : (선택입력) 충전할 포인트
                    - bonusPoint : (선택입력) 추가로 지급할 보너스 포인트
                    - paymentAmount : (선택입력) 결제 요청 금액 (단위: 원)
                    
                    [처리 방식]
                    - UUID 로 충전 정보를 조회합니다.
                    - 요청 바디에 값이 있으면, 입력 값으로 정보를 변경합니다.
                    - 요청 바디에 없는 값은 기존 값을 유지합니다.
                    - 활성 여부 (`active`) 는 별도 API 로 제어하며, 본 API 에서는 변경되지 않습니다.
                    
                    [예외 상황]
                    - FAILED_TO_FIND_POINT_CHARGE : 해당 UUID 에 대한 포인트 충전 정보를 찾을 수 없는 경우
                    - FAILED_TO_UPDATE_POINT_CHARGE : 포인트 충전 정보 변경 중 알 수 없는 오류 발생
                    """
    )
    @PutMapping("/{pointChargeUuid}")
    public BaseResponseEntity<Void> updatePointChargeInfo(
            @PathVariable Long pointChargeUuid,
            @RequestBody UpdatePointChargeInfoReqVo updatePointChargeInfoReqVo
    ) {
        pointChargeService.updatePointChargeInfo(UpdatePointChargeInfoReqDto.of(pointChargeUuid, updatePointChargeInfoReqVo));
        return new BaseResponseEntity<>(ResponseMessage.SUCCESS_UPDATE_POINT_CHARGE.getMessage());
    }

    /**
     * 4. 포인트 충전 정보 삭제
     *
     * @param pointChargeUuid
     * @return
     */
    @Operation(
            summary = "포인트 충전 정보 삭제",
            description = """
                    포인트 충전 정보를 삭제 처리하는 API 입니다.
                    soft delete (논리적 삭제) 를 사용합니다.
                    이 API 는 관리자 또는 내부 시스템에서 호출됩니다.
                    
                    [요청 경로]
                    - Path Variable: (Long) pointChargeUuid
                    
                    [처리 방식]
                    - UUID 로 충전 정보를 조회합니다.
                    - 조회된 정보의 삭제 여부 (deleted) 를 true 로 설정하고, 삭제 일시 (deletedAt) 에 삭제 시각을 기록합니다.
                    - 실제 DB 에서는 제거되지 않습니다.
                    
                    [예외 상황]
                    - FAILED_TO_FIND_POINT_CHARGE : 해당 UUID 에 대한 포인트 충전 정보를 찾을 수 없는 경우
                    - FAILED_TO_DELETE_POINT_CHARGE : 포인트 충전 정보 삭제 중 알 수 없는 오류 발생
                    """
    )
    @DeleteMapping("/{pointChargeUuid}")
    public BaseResponseEntity<Void> deletePointChargeInfo(
            @PathVariable Long pointChargeUuid
    ) {
        pointChargeService.deletePointChargeInfo(DeletePointChargeInfoReqDto.from(pointChargeUuid));
        return new BaseResponseEntity<>(ResponseMessage.SUCCESS_DELETE_POINT_CHARGE.getMessage());
    }

    /**
     * 5. 포인트 결제 요청 정보 조회
     *
     * @param pointChargeUuid
     * @return
     */
    @Operation(
            summary = "포인트 결제 요청 정보 조회",
            description = """
                    사용자가 선택한 포인트 충전 정보를 기반으로 결제 요청에 필요한 정보를 조회하는 API 입니다.
                    이 API 는 사용자 결제 과정에서 호출되며,
                    결제 모듈로 전달할 주문 ID, 주문명, 결제 금액을 생성하여 제공합니다.
                    
                    [요청 경로]
                    - Path Variable: (Long) pointChargeUuid
                    
                    [응답 필드]
                    - orderId : PG 결제 요청 시 사용할 주문 고유 ID (UUID 형식)
                    - orderName : 결제에 사용할 주문명 (포인트 ****P (+ 보너스 ****P))
                    - amount : 결제 금액 (단위 : 원)
                    
                    [처리 방식]
                    - UUID 로 포인트 충전 정보를 조회합니다.
                    - 주문 ID(UUID)와 주문명을 생성하고, 결제 금액을 함께 반환합니다.
                    
                    [예외 상황]
                    - FAILED_TO_FIND_POINT_CHARGE : 해당 UUID 에 대한 포인트 충전 정보를 찾을 수 없는 경우
                    - FAILED_TO_GET_PAYMENT_INFO_BY_POINT_CHARGE : 결제 요청 정보 생성 중 알 수 없는 오류 발생
                    """
    )
    @GetMapping("/{pointChargeUuid}/payment/info")
    public BaseResponseEntity<GetPaymentInfoResVo> getPaymentInfoByPointCharge(
            @PathVariable Long pointChargeUuid
    ) {
        return new BaseResponseEntity<>(
                ResponseMessage.SUCCESS_GET_PAYMENT_INFO_BY_POINT_CHARGE.getMessage(),
                pointChargeService.getPaymentInfoByPointCharge(GetPaymentInfoReqDto.from(pointChargeUuid)).toVo());
    }
}