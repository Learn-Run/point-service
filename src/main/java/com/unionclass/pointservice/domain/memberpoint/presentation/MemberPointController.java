package com.unionclass.pointservice.domain.memberpoint.presentation;

import com.unionclass.pointservice.domain.memberpoint.application.MemberPointService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/member-point")
@Tag(name = "member-point")
public class MemberPointController {

    private final MemberPointService memberPointService;


}
