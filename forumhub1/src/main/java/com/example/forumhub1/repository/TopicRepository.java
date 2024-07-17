package com.example.forumhub1.repository;


import com.example.forumhub1.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface TopicRepository extends JpaRepository<Topic, Long> {
    }


