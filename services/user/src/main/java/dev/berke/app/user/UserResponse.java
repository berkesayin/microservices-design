package dev.berke.app.user;

public record UserResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Vehicle vehicle
) {
}
