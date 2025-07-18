package com.unionclass.pointservice.domain.pointcharge.application;

import com.unionclass.pointservice.common.exception.BaseException;
import com.unionclass.pointservice.common.exception.ErrorCode;
import com.unionclass.pointservice.common.util.NumericUuidGenerator;
import com.unionclass.pointservice.common.util.StringUuidGenerator;
import com.unionclass.pointservice.domain.pointcharge.dto.in.*;
import com.unionclass.pointservice.domain.pointcharge.dto.out.GetPaymentInfoResDto;
import com.unionclass.pointservice.domain.pointcharge.dto.out.GetPointChargeInfoResDto;
import com.unionclass.pointservice.domain.pointcharge.dto.out.GetPointChargeUuidResDto;
import com.unionclass.pointservice.domain.pointcharge.entity.PointCharge;
import com.unionclass.pointservice.domain.pointcharge.infrastructure.PointChargeRepository;
import com.unionclass.pointservice.domain.pointcharge.util.OrderNameTemplateProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PointChargeServiceImpl implements PointChargeService {

    private final PointChargeRepository pointChargeRepository;

    private final NumericUuidGenerator numericUuidGenerator;
    private final StringUuidGenerator stringUuidGenerator;
    private final OrderNameTemplateProvider orderNameTemplateProvider;

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

    @Transactional
    @Override
    public void toggleActiveStatus(Long pointChargeUuid) {

        try {

            PointCharge pointCharge = pointChargeRepository.findByUuid(pointChargeUuid)
                    .orElseThrow(() -> new BaseException(ErrorCode.FAILED_TO_FIND_POINT_CHARGE));

            pointCharge.toggleActive();

            pointChargeRepository.save(pointCharge);

            log.info("포인트 충전 정보 - 활성 여부 변경 성공");

        } catch (BaseException e) {

            throw e;

        } catch (Exception e) {

            log.warn("포인트 충전 정보 - 활성 여부 변경 실패 - message: {}", e.getMessage(), e);

            throw new BaseException(ErrorCode.FAILED_TO_TOGGLE_ACTIVE_STATUS);
        }
    }

    @Transactional
    @Override
    public void updatePointChargeInfo(UpdatePointChargeInfoReqDto updatePointChargeInfoReqDto) {

        try {

            PointCharge pointCharge = pointChargeRepository.findByUuid(updatePointChargeInfoReqDto.getPointChargeUuid())
                    .orElseThrow(() -> new BaseException(ErrorCode.FAILED_TO_FIND_POINT_CHARGE));

            pointCharge.updateInfo(updatePointChargeInfoReqDto);

            pointChargeRepository.save(pointCharge);
        } catch (BaseException e) {

            throw e;

        } catch (Exception e) {

            log.warn("포인트 충전 정보 변경 실패 - message: {}", e.getMessage(), e);

            throw new BaseException(ErrorCode.FAILED_TO_UPDATE_POINT_CHARGE);

        }
    }

    @Transactional
    @Override
    public void deletePointChargeInfo(Long pointChargeUuid) {

        try {

            PointCharge pointCharge = pointChargeRepository.findByUuid(pointChargeUuid)
                    .orElseThrow(() -> new BaseException(ErrorCode.FAILED_TO_FIND_POINT_CHARGE));

            pointCharge.deleteInfo();

            pointChargeRepository.save(pointCharge);

            log.info("포인트 충전 정보 삭제 성공");

        } catch (BaseException e) {

            throw e;

        } catch (Exception e) {

            log.warn("포인트 충전 정보 삭제 실패 - message: {}", e.getMessage(), e);

            throw new BaseException(ErrorCode.FAILED_TO_DELETE_POINT_CHARGE);

        }
    }

    @Override
    public GetPaymentInfoResDto getPaymentInfoByPointCharge(Long pointChargeUuid) {

        try {
            PointCharge pointCharge = pointChargeRepository.findByUuid(pointChargeUuid)
                    .orElseThrow(() -> new BaseException(ErrorCode.FAILED_TO_FIND_POINT_CHARGE));

            return GetPaymentInfoResDto.of(
                    stringUuidGenerator.generate(),
                    orderNameTemplateProvider.getOrderNameTemplate(pointCharge),
                    pointCharge.getPaymentAmount());

        } catch (BaseException e) {

            throw e;

        } catch (Exception e) {

            log.warn("포인트 결제 요청 정보 조회 실패 - message: {}", e.getMessage(), e);

            throw new BaseException(ErrorCode.FAILED_TO_GET_PAYMENT_INFO_BY_POINT_CHARGE);

        }
    }

    @Override
    public List<GetPointChargeUuidResDto> getActivePointChargeUuids() {

        return pointChargeRepository.getActivePointChargeUuidsSorted();
    }

    @Override
    public GetPointChargeInfoResDto getPointChargeInfo(Long pointChargeUuid) {

        return GetPointChargeInfoResDto.from(pointChargeRepository.findByUuid(pointChargeUuid)
                .orElseThrow(() -> new BaseException(ErrorCode.FAILED_TO_FIND_POINT_CHARGE)));
    }

    @Override
    public List<GetPointChargeInfoResDto> getActivePointChargeInfoList() {

        return pointChargeRepository.getActivePointChargeInfoListSorted();
    }
}
