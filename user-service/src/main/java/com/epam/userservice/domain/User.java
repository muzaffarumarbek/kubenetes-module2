package com.epam.userservice.domain;

import com.epam.userservice.service.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private Long amountOfPosts = 0L;

    public UserDto toDto() {
        return new UserDto(id, username, amountOfPosts);
    }

    public void incrementPostCount() {
        setAmountOfPosts(++amountOfPosts);
    }

    public void decrementPostCount() {
        setAmountOfPosts(--amountOfPosts);
    }
}
