package com.example.springApp.controller;

import com.example.springApp.repos.UserActivityRepo;
import com.example.springApp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userRequests")
    public class RequestController {

    @Autowired
    private UserActivityRepo userActivityRepo;

    @GetMapping
    public String RequestsList(Model model) {
        model.addAttribute("users", userActivityRepo.findAll());
        return "userRequests";
    }
}
