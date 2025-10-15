package edu.franklin;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CourseResourceTest {
    @Test
    void testCourseGetEndpoint() {
        given()
          .when().get("/courses")
          .then()
             .statusCode(200)
             .body(is("[{\"prefix\":\"TEEN\",\"number\":101,\"semester\":\"FALL25\",\"grade\":\"A\"}," +
                     "{\"prefix\":\"MUTA\",\"number\":102,\"semester\":\"FALL25\",\"grade\":\"A-\"}," +
                     "{\"prefix\":\"NINJ\",\"number\":103,\"semester\":\"FALL25\",\"grade\":\"A\"}," +
                     "{\"prefix\":\"TURT\",\"number\":104,\"semester\":\"FALL25\",\"grade\":\"A\"}]"));
    }

}