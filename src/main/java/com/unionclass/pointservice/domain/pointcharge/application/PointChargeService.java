package com.unionclass.pointservice.domain.pointcharge.application;

import com.unionclass.pointservice.domain.pointcharge.dto.in.CreatePointChargeInfoReqDto;
import com.unionclass.pointservice.domain.pointcharge.dto.in.DeletePointChargeInfoReqDto;
import com.unionclass.pointservice.domain.pointcharge.dto.in.ToggleActiveStatusReqDto;
import com.unionclass.pointservice.domain.pointcharge.dto.in.UpdatePointChargeInfoReqDto;

public interface PointChargeService {

    void createPointChargeInfo(CreatePointChargeInfoReqDto createPointChargeInfoReqDto);
    void toggleActiveStatus(ToggleActiveStatusReqDto toggleActiveStatusReqDto);
    void updatePointChargeInfo(UpdatePointChargeInfoReqDto updatePointChargeInfoReqDto);
    void deletePointChargeInfo(DeletePointChargeInfoReqDto deletePointChargeInfoReqDto);
}
