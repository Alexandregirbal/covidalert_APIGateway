package polytech.covidalert.controllers;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@CrossOrigin
@RequestMapping("/api/covid")
public class CovidDeclarationController {

    @PostMapping(value = "/declaration", produces = "application/json")
    public Object declareCovid(@RequestBody final String userEmail) throws IOException {
        System.out.println(userEmail + " declares themself covid+.");
        HttpClient httpClient = HttpClientBuilder.create().build();
        Object response = null;
        try {
            HttpPost request = new HttpPost("http://localhost:8092/covid/declaration");
            StringEntity params = new StringEntity(userEmail);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse res = httpClient.execute(request);
            String responseBody = EntityUtils.toString(res.getEntity(), StandardCharsets.UTF_8);
            response = responseBody;
        } catch (Exception ex) {
            System.out.println("Exception while sending covid declaration: " + ex);
        }
        return response;
    }

}
