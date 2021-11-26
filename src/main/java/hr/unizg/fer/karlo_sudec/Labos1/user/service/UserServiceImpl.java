package hr.unizg.fer.karlo_sudec.Labos1.user.service;

import hr.unizg.fer.karlo_sudec.Labos1.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepo;

    @Override
    @Transactional
    public User saveUserIfNotExists(OAuth2User authUser) {
        String userId = authUser.getAttribute("id");
        User user = new User();
        if(!userRepo.existsById(userId)){
            user.setId(userId);
            user.setEmail(authUser.getAttribute("email"));
            user.setName(authUser.getAttribute("name"));
            userRepo.save(user);
        }
        return user;
    }
}
