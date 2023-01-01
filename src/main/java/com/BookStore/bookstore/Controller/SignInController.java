package com.BookStore.bookstore.Controller;

import com.BookStore.bookstore.Records.SigninData;
import com.BookStore.bookstore.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("{email}")
@RequestMapping("/MIS-BOOKSTORE")
public class SignInController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/sign_in")
    public String login() {
        return "signIn";
    }

    @PostMapping("/user_sign_in")
    public String userLogin(@ModelAttribute SigninData data, HttpSession model) {
        model.setAttribute("email", data.email());
        return "redirect:/MIS-BOOKSTORE/" + loginService.login(data.email(), data.password());
    }

    @GetMapping("/sign_out")
    public String userSignOut(HttpSession model) {
        model.invalidate();
        return "redirect:/MIS-BOOKSTORE/sign_in";
    }
}
