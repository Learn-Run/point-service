package com.unionclass.pointservice.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseMessage {

    SUCCESS_CREATE_POINT_CHARGE("포인트 충전 정보 생성에 성공하였습니다."),
    SUCCESS_TOGGLE_ACTIVE_STATUS("포인트 충전 정보 - 활성 여부 변경에 성공하였습니다."),
    SUCCESS_UPDATE_POINT_CHARGE("포인트 충전 정보 변경에 성공하였습니다."),
    SUCCESS_DELETE_POINT_CHARGE("포인트 충전 정보 삭제에 성공하였습니다."),
    SUCCESS_GET_PAYMENT_INFO_BY_POINT_CHARGE("포인트 결제 요청 정보 조회에 성공하였습니다."),
    ;

    private final String message;
}