package com.BookStore.bookstore.Services;

import com.BookStore.bookstore.Models.User;
import com.BookStore.bookstore.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserInfo(String email){
        return userRepository.findByEmailAddress(email);
    }

    public void updateUserInfo(User user) {
        User currentUser = userRepository.findByEmailAddress(user.getEmail());
        if(currentUser != null) {
            if (user.getFirstName() != null) {
                currentUser.setFirstName(user.getFirstName());
            }
            if (user.getLastName() != null) {
                currentUser.setLastName(user.getLastName());
            }
            if (user.getPassword() != null) {
                currentUser.setPassword(user.getPassword());
            }
            if (user.getPhoneNumber() != null) {
                currentUser.setPhoneNumber(user.getPhoneNumber());
            }
            if (user.getCountry() != null) {
                currentUser.setCountry(user.getCountry());
            }
            if (user.getState() != null) {
                currentUser.setState(user.getState());
            }
            userRepository.save(currentUser);
            System.out.println("updated successfully ...!");
        }
    }
}
