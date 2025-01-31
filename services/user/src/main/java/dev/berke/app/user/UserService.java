package dev.berke.app.user;

import dev.berke.app.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public String createUser(UserRequest userRequest) {
        var user = userRepository.save(userMapper.toUser(userRequest));
        return user.getId();
    }

    public void updateUser(UserRequest userRequest) {
        var user = userRepository.findById(userRequest.id())
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("Cannot update customer: No customer found with the provided ID: %s", userRequest.id())
                ));
        mergeUser(user, userRequest);
        userRepository.save(user);
    }

    private void mergeUser(User user, UserRequest userRequest) {
        if (StringUtils.isNotBlank(userRequest.firstname())) {
            user.setFirstname(userRequest.firstname());
        }
        if (StringUtils.isNotBlank(userRequest.lastname())) {
            user.setLastname(userRequest.lastname());
        }
        if (StringUtils.isNotBlank(userRequest.email())) {
            user.setEmail(userRequest.email());
        }
        if (userRequest.vehicle() != null) {
            user.setVehicle(userRequest.vehicle());
        }
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::fromUser)
                .collect(Collectors.toList());
    }

    public Boolean checkUserById(String userId) {
        return userRepository.findById(userId)
                .isPresent();
    }

    public UserResponse getUserById(String userId) {
        return userRepository.findById(userId)
                .map(userMapper::fromUser)
                .orElseThrow(() -> new UserNotFoundException(String.format("No user found with the provided ID:: %s", userId)));
    }

    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }

}
