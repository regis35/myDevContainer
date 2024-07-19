package bzh.redge.myDevContainer.web.user;

import bzh.redge.myDevContainer.domain.UserDomain;
import bzh.redge.myDevContainer.entity.User;
import bzh.redge.myDevContainer.web.user.dto.UserRequest;
import bzh.redge.myDevContainer.web.user.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDomain userDomain;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public UserResponse create(@Validated @RequestBody UserRequest request) {
        User user = userMapper.userRequestToUserEntity(request);

        User result = userDomain.create(user);
        return userMapper.userEntityToUserResponse(result);
    }
}
