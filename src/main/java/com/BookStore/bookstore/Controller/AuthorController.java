package com.BookStore.bookstore.Controller;

import com.BookStore.bookstore.Models.Author;
import com.BookStore.bookstore.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("{email}")
@RequestMapping("/MIS-BOOKSTORE")
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String authorsHome(HttpSession sessionData, Model model){
        if(sessionData.getAttribute("email") != null) {
            return authorsPage(1, sessionData, model);
        }
        else {
            return "redirect:/MIS-BOOKSTORE/sign_in";
        }
    }

    @GetMapping("/authors/page/{pageNumber}")
    public String authorsPage(@PathVariable int pageNumber, HttpSession sessionData, Model model){
        if(sessionData.getAttribute("email") != null) {
            int pageSize = 25;
            Page<Author> authors = authorService.findPaginated(pageNumber, pageSize);
            model.addAttribute("currentPage", pageNumber);
            model.addAttribute("totalPages", authors.getTotalPages());
            model.addAttribute("countAuthors", authors.getTotalElements());
            model.addAttribute("authors", authors.getContent());
            return "authors";
        }
        else {
            return "redirect:/MIS-BOOKSTORE/sign_in";
        }
    }
}
