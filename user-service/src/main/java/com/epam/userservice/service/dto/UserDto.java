package com.epam.userservice.service.dto;

import com.epam.userservice.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(Long id,
                      @NotNull @NotBlank String username,
                      Long amountOfPosts
) {
    public User toEntity() {
        return User.builder()
                .id(id)
                .username(username)
                .amountOfPosts(amountOfPosts)
                .build();
    }
}
