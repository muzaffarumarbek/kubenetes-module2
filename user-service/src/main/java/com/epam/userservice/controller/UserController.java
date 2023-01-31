package com.epam.userservice.controller;

import com.epam.userservice.service.UserService;
import com.epam.userservice.service.dto.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getOneUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getOneUser(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> getOneUser(@Valid @RequestBody UserDto userDto) {
        if (userDto.id() != null) throw new RuntimeException("Id should be  null");
        return ResponseEntity.ok(userService.createOrUpdateUser(userDto));

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> getOneUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.createOrUpdateUser(
                new UserDto(id, userDto.username(), userDto.amountOfPosts())
        ));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
