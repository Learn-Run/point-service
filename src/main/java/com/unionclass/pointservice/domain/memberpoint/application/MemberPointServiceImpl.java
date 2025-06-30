package com.unionclass.pointservice.domain.memberpoint.application;

import com.unionclass.pointservice.common.exception.BaseException;
import com.unionclass.pointservice.common.exception.ErrorCode;
import com.unionclass.pointservice.common.kafka.event.MemberCreatedEvent;
import com.unionclass.pointservice.common.util.NumericUuidGenerator;
import com.unionclass.pointservice.domain.memberpoint.dto.in.ChargePointReqDto;
import com.unionclass.pointservice.domain.memberpoint.entity.MemberPoint;
import com.unionclass.pointservice.domain.memberpoint.infrastructure.MemberPointRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberPointServiceImpl implements MemberPointService {

    private final MemberPointRepository memberPointRepository;

    private final NumericUuidGenerator uuidGenerator;

    @Transactional
    @Override
    public void chargePoint(ChargePointReqDto dto) {

        try {
            memberPointRepository.save(
                    dto.updateEntity(
                            memberPointRepository
                                    .findByMemberUuid(dto.getMemberUuid())
                                    .orElseThrow(() -> new BaseException(ErrorCode.FAILED_TO_FIND_MEMBER_POINT))
                    )
            );

            log.info("회원 포인트 충전 성공 - memberUuid: {}, pointDelta: {}", dto.getMemberUuid(), dto.getPointDelta());

        } catch (Exception e) {

            log.warn("회원 포인트 충전 실패 - memberUuid: {}, pointDelta: {}", dto.getMemberUuid(), dto.getPointDelta());

            throw new BaseException(ErrorCode.FAILED_TO_CHARGE_MEMBER_POINT);
        }
    }

    @Transactional
    @Override
    public void initializeMemberPoint(MemberCreatedEvent event) {

        try {
            memberPointRepository.save(event.toEntity(uuidGenerator.generate()));

            log.info("회원 포인트 초기화 성공 - memberUuid: {}", event.getMemberUuid());

        } catch (Exception e) {

            log.warn("회원 포인트 초기화 실패 - memberUuid: {}, message: {}", event.getMemberUuid(), e.getMessage(), e);

            throw new BaseException(ErrorCode.FAILED_TO_INITIALIZE_MEMBER_POINT);
        }
    }
}
