package dev.berke.app.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody @Valid UserRequest userRequest) {
        userService.updateUser(userRequest);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllCustomers() {
        return ResponseEntity.ok(userService.getAllCustomers());
    }

    @GetMapping("/exists/{user-id}")
    public ResponseEntity<Boolean> checkUserById(
            @PathVariable("user-id") String userId
    ) {
        return ResponseEntity.ok(userService.checkUserById(userId));
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserResponse> getUserById(
            @PathVariable("user-id") String userId
    ) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }


}
