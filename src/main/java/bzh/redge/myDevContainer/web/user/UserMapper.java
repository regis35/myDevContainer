package bzh.redge.myDevContainer.web.user;

import bzh.redge.myDevContainer.entity.User;
import bzh.redge.myDevContainer.web.user.dto.UserRequest;
import bzh.redge.myDevContainer.web.user.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userRequestToUserEntity(UserRequest user);

    UserResponse userEntityToUserResponse(User user);
}
