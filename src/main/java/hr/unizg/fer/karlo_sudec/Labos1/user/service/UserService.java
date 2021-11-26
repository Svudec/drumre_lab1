package hr.unizg.fer.karlo_sudec.Labos1.user.service;

import hr.unizg.fer.karlo_sudec.Labos1.user.entity.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface UserService {
    User saveUserIfNotExists(OAuth2User authUser);
}
