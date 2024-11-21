package com.example.umcspring.apiPayload.exception.handler;

import com.example.umcspring.apiPayload.code.BaseErrorCode;
import com.example.umcspring.apiPayload.exception.GeneralException;

//네이밍이 맘에 안들어
public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
