package dev.berke.app.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        String id,

        @NotNull(message = "User first name is required")
        String firstname,

        @NotNull(message = "User last name is required")
        String lastname,

        @Email(message = "User email is not a valid email")
        String email,

        Vehicle vehicle
) {
}