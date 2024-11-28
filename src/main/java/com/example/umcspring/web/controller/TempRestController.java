package com.example.umcspring.web.controller;

import com.example.umcspring.apiPayload.ApiResponse;
import com.example.umcspring.converter.TempConverter;
import com.example.umcspring.service.tempService.TempQueryService;
import com.example.umcspring.web.dto.TempResponse;
import com.example.umcspring.web.dto.TempResponse.TempExceptionDTO;
import com.example.umcspring.web.dto.TempResponse.TempTestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {
    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempTestDTO> testAPI(){
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempExceptionDTO> exceptionAPI(
            @RequestParam("flag") Integer flag
    ) {
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}
