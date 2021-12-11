package com.sean.controllers;

import com.sean.models.Blog;
import com.sean.repositories.BlogRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {

    private BlogRepository blogRepository;

    @GetMapping
    public ResponseEntity<List<Blog>> getBlogs() {
        log.info("Fetching all blogs");
        return ResponseEntity.ok(blogRepository.findAll());
    }
}
