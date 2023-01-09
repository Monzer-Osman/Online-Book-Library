package com.BookStore.bookstore.Controller;
import java.util.List;
import com.BookStore.bookstore.Models.Book;
import com.BookStore.bookstore.Services.BookService;
import com.BookStore.bookstore.Records.BookRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("{email}")
@RequestMapping("/MIS-BOOKSTORE")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/home")
    public String homePage(HttpSession sessionData, Model model){
        if(sessionData.getAttribute("email") != null) {
            return findPaginated(1, sessionData,model);
        }
        else {
            return "redirect:/MIS-BOOKSTORE/sign_in";
        }
    }

    @GetMapping("/search_result")
    public String searchResultPage(@ModelAttribute BookRecord book, HttpSession sessionData, Model model)
    {
        if(sessionData.getAttribute("email") != null) {
            return searchResultPaginated(1, book.bookName(), sessionData, model);
        }
        else {
            return "redirect:/MIS-BOOKSTORE/sign_in";
        }
    }

    @GetMapping("/search-result/{bookName}/page/{pageNumber}")
    public String searchResultPaginated(@PathVariable int pageNumber,
                                        @PathVariable String bookName,
                                        HttpSession session,
                                        Model model){
        int pageSize = 12;

        if(session.getAttribute("email") != null) {
            Page<Book> page = bookService.searchResultPaginated(bookName, pageNumber, pageSize);
            List<Book> bookList = page.getContent();
            model.addAttribute("currentPage", pageNumber);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalBooks", page.getTotalElements());
            model.addAttribute("books", bookList);
            model.addAttribute("bookName", bookName);
            return "searchResult";
        }
        else {
            return "redirect:/MIS-BOOKSTORE/sign_in";
        }
    }

    @GetMapping("/page/{pageNumber}")
    public String findPaginated(@PathVariable int pageNumber, HttpSession session, Model model){
        int pageSize = 12;
        if(session.getAttribute("email") != null) {
            Page<Book> page = bookService.findPaginated(pageNumber, pageSize);
            List<Book> bookList = page.getContent();
            model.addAttribute("currentPage", pageNumber);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalBooks", page.getTotalElements());
            model.addAttribute("books", bookList);
            return "index";
        }
        else {
            return "redirect:/MIS-BOOKSTORE/sign_in";
        }
    }

    @GetMapping("/book_details/{bookId}")
    public String bookDetails(@PathVariable String bookId, HttpSession session, Model model){
        if(session.getAttribute("email") != null) {
            Book book = bookService.getBookById(bookId);
            model.addAttribute("book", book);
            return "bookdetails";
        }
        else {
            return "redirect:/MIS-BOOKSTORE/sign_in";
        }
    }
}
