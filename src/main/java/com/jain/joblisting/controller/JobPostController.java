package com.jain.joblisting.controller;

import com.jain.joblisting.model.JobPost;
import com.jain.joblisting.repository.JobPostRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class JobPostController {

    @Autowired
    JobPostRepository jobPostRepository;

    // Enable Swagger
    @GetMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll();
    }

    @PostMapping("/jobPosts")
    public JobPost createJobPost(@RequestBody JobPost jobPost) {
        return jobPostRepository.save(jobPost);
    }
}
