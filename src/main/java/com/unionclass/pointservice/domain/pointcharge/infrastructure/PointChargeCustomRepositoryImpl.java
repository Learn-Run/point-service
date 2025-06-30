package com.unionclass.pointservice.domain.pointcharge.infrastructure;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.unionclass.pointservice.domain.pointcharge.dto.out.GetPointChargeInfoResDto;
import com.unionclass.pointservice.domain.pointcharge.dto.out.GetPointChargeUuidResDto;
import com.unionclass.pointservice.domain.pointcharge.entity.QPointCharge;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PointChargeCustomRepositoryImpl implements PointChargeCustomRepository{

    private final JPAQueryFactory queryFactory;

    QPointCharge pointCharge = QPointCharge.pointCharge;

    @Override
    public List<GetPointChargeUuidResDto> getActivePointChargeUuidsSorted() {

        return queryFactory
                .select(Projections.constructor(GetPointChargeUuidResDto.class, pointCharge.uuid))
                .from(pointCharge)
                .where(pointCharge.active.isTrue(), pointCharge.deleted.isFalse())
                .orderBy(pointCharge.point.asc())
                .fetch();
    }

    @Override
    public List<GetPointChargeInfoResDto> getActivePointChargeInfoListSorted() {

        return queryFactory
                .select(Projections.constructor(GetPointChargeInfoResDto.class, pointCharge.uuid))
                .from(pointCharge)
                .where(pointCharge.active.isTrue(), pointCharge.deleted.isFalse())
                .orderBy(pointCharge.point.asc())
                .fetch();
    }
}
