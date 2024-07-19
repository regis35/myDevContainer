package bzh.redge.myDevContainer.web.user;

import bzh.redge.myDevContainer.domain.UserDomain;
import bzh.redge.myDevContainer.entity.User;
import bzh.redge.myDevContainer.web.user.dto.UserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDomain domain;

    @Test
    void should_create_new_users() throws Exception{
        UserRequest u = new UserRequest("regis.lecoz@gmail.com", "pwd", "regis", "le coz");

        ObjectMapper mapper = new ObjectMapper();
        String request = mapper.writeValueAsString(u);

        User response = new User();
        response.setId(1234);

        when(domain.create(any())).thenReturn(response);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("id").value(response.getId()));
    }

    @Test
    void should_create_new_users_but_wrong_email() throws Exception{
        UserRequest u = new UserRequest("regis.lecozgmail.com", "pwd", "regis", "le coz");

        ObjectMapper mapper = new ObjectMapper();
        String request = mapper.writeValueAsString(u);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isBadRequest());
    }
}