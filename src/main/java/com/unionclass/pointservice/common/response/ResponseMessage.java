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
    SUCCESS_GET_POINT_CHARGE_UUID_LIST("포인트 충전 정보 UUID 리스트 전체 조회에 성공하였습니다."),
    SUCCESS_GET_POINT_CHARGE_INFO("포인트 충전 정보 단건 조회에 성공하였습니다."),
    SUCCESS_GET_POINT_CHARGE_INFO_LIST("포인트 충전 정보 전체 조회에 성공하였습니다."),
    SUCCESS_CHARGE_MEMBER_POINT("회원 포인트 적립에 성공하였습니다."),
    ;

    private final String message;
}