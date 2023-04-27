package com.erturk;

import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import java.util.ArrayList;
import java.util.List;

class MyDetails extends ResourceOwnerPasswordResourceDetails {
    public MyDetails(final Object obj) {
        UserRestControllerIntegrationTest integrationTest = (UserRestControllerIntegrationTest) obj;

        setAccessTokenUri("http://localhost:" + integrationTest.getPort() + "/oauth/token");
        setClientId("client");
        setClientSecret("secret");

        List<String> scopes = new ArrayList<>();
        scopes.add("read");
        scopes.add("write");
        setScope(scopes);

        setUsername("erturk@yahoo.com");
        setPassword("12345");
        setClientAuthenticationScheme(AuthenticationScheme.header);
    }
}