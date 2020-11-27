package polytech.covidalert.controllers;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@CrossOrigin
@RequestMapping("/api/alert")
public class AlertController {


    @GetMapping(value = "", produces = "application/json")
    public Object get(@RequestParam final String userEmail, @RequestHeader("Authorization") String authorization) throws IOException {
        System.out.println(userEmail + " get or create user");
        HttpClient httpClient = HttpClientBuilder.create().build();
        Object response = null;
        try {
            HttpGet request = new HttpGet("http://localhost:8092/covidalert/api/send-warning?userEmail=" + userEmail);
            request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", authorization);
            HttpResponse res = httpClient.execute(request);
            String responseBody = EntityUtils.toString(res.getEntity(), StandardCharsets.UTF_8);
            response = responseBody;
        } catch (Exception ex) {
            System.out.println("Exception while getting user: " + ex);
        }
        return response;
    }




}