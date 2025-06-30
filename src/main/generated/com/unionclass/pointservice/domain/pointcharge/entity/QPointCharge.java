package com.unionclass.pointservice.domain.pointcharge.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPointCharge is a Querydsl query type for PointCharge
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPointCharge extends EntityPathBase<PointCharge> {

    private static final long serialVersionUID = 986591580L;

    public static final QPointCharge pointCharge = new QPointCharge("pointCharge");

    public final com.unionclass.pointservice.common.entity.QBaseEntity _super = new com.unionclass.pointservice.common.entity.QBaseEntity(this);

    public final BooleanPath active = createBoolean("active");

    public final NumberPath<Long> bonusPoint = createNumber("bonusPoint", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final BooleanPath deleted = createBoolean("deleted");

    public final DateTimePath<java.time.LocalDateTime> deletedAt = createDateTime("deletedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> paymentAmount = createNumber("paymentAmount", Long.class);

    public final NumberPath<Long> point = createNumber("point", Long.class);

    public final NumberPath<Long> totalPoint = createNumber("totalPoint", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> uuid = createNumber("uuid", Long.class);

    public QPointCharge(String variable) {
        super(PointCharge.class, forVariable(variable));
    }

    public QPointCharge(Path<? extends PointCharge> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPointCharge(PathMetadata metadata) {
        super(PointCharge.class, metadata);
    }

}

