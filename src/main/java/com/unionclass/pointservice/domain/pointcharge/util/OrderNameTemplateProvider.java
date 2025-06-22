package com.unionclass.pointservice.domain.pointcharge.util;

import com.unionclass.pointservice.domain.pointcharge.entity.PointCharge;
import org.springframework.stereotype.Service;

@Service
public class OrderNameTemplateProvider {

    public String getOrderNameTemplate(PointCharge pointCharge) {

        Long point = pointCharge.getPoint();
        Long bonusPoint = pointCharge.getBonusPoint();

        if (bonusPoint != null && bonusPoint > 0) {
            return String.format("포인트 %dP + 보너스 %dP", point, bonusPoint);
        }
        return String.format("포인트 %dP", point);
    }
}
