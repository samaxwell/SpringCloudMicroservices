package com.sean.services;

import com.sean.models.Blog;
import com.sean.repositories.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    private BlogRepository blogRepository;

    public void saveNewBlogs(List<Blog> blogMessages) {
        blogRepository.saveAll(blogMessages);
    }
}
