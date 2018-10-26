package za.co.pronto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.pronto.dto.User;
import za.co.pronto.repositories.AuthUserRepository;
import za.co.pronto.repositories.UserInfoRepository;
import za.co.pronto.request.UserLoginRequest;
import za.co.pronto.request.UserRegistrationRequest;

@Component
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    AuthUserRepository authUserRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public User registerUser(UserRegistrationRequest registrationRequest) {
        //Do some validations

//        authUserRepository.save(authUser);
        return null;
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        return null;
    }
}
