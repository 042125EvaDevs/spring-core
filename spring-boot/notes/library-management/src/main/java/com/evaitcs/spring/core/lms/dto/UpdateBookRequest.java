package com.evaitcs.spring.core.lms.dto;

public record UpdateBookRequest(
        String title,
        Long authorId
) {}
