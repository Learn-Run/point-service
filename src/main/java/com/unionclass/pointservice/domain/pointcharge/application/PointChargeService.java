package com.unionclass.pointservice.domain.pointcharge.application;

import com.unionclass.pointservice.domain.pointcharge.dto.in.*;
import com.unionclass.pointservice.domain.pointcharge.dto.out.GetPaymentInfoResDto;

public interface PointChargeService {

    void createPointChargeInfo(CreatePointChargeInfoReqDto createPointChargeInfoReqDto);
    void toggleActiveStatus(ToggleActiveStatusReqDto toggleActiveStatusReqDto);
    void updatePointChargeInfo(UpdatePointChargeInfoReqDto updatePointChargeInfoReqDto);
    void deletePointChargeInfo(DeletePointChargeInfoReqDto deletePointChargeInfoReqDto);

    GetPaymentInfoResDto getPaymentInfoByPointCharge(GetPaymentInfoReqDto getPaymentInfoReqDto);
}
