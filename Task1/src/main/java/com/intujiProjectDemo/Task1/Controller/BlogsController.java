package com.intujiProjectDemo.Task1.Controller;

import com.intujiProjectDemo.Task1.Blogs.Blogs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("blogs")
public class BlogsController {

    Map<Integer, Blogs> blogs = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<Blogs>> getAllBlogs() {
        return new ResponseEntity<>(new ArrayList<>(blogs.values()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createBlog(@RequestBody Blogs blog) {
        try {
            blogs.put(blog.getId(), blog);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Blogs> getBlogById(@PathVariable Integer id) {
        if (blogs.containsKey(id)) {
            return new ResponseEntity<>(blogs.get(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<?> updateBlogById(@PathVariable Integer id, @RequestBody Blogs updatedBlog) {
        if (blogs.containsKey(id)) {
            blogs.put(id, updatedBlog);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
