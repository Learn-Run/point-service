package com.unionclass.pointservice.domain.memberpoint.infrastructure;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.unionclass.pointservice.common.response.CursorPage;
import com.unionclass.pointservice.common.util.CursorEncoder;
import com.unionclass.pointservice.domain.memberpoint.dto.in.CursorPageParamReqDto;
import com.unionclass.pointservice.domain.memberpoint.dto.out.GetMemberPointInfoResDto;
import com.unionclass.pointservice.domain.memberpoint.entity.QMemberPoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberPointCustomRepositoryImpl implements MemberPointCustomRepository {

    private final CursorEncoder cursorEncoder;

    private final JPAQueryFactory queryFactory;

    QMemberPoint qMemberPoint = QMemberPoint.memberPoint;

    @Override
    public CursorPage<GetMemberPointInfoResDto> findMemberPointInfoByCursor(CursorPageParamReqDto dto) {

        BooleanExpression predicate = buildPredicate(dto);

        List<GetMemberPointInfoResDto> results = queryFactory
                .select(
                        Projections.constructor(
                                GetMemberPointInfoResDto.class,
                                qMemberPoint.uuid,
                                qMemberPoint.delta,
                                qMemberPoint.point,
                                qMemberPoint.type,
                                qMemberPoint.createdAt
                        ))
                .from(qMemberPoint)
                .where(predicate)
                .orderBy(
                        qMemberPoint.createdAt.desc(),
                        qMemberPoint.uuid.desc()
                )
                .limit(dto.getSize() + 1)
                .fetch();

        boolean hasNext = results.size() > dto.getSize();

        if (hasNext) {
            results = results.subList(0, dto.getSize());
        }

        String nextCursor = hasNext
                ? cursorEncoder.encodeCursor(
                results.get(results.size() - 1).getCreatedAt(), results.get(results.size() - 1).getMemberPointUuid())
                : null;

        return CursorPage.of(
                results, nextCursor, null, hasNext, null, dto.getSize(), null, null
        );
    }

    private BooleanExpression buildPredicate(CursorPageParamReqDto dto) {

        BooleanExpression predicate = qMemberPoint.memberUuid.eq(dto.getMemberUuid());

        if (dto.getCreatedAtCursor() != null && dto.getUuidCursor() != null) {

            LocalDateTime createdAt = LocalDateTime.parse(dto.getCreatedAtCursor());
            Long uuid = dto.getUuidCursor();

            predicate = predicate.and(
                    qMemberPoint.createdAt
                            .lt(createdAt)
                            .or(qMemberPoint.createdAt
                                    .eq(createdAt)
                                    .and(qMemberPoint.uuid.lt(uuid)))
            );
        }

        // startDate 조건 (inclusive)
        if (dto.getStartDate() != null) {
            predicate = predicate.and(qMemberPoint.createdAt.goe(dto.getStartDate().atStartOfDay()));
        }

        // endDate 조건 (inclusive)
        if (dto.getEndDate() != null) {
            predicate = predicate.and(qMemberPoint.createdAt.loe(dto.getEndDate().atTime(23, 59, 59)));
        }

        return predicate;
    }
}
