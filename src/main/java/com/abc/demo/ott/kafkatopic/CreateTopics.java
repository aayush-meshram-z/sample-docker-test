package com.abc.demo.ott.kafkatopic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class CreateTopics {

    @Bean
    public NewTopic createUserLikesTopic()  {
        return TopicBuilder.name("user_likes").build();
    }

    @Bean
    public NewTopic createUserCommentsTopic()   {
        return TopicBuilder.name("user_comments").build();
    }

    @Bean
    public NewTopic createVideoUploadsTopic()   {
        return TopicBuilder.name("video_uploads").build();
    }

    @Bean
    public NewTopic createGenreUpdate() {
        return TopicBuilder.name("genre_updates").build();
    }
}
