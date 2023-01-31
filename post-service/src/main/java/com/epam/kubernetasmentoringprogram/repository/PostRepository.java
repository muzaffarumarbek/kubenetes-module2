package com.epam.kubernetasmentoringprogram.repository;

import com.epam.kubernetasmentoringprogram.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
