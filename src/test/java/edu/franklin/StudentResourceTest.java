package edu.franklin;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class StudentResourceTest {
    @Test
    void testStudentGetEndpoint() {
        given()
                .when().get("/students")
                .then()
                .statusCode(200)
                .body(is("[{\"id\":1,\"name\":\"Mikey\",\"phone\":\"111-111-111\",\"coursesTaken\":[]}," +
                        "{\"id\":2,\"name\":\"Donnie\",\"phone\":\"222-222-222\",\"coursesTaken\":[]}," +
                        "{\"id\":3,\"name\":\"Leo\",\"phone\":\"333-333-333\",\"coursesTaken\":[]}," +
                        "{\"id\":4,\"name\":\"Raph\",\"phone\":\"444-444-444\",\"coursesTaken\":[]}]"));
    }
}
