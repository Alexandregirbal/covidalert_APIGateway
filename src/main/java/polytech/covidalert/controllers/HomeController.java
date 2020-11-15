package polytech.covidalert.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import polytech.covidalert.models.User;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Collections;

@RestController
@CrossOrigin
public class HomeController {
    @Value("${app.version}")
    private String appVersion;

    @RequestMapping(value = "/covidalert/api", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object versionApp() {
        return Collections.singletonMap("message", this.appVersion);
    }


}
