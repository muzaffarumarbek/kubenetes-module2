package com.epam.userservice.controller;

import com.epam.userservice.service.EventService;
import com.epam.userservice.service.dto.PostEvent;
import com.epam.userservice.service.dto.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<UserDto> handler(@Valid @RequestBody PostEvent postEvent) {
        return ResponseEntity.ok(eventService.eventHandler(postEvent));
    }

}
