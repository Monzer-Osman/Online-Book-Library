package com.BookStore.bookstore.Services;

import com.BookStore.bookstore.Models.User;
import com.BookStore.bookstore.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    public String login(String email, String password){
        List<User> users = userRepository.findAll();
        for(User user: users) {
            if(user.getEmail().equalsIgnoreCase(email)){
                if(user.getPassword().equals(password)) {
                    return "home";
                }
            }
        }
        return "sign_in";
    }
}
