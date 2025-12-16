package com.jain.joblisting.controller;

import com.jain.joblisting.model.JobPost;
import com.jain.joblisting.repository.JobPostRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@Tag(name = "Job Posts", description = "APIs for managing Job Posts")
public class JobPostController {

    @Autowired
    JobPostRepository jobPostRepository;

    // Enable Swagger
    @GetMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @Operation(
            summary = "Get all job posts",
            description = "Fetches the complete list of job posts from DB",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrueved job posts.")
            }
    )
    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll();
    }

    @Operation(
            summary = "Create a new Job Post record in the DB",
            description = "Create a new Job Post record in the DB using user input job post",
//            requestBody =  @io.swagger.v3.oas.annotations.parameters.RequestBody(
//                    description = "Job post payload",
//                    required = true
//            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Job post created successfully")
            }
    )
    @PostMapping("/jobPosts")
    public JobPost createJobPost(@RequestBody JobPost jobPost) {
        return jobPostRepository.save(jobPost);
    }
}
