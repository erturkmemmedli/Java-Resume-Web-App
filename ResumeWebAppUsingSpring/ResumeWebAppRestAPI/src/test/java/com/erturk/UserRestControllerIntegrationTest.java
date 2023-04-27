package com.erturk;

import com.erturk.dto.ResponseDTO;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.security.oauth2.client.test.OAuth2ContextConfiguration;
import org.springframework.security.oauth2.client.test.OAuth2ContextSetup;
import org.springframework.security.oauth2.client.test.RestTemplateHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestOperations;
import java.util.LinkedHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ResumeWebAppRestApiApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@OAuth2ContextConfiguration(MyDetails.class)
public class UserRestControllerIntegrationTest implements RestTemplateHolder {
    @LocalServerPort
    private int port;

    public int getPort() {
        return port;
    }

    @Rule
    public OAuth2ContextSetup context = OAuth2ContextSetup.standard(this);

    RestOperations restTemplate;

    @Override
    public void setRestTemplate(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public RestOperations getRestTemplate() {
        return null;
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        String url = "http://localhost:" + port + "/users/1";
        System.out.println("URL: " + url);
        ResponseDTO response = this.restTemplate.getForObject(url, ResponseDTO.class);

        System.out.println("Found: " + response.getObj());
        LinkedHashMap<String, Object> hashMap = (LinkedHashMap<String, Object>) response.getObj();

        Assert.assertEquals("ID must be equal to 1", 1L, Long.valueOf(hashMap.get("id") + "").longValue());
        System.out.println(response);
    }
}