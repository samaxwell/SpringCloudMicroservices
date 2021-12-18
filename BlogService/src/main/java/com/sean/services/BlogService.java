package com.sean.services;

import com.sean.models.Blog;
import org.springframework.cloud.sleuth.annotation.NewSpan;

import java.util.List;

public interface BlogService {

    @NewSpan
    public List<Blog> fetchAllBlogs();
}
