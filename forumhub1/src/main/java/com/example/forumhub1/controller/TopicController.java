package com.example.forumhub1.controller;



import com.example.forumhub1.model.Topic;
import com.example.forumhub1.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/topics")
    public class TopicController {

        @Autowired
        private TopicService topicService;

        @GetMapping
        public List<Topic> getAllTopics() {
            return topicService.getAllTopics();
        }

        @GetMapping("/{id}")
        public Topic getTopicById(@PathVariable Long id) {
            return topicService.getTopicById(id);
        }

        @PostMapping
        public Topic createTopic(@RequestBody Topic topic) {
            return topicService.createTopic(topic);
        }

        @PutMapping("/{id}")
        public Topic updateTopic(@PathVariable Long id, @RequestBody Topic topicDetails) {
            return topicService.updateTopic(id, topicDetails);
        }

        @DeleteMapping("/{id}")
        public void deleteTopic(@PathVariable Long id) {
            topicService.deleteTopic(id);
        }
    }


