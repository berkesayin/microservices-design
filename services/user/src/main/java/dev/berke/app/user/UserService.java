package dev.berke.app.user;

import dev.berke.app.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

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
}
