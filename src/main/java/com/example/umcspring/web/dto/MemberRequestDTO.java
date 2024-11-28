package com.example.umcspring.web.dto;

import java.util.List;
import lombok.Getter;

public class MemberRequestDTO {
    @Getter
    public static class JoinDto{
        String name;
        Integer age;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        List<Long> preferCategory;
    }
}
