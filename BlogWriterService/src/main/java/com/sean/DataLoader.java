package com.sean;

import com.sean.models.Blog;
import com.sean.repositories.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@AllArgsConstructor
@Component
public class DataLoader {

    BlogRepository blogRepository;

    @PostConstruct
    public void loadData() {
        List.of(
                new Blog("Blog 1", "Blog 1's really interesting content"),
                new Blog("Blog 2", "Blog 2's really interesting content"),
                new Blog("Blog 3", "Blog 3's really interesting content")
        ).forEach(blog -> blogRepository.save(blog));
    }
}
