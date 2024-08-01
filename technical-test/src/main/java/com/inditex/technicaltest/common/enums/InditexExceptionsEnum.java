package com.inditex.technicaltest.common.enums;

import com.inditex.technicaltest.infrastructure.controller.dto.MessageDto;
import lombok.Getter;

@Getter
public enum InditexExceptionsEnum {
    ERROR_400_BAD_REQUEST("INDITEX-ERROR-00400", "Bad request."),
    ERROR_500_SERVER_ERROR("INDITEX-ERROR-00500", "Something has gone wrong."),
    ERROR_700_INPUT_PARAMETERS("INDITEX-ERROR-00700", "Input parameters are invalid."),
    ERROR_701_EMPTY_PRICES("INDITEX-ERROR-00701", "There's no product prices for the specified product, brand or application date.");
    private final MessageDto messageDto;

    InditexExceptionsEnum(String code, String message) {
        this.messageDto = new MessageDto(code, message);
    }
}
