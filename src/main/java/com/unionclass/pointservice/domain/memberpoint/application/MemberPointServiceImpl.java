package com.unionclass.pointservice.domain.memberpoint.application;

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
}
