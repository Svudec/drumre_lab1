package hr.unizg.fer.karlo_sudec.Labos1.auth;

import com.neovisionaries.i18n.CountryCode;
import hr.unizg.fer.karlo_sudec.Labos1.city.entity.City;
import hr.unizg.fer.karlo_sudec.Labos1.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Comparator;

@Controller
@AllArgsConstructor
public class AuthController {

    private final UserService userService;
    private final OAuth2AuthorizedClientService authclientService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String getOauth2LoginInfo(Model model, @AuthenticationPrincipal OAuth2User user) {

        userService.saveUserIfNotExists(user);
        model.addAttribute("name", user.getAttribute("name"));
        model.addAttribute("city", new City());
        model.addAttribute("countries", Arrays.stream(CountryCode.values())
                .filter(code -> code.getAssignment() == CountryCode.Assignment.OFFICIALLY_ASSIGNED)
                .sorted(Comparator.comparing(CountryCode::getName)).toArray());
        model.addAttribute("contentName", "home");
        return "layout";
    }
}
