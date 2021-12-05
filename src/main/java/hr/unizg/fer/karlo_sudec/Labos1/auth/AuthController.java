package hr.unizg.fer.karlo_sudec.Labos1.auth;

import hr.unizg.fer.karlo_sudec.Labos1.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class AuthController {

    private final UserService userService;
    private final OAuth2AuthorizedClientService authclientService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/user")
    public String getOauth2LoginInfo(Model model, @AuthenticationPrincipal OAuth2User user) {

        userService.saveUserIfNotExists(user);
        model.addAttribute("name", user.getAttribute("name"));
        return "layout";
    }
}
