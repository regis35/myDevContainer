package bzh.redge.myDevContainer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MyController {

    @GetMapping
    public String hello() {
        return "hello";
    }

}
