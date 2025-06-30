package com.unionclass.pointservice.domain.pointcharge.infrastructure;

import com.unionclass.pointservice.domain.pointcharge.dto.out.GetPointChargeInfoResDto;
import com.unionclass.pointservice.domain.pointcharge.dto.out.GetPointChargeUuidResDto;

import java.util.List;

public interface PointChargeCustomRepository {

    List<GetPointChargeUuidResDto> getActivePointChargeUuidsSorted();

    List<GetPointChargeInfoResDto> getActivePointChargeInfoListSorted();
}
