package za.co.pronto.service;

import za.co.pronto.dto.User;
import za.co.pronto.request.UserLoginRequest;
import za.co.pronto.request.UserRegistrationRequest;

public interface AuthUserService {

    User registerUser(UserRegistrationRequest registrationRequest);

    User login(UserLoginRequest userLoginRequest);
}
