package com.epam.userservice.service;

import com.epam.userservice.enums.EventType;
import com.epam.userservice.exceptions.NotFoundException;
import com.epam.userservice.repo.UserRepo;
import com.epam.userservice.service.dto.PostEvent;
import com.epam.userservice.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventService {
    private final UserRepo userRepo;

    public UserDto eventHandler(PostEvent postEvent) {
        var user = userRepo.findById(postEvent.userId())
                .orElseThrow(() -> new NotFoundException("User not found"));
        if (postEvent.type() == EventType.POST_CREATED)
            user.incrementPostCount();

        if (postEvent.type() == EventType.POST_DELETED)
            user.decrementPostCount();

        return userRepo.save(user).toDto();
    }


}
