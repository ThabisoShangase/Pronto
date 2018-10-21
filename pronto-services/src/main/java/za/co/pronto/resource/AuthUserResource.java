package za.co.pronto.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.pronto.dto.User;
import za.co.pronto.request.UserRegistrationRequest;

@RestController
@RequestMapping("/api/user")
public class AuthUserResource {

    @PostMapping("/register")
    public User registerUser(@RequestBody final UserRegistrationRequest registrationRequest) {
        return null;
    }

}
