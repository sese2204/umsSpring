package com.example.umcspring.apiPayload.exception;

import com.example.umcspring.apiPayload.code.BaseErrorCode;
import com.example.umcspring.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return code.getReasonHttpStatus();
    }
}
