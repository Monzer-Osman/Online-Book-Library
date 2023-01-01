package com.BookStore.bookstore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("{email}")
@RequestMapping("/MIS-BOOKSTORE/")
public class TrendsController {

    @GetMapping("/trends")
    public String authorsPage(HttpSession sessionData){
        if(sessionData.getAttribute("email") != null) {
            return "trends";
        }
        else {
            return "redirect:/MIS-BOOKSTORE/sign_in";
        }
    }
}
