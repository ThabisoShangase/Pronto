package za.co.pronto.dao;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import za.co.pronto.dto.User;
import za.co.pronto.request.UserRegistrationRequest;

public interface UserDao {


    User saveNewUser(UserRegistrationRequest userRegistrationRequest);

    User findUserByUsername(String username);
}
