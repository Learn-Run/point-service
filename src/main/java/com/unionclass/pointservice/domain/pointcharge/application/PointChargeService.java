package com.unionclass.pointservice.domain.pointcharge.application;

import com.unionclass.pointservice.domain.pointcharge.dto.CreatePointChargeInfoReqDto;
import com.unionclass.pointservice.domain.pointcharge.dto.ToggleActiveStatusReqDto;

public interface PointChargeService {

    void createPointChargeInfo(CreatePointChargeInfoReqDto createPointChargeInfoReqDto);
    void toggleActiveStatus(ToggleActiveStatusReqDto toggleActiveStatusReqDto);
}
