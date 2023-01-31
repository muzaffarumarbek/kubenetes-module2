package com.epam.userservice.repo;

import com.epam.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long > {
}
