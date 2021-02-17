package bg.softuni.mobilele.service;

import org.springframework.stereotype.Service;


public interface UserService {

    //returns true if user authenticated successfully

    boolean authenticate(String userName, String password);

    void loginUser(String userName);

    void logoutCurrentUser();
}
