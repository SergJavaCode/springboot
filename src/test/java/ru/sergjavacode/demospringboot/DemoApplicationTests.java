package ru.sergjavacode.demospringboot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;

    private static final GenericContainer<?> myappdev = new GenericContainer<>("devapp").withExposedPorts(8080);
    private static final GenericContainer<?> myappprod = new GenericContainer<>("prodapp").withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        myappdev.start();
        myappprod.start();

    }

    @Test
    void contextLoads() {
        ResponseEntity<String> forEntityDev = restTemplate.getForEntity("http://localhost:" + myappdev.getMappedPort(8080) + "/profile", String.class);
        System.out.println(forEntityDev.getBody());
        assertArrayEquals("Current profile is dev".getBytes(), forEntityDev.getBody().getBytes());
        ResponseEntity<String> forEntityProd = restTemplate.getForEntity("http://localhost:" + myappprod.getMappedPort(8081) + "/profile", String.class);
        assertArrayEquals("Current profile is production".getBytes(), forEntityProd.getBody().getBytes());
        System.out.println(forEntityProd.getBody());
    }

}