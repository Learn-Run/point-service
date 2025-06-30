package com.unionclass.pointservice.domain.pointcharge.application;

import com.unionclass.pointservice.domain.pointcharge.dto.in.*;
import com.unionclass.pointservice.domain.pointcharge.dto.out.GetPaymentInfoResDto;
import com.unionclass.pointservice.domain.pointcharge.dto.out.GetPointChargeInfoResDto;
import com.unionclass.pointservice.domain.pointcharge.dto.out.GetPointChargeUuidResDto;

import java.util.List;

public interface PointChargeService {

    void createPointChargeInfo(CreatePointChargeInfoReqDto createPointChargeInfoReqDto);

    void toggleActiveStatus(Long pointChargeUuid);

    void updatePointChargeInfo(UpdatePointChargeInfoReqDto updatePointChargeInfoReqDto);

    void deletePointChargeInfo(Long pointChargeUuid);

    GetPaymentInfoResDto getPaymentInfoByPointCharge(Long pointChargeUuid);

    List<GetPointChargeUuidResDto> getActivePointChargeUuids();

    GetPointChargeInfoResDto getPointChargeInfo(Long pointChargeUuid);
}
