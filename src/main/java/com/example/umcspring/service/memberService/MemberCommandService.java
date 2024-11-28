package com.example.umcspring.service.memberService;

import com.example.umcspring.domain.Member;
import com.example.umcspring.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
