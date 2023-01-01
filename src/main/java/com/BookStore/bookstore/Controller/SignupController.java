package com.BookStore.bookstore.Controller;

import com.BookStore.bookstore.Models.User;
import com.BookStore.bookstore.Records.SignupData;
import com.BookStore.bookstore.Services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"email"})
@RequestMapping("/MIS-BOOKSTORE")
public class SignupController {
    @Autowired
    private SignupService signupService;

    @GetMapping("/sign_up")
    public String signUp()
    {
        return "signup";
    }

    @PostMapping("/new_user_signup")
    public String addNewUser(@ModelAttribute SignupData data, HttpSession sessionData){
        sessionData.setAttribute("email", data.email());
        return "redirect:/MIS-BOOKSTORE/" + signupService.signUp(new User(data));
    }
}
