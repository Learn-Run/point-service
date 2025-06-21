package com.unionclass.pointservice.domain.pointcharge.application;

import com.unionclass.pointservice.common.exception.BaseException;
import com.unionclass.pointservice.common.exception.ErrorCode;
import com.unionclass.pointservice.common.util.NumericUuidGenerator;
import com.unionclass.pointservice.domain.pointcharge.dto.CreatePointChargeInfoReqDto;
import com.unionclass.pointservice.domain.pointcharge.infrastructure.PointChargeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PointChargeServiceImpl implements PointChargeService {

    private final PointChargeRepository pointChargeRepository;
    private final NumericUuidGenerator numericUuidGenerator;

    @Transactional
    @Override
    public void createPointChargeInfo(CreatePointChargeInfoReqDto createPointChargeInfoReqDto) {
        try {
            pointChargeRepository.save(createPointChargeInfoReqDto.toEntity(numericUuidGenerator.generate()));
            log.info("포인트 충전 정보 생성 성공");
        } catch (Exception e) {
            log.warn("포인트 충전 정보 생성 실패 - message: {}", e.getMessage(), e);
            throw new BaseException(ErrorCode.FAILED_TO_CREATE_POINT_CHARGE);
        }
    }
}
