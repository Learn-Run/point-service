package com.unionclass.pointservice.domain.memberpoint.infrastructure;

import com.unionclass.pointservice.domain.memberpoint.entity.MemberPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberPointRepository extends JpaRepository<MemberPoint, Long> {
}
