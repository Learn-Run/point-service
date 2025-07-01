package com.unionclass.pointservice.common.util;

import java.time.LocalDateTime;

public interface CursorEncoder {

    String encodeCursor(LocalDateTime createdAt, Long uuid);
}
