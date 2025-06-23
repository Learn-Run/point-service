package com.unionclass.pointservice.domain.pointcharge.application;

import com.unionclass.pointservice.domain.pointcharge.dto.in.*;
import com.unionclass.pointservice.domain.pointcharge.dto.out.GetPaymentInfoResDto;
import com.unionclass.pointservice.domain.pointcharge.dto.out.GetPointChargeUuidResDto;

import java.util.List;

public interface PointChargeService {

    void createPointChargeInfo(CreatePointChargeInfoReqDto createPointChargeInfoReqDto);

    void toggleActiveStatus(ToggleActiveStatusReqDto toggleActiveStatusReqDto);

    void updatePointChargeInfo(UpdatePointChargeInfoReqDto updatePointChargeInfoReqDto);

    void deletePointChargeInfo(DeletePointChargeInfoReqDto deletePointChargeInfoReqDto);

    GetPaymentInfoResDto getPaymentInfoByPointCharge(GetPaymentInfoReqDto getPaymentInfoReqDto);

    List<GetPointChargeUuidResDto> getActivePointChargeUuids();
}
