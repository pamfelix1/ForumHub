package com.example.forumhub1.service;



import com.example.forumhub1.model.Topic;
import com.example.forumhub1.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class TopicService {

        @Autowired
        private TopicRepository topicRepository;

        public List<Topic> getAllTopics() {
            return topicRepository.findAll();
        }

        public Topic getTopicById(Long id) {
            return topicRepository.findById(id).orElse(null);
        }

        public Topic createTopic(Topic topic) {
            return topicRepository.save(topic);
        }

        public Topic updateTopic(Long id, Topic topicDetails) {
            Topic topic = topicRepository.findById(id).orElse(null);
            if (topic != null) {
                topic.setTitle(topicDetails.getTitle());
                topic.setContent(topicDetails.getContent());
                return topicRepository.save(topic);
            }
            return null;
        }

        public void deleteTopic(Long id) {
            topicRepository.deleteById(id);
        }
    }


