package bzh.redge.myDevContainer.web.user.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotNull
        @Email
        @Size(max = 100)
        String email,
        @NotNull
        @Size(max = 100)
        String pwd,
        @NotNull
        @Size(max = 100)
        String firstname,
        @NotNull
        @Size(max = 100)
        String lastname
) {
}
