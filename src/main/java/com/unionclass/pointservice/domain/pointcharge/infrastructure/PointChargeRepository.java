package com.unionclass.pointservice.domain.pointcharge.infrastructure;

import com.unionclass.pointservice.domain.pointcharge.entity.PointCharge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PointChargeRepository extends JpaRepository<PointCharge, Long> {

    Optional<PointCharge> findByUuid(Long pointChargeUuid);
}
