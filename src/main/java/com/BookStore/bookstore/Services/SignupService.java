package com.BookStore.bookstore.Services;

import com.BookStore.bookstore.Exceptions.InvalidEmail;
import com.BookStore.bookstore.Models.User;
import com.BookStore.bookstore.Repositories.UserRepository;
import com.BookStore.bookstore.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    private UserRepository userRepository;

    private Validator validator;

    SignupService(){
        this.validator = new Validator();
    }
    public String signUp(User user) {
        return signUpProcess(user);
    }

    private String signUpProcess(User user){
        try{
            validator.isEmailValid(user.getEmail());
            validator.isPasswordValid(user.getPassword());
            isEmailUsed(user.getEmail());
            userRepository.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "sign_up";
        }
        return "home";
    }

    private void isEmailUsed(String email) throws Exception{
        if(userRepository.findByEmailAddress(email) != null){
            throw new InvalidEmail("Email is Already Used");
        }
    }
}
