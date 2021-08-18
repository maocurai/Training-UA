package com.example.springApp.controller;

import com.example.springApp.domain.Activity;
import com.example.springApp.domain.AdminConfirmationKey;
import com.example.springApp.domain.Status;
import com.example.springApp.domain.UserActivity;
import com.example.springApp.repos.UserActivityRepo;
import com.example.springApp.service.ActivityService;
import com.example.springApp.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/userRequests")
    public class RequestController {

    @Autowired
    private UserActivityService userActivityService;

    @Autowired
    private ActivityService activityService;

    @GetMapping()
    public String RequestsList(Model model) {
        model.addAttribute("usersActivities", userActivityService
                .findByStatusNotIn(List.of(Status.CONFIRMED, Status.DENIED)));
        return "userRequests";
    }

    @PostMapping("/ad")
    public String confirmActivity(
            @RequestParam("activityId") String activityId,
            @RequestParam("userId") String userId,
            @RequestParam("newActivityStatus") String newActivityStatus
    ) {
        UserActivity userActivity = userActivityService.findById(new AdminConfirmationKey(
                Long.valueOf(userId),
                Long.valueOf(activityId)));
        Status oldStatus = userActivity.getStatus();
        userActivity.setStatus(Status.valueOf(newActivityStatus));
        doActionDueToStatus(userActivity, oldStatus);
        return "redirect:/userRequests";
    }

    public void doActionDueToStatus(UserActivity userActivity, Status status) {
        switch (status) {
            case ADD_REQUEST: userActivityService.save(userActivity); break;
            case DELETE_REQUEST: userActivityService.delete(userActivity);
        }
    }

    @PostMapping("/ur")
    public String userRequest(
            @RequestParam("activityId") String activityId,
            @RequestParam("userId") String userId,
            @RequestParam("newActivityStatus") String newActivityStatus
    ) {
        UserActivity userActivity = userActivityService.findById(new AdminConfirmationKey(
                Long.valueOf(userId),
                Long.valueOf(activityId)));
        userActivity.setStatus(Status.valueOf(newActivityStatus));
        userActivityService.save(userActivity);
        return ("redirect:/adminActivity/" + userId);
    }
}
