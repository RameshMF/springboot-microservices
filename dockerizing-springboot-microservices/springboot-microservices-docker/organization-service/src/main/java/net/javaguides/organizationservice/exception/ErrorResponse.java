package net.javaguides.organizationservice.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        String message,
        String path,
        int status,
        LocalDateTime timestamp
) {
}
