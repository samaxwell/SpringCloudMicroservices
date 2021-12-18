package com.sean.services;

import com.sean.models.Blog;
import com.sean.repositories.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService{

    BlogRepository blogRepository;

    @Override
    public List<Blog> fetchAllBlogs() {
        return blogRepository.findAll();
    }
}
