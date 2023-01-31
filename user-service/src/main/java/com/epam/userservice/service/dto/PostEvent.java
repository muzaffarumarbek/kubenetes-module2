package com.epam.userservice.service.dto;

import com.epam.userservice.enums.EventType;
import jakarta.validation.constraints.NotNull;

public record PostEvent(@NotNull Long userId, EventType type) {
}
