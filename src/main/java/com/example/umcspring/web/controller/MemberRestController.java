package com.example.umcspring.web.controller;

import com.example.umcspring.apiPayload.ApiResponse;
import com.example.umcspring.converter.MemberConverter;
import com.example.umcspring.domain.Member;
import com.example.umcspring.service.memberService.MemberCommandService;
import com.example.umcspring.web.dto.MemberRequestDTO;
import com.example.umcspring.web.dto.MemberResponseDTO;
import com.example.umcspring.web.dto.MemberResponseDTO.JoinResultDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid MemberRequestDTO.JoinDto request
    ){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
