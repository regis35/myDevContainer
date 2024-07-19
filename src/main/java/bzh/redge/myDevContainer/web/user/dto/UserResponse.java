package bzh.redge.myDevContainer.web.user.dto;

public record UserResponse(
        long id,
        String email,
        String pwd,
        String firstname,
        String lastname) {
}
