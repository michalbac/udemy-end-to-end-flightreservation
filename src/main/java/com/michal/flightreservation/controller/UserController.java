package com.michal.flightreservation.controller;

import com.michal.flightreservation.entities.User;
import com.michal.flightreservation.repository.UserRepository;
import com.michal.flightreservation.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    SecurityService securityService;

    @RequestMapping("/showReg")
    public String showRegistrationPage() {
        LOGGER.info("Inside showRegistrationPage()");
        return "login/registerUser";
    }

    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute User user) {
        LOGGER.info("Inside {} register" + user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "login/login";
    }

    @RequestMapping("/showLogin")
    public String showLoginPage() {
        LOGGER.info("Inside showLoginPage()");
        return "login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password, ModelMap modelMap) {
        boolean loginResponse = securityService.login(email, password);
        LOGGER.info("Inside login() with email: " + email);
        if (loginResponse) {
            return "findFlights";
        } else {
            modelMap.addAttribute("msg", "Invalid user name or password. Please try again.");
        }
        return "login/login";
    }
}
