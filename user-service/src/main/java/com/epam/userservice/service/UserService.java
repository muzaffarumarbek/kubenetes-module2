package com.epam.userservice.service;

import com.epam.userservice.domain.User;
import com.epam.userservice.exceptions.NotFoundException;
import com.epam.userservice.repo.UserRepo;
import com.epam.userservice.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepo userRepo;

    public UserDto getOneUser(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"))
                .toDto();
    }

    public UserDto createOrUpdateUser(UserDto userDto) {
        var user = userRepo.findById(userDto.id() == null ? 0L : userDto.id())
                .orElse(new User());
        user.setUsername(userDto.username());
        user.setAmountOfPosts(userDto.amountOfPosts());
        return userRepo.save(user).toDto();
    }

    public void delete(Long id) {
        var user = userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        userRepo.delete(user);
    }

}
