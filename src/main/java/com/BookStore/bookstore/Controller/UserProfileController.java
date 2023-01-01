package com.BookStore.bookstore.Controller;
import com.BookStore.bookstore.Models.User;
import com.BookStore.bookstore.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("{email}")
@RequestMapping("/MIS-BOOKSTORE")
public class UserProfileController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String profile(HttpSession sessionData, Model model){
        if(sessionData.getAttribute("email") != null){
            User user = userService.getUserInfo(sessionData.getAttribute("email").toString());
            model.addAttribute("firstName",user.getFirstName());
            model.addAttribute("lastName", user.getLastName());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("phoneNumber", user.getPhoneNumber());
            model.addAttribute("country", user.getCountry());
            model.addAttribute("state", user.getState());
            return "profile";
        }
        else {
            return "signIn";
        }
    }

    @GetMapping("/update_profile")
    public String updateProfile(HttpSession sessionData, @ModelAttribute User user){
        if(sessionData.getAttribute("email") != null){
            userService.updateUserInfo(user);
            return "redirect:/MIS-BOOKSTORE/profile";
        }
        else {
            return "signIn";
        }
    }
}

