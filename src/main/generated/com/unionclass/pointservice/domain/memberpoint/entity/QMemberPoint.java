package com.unionclass.pointservice.domain.memberpoint.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberPoint is a Querydsl query type for MemberPoint
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberPoint extends EntityPathBase<MemberPoint> {

    private static final long serialVersionUID = -816563236L;

    public static final QMemberPoint memberPoint = new QMemberPoint("memberPoint");

    public final com.unionclass.pointservice.common.entity.QBaseEntity _super = new com.unionclass.pointservice.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> delta = createNumber("delta", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath memberUuid = createString("memberUuid");

    public final NumberPath<Long> point = createNumber("point", Long.class);

    public final EnumPath<com.unionclass.pointservice.domain.memberpoint.enums.PointType> type = createEnum("type", com.unionclass.pointservice.domain.memberpoint.enums.PointType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> uuid = createNumber("uuid", Long.class);

    public QMemberPoint(String variable) {
        super(MemberPoint.class, forVariable(variable));
    }

    public QMemberPoint(Path<? extends MemberPoint> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberPoint(PathMetadata metadata) {
        super(MemberPoint.class, metadata);
    }

}

