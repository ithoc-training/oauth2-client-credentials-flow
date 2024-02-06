package de.ithoc.clientapplication.external;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebClientTest {

    @Autowired
    private WebClient webClient;

    @Value("${client-application.resource-server.endpoint}")
    private String resourceServerEndpoint;


    @Test
    void getItems() {

        ResponseEntity<List<Item>> responseEntity = webClient.get()
                .uri(URI.create(resourceServerEndpoint + "/items"))
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<Item>>() {})
                .block();

        assertNotNull(responseEntity);
        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertEquals(3, Objects.requireNonNull(responseEntity.getBody()).size());
    }

}