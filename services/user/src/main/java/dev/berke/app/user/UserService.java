package dev.berke.app.user;

import lombok.RequiredArgsConstructor;
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
}
