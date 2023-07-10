package com.rest.webservices.restfulwebservices.jpa;

import com.rest.webservices.restfulwebservices.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}