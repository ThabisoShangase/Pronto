package za.co.pronto.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.co.pronto.dto.User;
import za.co.pronto.model.AuthUser;
import za.co.pronto.model.UserInfo;
import za.co.pronto.repositories.AuthUserRepository;
import za.co.pronto.repositories.UserInfoRepository;
import za.co.pronto.request.UserRegistrationRequest;

import java.util.Date;

@Component
public class UserDaoImpl implements UserDao {


    @Autowired
    AuthUserRepository authUserRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    @Transactional
    public User saveNewUser(UserRegistrationRequest userRegistrationRequest) {
            AuthUser authUser = new AuthUser(userRegistrationRequest.getUsername(), userRegistrationRequest.getPassword());
            authUserRepository.save(authUser);
            UserInfo userInfo = new UserInfo(userRegistrationRequest.getUsername(), userRegistrationRequest.getFirstName(), userRegistrationRequest.getLastName(), new Date());
            userInfoRepository.save(userInfo);
            return new User(userRegistrationRequest.getUsername(), userRegistrationRequest.getFirstName(), userRegistrationRequest.getLastName(), new Date());
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }
}
