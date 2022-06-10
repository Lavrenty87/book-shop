package ru.learnup.bookshop.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            RolesRepository rolesRepository, PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

   /* @Secured({"ROLE_ADMIN"})*/
    @GetMapping
    public void create(User user) {
        User exist = userRepository.findByUsername(user.getUsername());
        if (exist != null) {
            throw new EntityExistsException("login with login "
                    + user.getUsername() + " already exist");
        }
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);

        Set<String> roles = user.getRoles().stream()
                .map(Rolez::getRolez)
                .collect(Collectors.toSet());

        Set<Rolez> existRoles = rolesRepository.findByRolezIn(roles);
        user.setRoles(existRoles);
        existRoles.forEach(rolez -> rolez.setUsers(Set.of(user)));
        userRepository.save(user);
    }

    public void addRole(User user, Rolez rolez) {

    }
}