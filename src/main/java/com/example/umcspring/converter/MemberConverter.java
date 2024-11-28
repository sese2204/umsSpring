package com.example.umcspring.converter;

import com.example.umcspring.domain.Member;
import com.example.umcspring.domain.enums.Gender;
import com.example.umcspring.web.dto.MemberRequestDTO;
import com.example.umcspring.web.dto.MemberResponseDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member requestToMember(MemberRequestDTO.JoinDto request) {
        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
