package com.unionclass.pointservice.domain.memberpoint.infrastructure;

import com.unionclass.pointservice.domain.memberpoint.entity.MemberPoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberPointRepository extends JpaRepository<MemberPoint, Long> {

    Optional<MemberPoint> findByMemberUuid(String memberUuid);
}
