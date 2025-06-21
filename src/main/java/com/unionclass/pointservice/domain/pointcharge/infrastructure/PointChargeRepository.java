package com.unionclass.pointservice.domain.pointcharge.infrastructure;

import com.unionclass.pointservice.domain.pointcharge.entity.PointCharge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointChargeRepository extends JpaRepository<PointCharge, Long> {
}
