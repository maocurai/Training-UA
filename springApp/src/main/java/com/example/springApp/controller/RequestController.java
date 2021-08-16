package com.example.springApp.controller;

import com.example.springApp.domain.Activity;
import com.example.springApp.domain.AdminConfirmationKey;
import com.example.springApp.domain.Status;
import com.example.springApp.domain.UserActivity;
import com.example.springApp.repos.ActivityRepo;
import com.example.springApp.repos.UserActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RequestMapping("/userRequests")
    public class RequestController {

    @Autowired
    private UserActivityRepo userActivityRepo;

    @Autowired
    private ActivityRepo activityRepo;

    @GetMapping("/userRequests")
    public String RequestsList(Model model) {
        model.addAttribute("usersActivities", userActivityRepo
                .findByStatusNotIn(List.of(Status.CONFIRMED, Status.DENIED)));
        return "userRequests";
    }

    @PostMapping("ad")
    public String confirmActivity(
            @RequestParam("activityId") String activityId,
            @RequestParam("userId") String userId,
            @RequestParam("newActivityStatus") String newActivityStatus
    ) {
        UserActivity userActivity = userActivityRepo.findByid(new AdminConfirmationKey(
                Long.valueOf(userId),
                Long.valueOf(activityId)));
        Status oldStatus = userActivity.getStatus();
        userActivity.setStatus(Status.valueOf(newActivityStatus));
        doActionDueToStatus(userActivity, oldStatus);
        return "redirect:/userRequests";
    }

    public void doActionDueToStatus(UserActivity userActivity, Status status) {
        switch (status) {
            case ADD_REQUEST:
                userActivity.setActivity(increaseCounterAndSave(userActivity.getActivity()));
                userActivityRepo.save(userActivity);
            break;
            case DELETE_REQUEST:
                userActivity.setActivity(decreaseCounterAndSave(userActivity.getActivity()));
                userActivityRepo.delete(userActivity);
        }
    }

    public Activity increaseCounterAndSave(Activity activity) {
        activity.increaseCounter();
        activityRepo.save(activity);
        return activity;
    }

    public Activity decreaseCounterAndSave(Activity activity) {
        activity.decreaseCounter();
        activityRepo.save(activity);
        return activity;
    }


    @PostMapping("/ur")
    public String userRequest(
            @RequestParam("activityId") String activityId,
            @RequestParam("userId") String userId,
            @RequestParam("newActivityStatus") String newActivityStatus
    ) {
        UserActivity userActivity = userActivityRepo.findByid(new AdminConfirmationKey(
                Long.valueOf(userId),
                Long.valueOf(activityId)));
        userActivity.setStatus(Status.valueOf(newActivityStatus));
        userActivityRepo.save(userActivity);
        return "greeting";
    }
}
