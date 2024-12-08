package dev.berke.app.user;

import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User toUser(UserRequest userRequest) {
        if (userRequest == null) {
            return null;
        }
        return User.builder()
                .id(userRequest.id())
                .firstname(userRequest.firstname())
                .lastname(userRequest.lastname())
                .email(userRequest.email())
                .vehicle(userRequest.vehicle())
                .build();
    }

    public UserResponse fromUser(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getVehicle()
        );
    }

}
