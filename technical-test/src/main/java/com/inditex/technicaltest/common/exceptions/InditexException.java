package com.inditex.technicaltest.common.exceptions;

import com.inditex.technicaltest.infrastructure.controller.dto.MessageDto;
import lombok.Getter;

@Getter
public class InditexException extends Exception {
    private final MessageDto messageDto;
    public InditexException(MessageDto messageDto) {
        super(messageDto.getMessage());
        this.messageDto = messageDto;
    }
}
