package ru.learnup.bookshop.controllers.security;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learnup.bookshop.security.Rolez;
import ru.learnup.bookshop.security.User;
import ru.learnup.bookshop.security.UserService;
import ru.learnup.bookshop.view.RolezView;
import ru.learnup.bookshop.view.UserView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping
    public List<UserView> getActiveUsers() {
        return userService.findAll()
                .stream()
                .map(user -> UserView.builder()
                        .login(user.getUsername())
                        .rolez(user.getRoles().stream()
                                .map(RolezView::new)
                                .collect(Collectors.toSet())
                        )
                        .build()
                )
                .collect(Collectors.toList());
    }


    @PostMapping
    public Boolean createUser(@RequestBody UserView user) {
        User entity = new User();
        entity.setUsername(user.getLogin());
        entity.setPassword(user.getPassword());
        entity.setRoles(
                user.getRolez()
                        .stream()
                        .map(RolezView::getRolez)
                        .map(Rolez::new)
                        .collect(Collectors.toSet())
        );
        userService.create(entity);
        return true;
    }
}
