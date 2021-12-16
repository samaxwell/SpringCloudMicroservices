package com.sean.listeners;

import com.sean.models.Blog;
import com.sean.repositories.BlogRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class BlogListener {

    private BlogRepository blogRepository;

    @Bean
    public java.util.function.Consumer<Message<Blog>> saveNewBlog() {
        return blogMessage -> {
            log.info("Saving new blog: {}", blogMessage);
            blogRepository.save(blogMessage.getPayload());
        };
    }
}
