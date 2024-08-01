package com.inditex.technicaltest.common.exceptions;

import com.inditex.technicaltest.infraestructure.controller.dto.MessageDto;

public class InditexException extends Exception {
    private final MessageDto messageDto;
    public InditexException(MessageDto messageDto) {
        super(messageDto.getMessage());
        this.messageDto = messageDto;
    }
}
