package com.unionclass.pointservice.domain.memberpoint.infrastructure;

import com.unionclass.pointservice.common.response.CursorPage;
import com.unionclass.pointservice.domain.memberpoint.dto.in.CursorPageParamReqDto;
import com.unionclass.pointservice.domain.memberpoint.dto.out.GetMemberPointInfoResDto;

public interface MemberPointCustomRepository {

    CursorPage<GetMemberPointInfoResDto> findMemberPointInfoByCursor(CursorPageParamReqDto dto);
}
