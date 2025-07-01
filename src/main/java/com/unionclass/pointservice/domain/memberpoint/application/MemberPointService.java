package com.unionclass.pointservice.domain.memberpoint.application;

import com.unionclass.pointservice.common.kafka.event.MemberCreatedEvent;
import com.unionclass.pointservice.common.kafka.event.PaymentCreatedEvent;
import com.unionclass.pointservice.common.response.CursorPage;
import com.unionclass.pointservice.domain.memberpoint.dto.in.ChargePointReqDto;
import com.unionclass.pointservice.domain.memberpoint.dto.in.CursorPageParamReqDto;
import com.unionclass.pointservice.domain.memberpoint.dto.out.GetMemberPointInfoResDto;

public interface MemberPointService {

    void chargePoint(ChargePointReqDto dto);

    void chargePoint(PaymentCreatedEvent event);

    void initializeMemberPoint(MemberCreatedEvent event);

    CursorPage<GetMemberPointInfoResDto> getAllMemberPointInfo(CursorPageParamReqDto dto);
}
