package dev.berke.app.handle;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}