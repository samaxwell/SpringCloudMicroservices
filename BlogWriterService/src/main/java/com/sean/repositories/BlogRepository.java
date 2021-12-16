package com.sean.repositories;

import com.sean.models.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogRepository extends CrudRepository<Blog, Long> {

    List<Blog> findAll();
}
