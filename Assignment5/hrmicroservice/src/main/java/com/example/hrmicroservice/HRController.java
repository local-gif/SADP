package com.example.hrmicroservice;

import org.springframework.web.bind.annotation.*;

@RestController
public class HRController {

    @PostMapping("/candidates/select")
    public String selectCandidate(@RequestBody Candidate candidate) {

           if (candidate.getId() <= 0) {
        return "Candidate ID must be a positive integer.";
    }
    
        if (candidate.getName() == null ||
            candidate.getName().trim().isEmpty()) {

            return "Candidate name cannot be empty.";
        }

        if (candidate.getEmail() == null ||
            candidate.getEmail().trim().isEmpty()) {

            return "Candidate email cannot be empty.";
        }

        if (candidate.getPosition() == null ||
            candidate.getPosition().trim().isEmpty()) {

            return "Position cannot be empty.";
        }

        return "Dear " + candidate.getName()
                + ", You have been selected for an interview.";
    }
}