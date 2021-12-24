package com.sean.listeners;

import com.sean.models.Blog;
import com.sean.services.BlogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BlogListener {

    private BlogService blogService;

    @Bean
    public java.util.function.Consumer<Message<List<Blog>>> saveNewBlog() {
        return blogMessages -> {
            log.info("Saving {} new blog(s): {}", blogMessages.getPayload().size());
            blogService.saveNewBlogs(blogMessages.getPayload());
        };
    }
}
