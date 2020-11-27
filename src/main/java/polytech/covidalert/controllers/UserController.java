package polytech.covidalert.controllers;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    @PostMapping(value = "", produces = "application/json")
    public Object getUser(@RequestBody final String body) throws IOException {
        System.out.println(body + " get or create user");
        HttpClient httpClient = HttpClientBuilder.create().build();
        Object response = null;
        try {
            HttpPost request = new HttpPost("http://localhost:5000/covidalert/api/users");
            StringEntity params = new StringEntity(body);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse res = httpClient.execute(request);
            String responseBody = EntityUtils.toString(res.getEntity(), StandardCharsets.UTF_8);
            response = responseBody;
        } catch (Exception ex) {
            System.out.println("Exception while getting user: " + ex);
        }
        return response;
    }

    @RequestMapping(value="{email}",method = RequestMethod.PUT)
    public Object putUser(@RequestBody final String body, @RequestParam final String userEmail) throws IOException {
        System.out.println(body + " update user");
        HttpClient httpClient = HttpClientBuilder.create().build();
        Object response = null;
        try {
            HttpPut request = new HttpPut("http://localhost:5000/covidalert/api/users?email=" + userEmail);
            StringEntity params = new StringEntity(body);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse res = httpClient.execute(request);
            String responseBody = EntityUtils.toString(res.getEntity(), StandardCharsets.UTF_8);
            response = responseBody;
        } catch (Exception ex) {
            System.out.println("Exception while putting user: " + ex);
        }
        return response;
    }

}
