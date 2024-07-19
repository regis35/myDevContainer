package bzh.redge.myDevContainer.domain;

import bzh.redge.myDevContainer.entity.User;
import bzh.redge.myDevContainer.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDomain {

    private final UserRepository userRepository;

    public UserDomain(UserRepository userRepo) {
        userRepository = userRepo;
    }

    public User create(User user) {
        log.info("Create user");
        User result = userRepository.save(user);
        log.info("User created {}", result.getId());
        return result;

    }

}
