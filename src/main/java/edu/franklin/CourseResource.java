package edu.franklin;

import jakarta.ws.rs.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/courses")
public class CourseResource {
    private final Set<Course> courses = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public CourseResource() {
        courses.add(new Course("TEEN", 101, "FALL25", "A"));
        courses.add(new Course("MUTA", 102, "FALL25", "A-"));
        courses.add(new Course("NINJ", 103, "FALL25", "A"));
        courses.add(new Course("TURT", 104, "FALL25", "A"));
    }

    @GET
    public Set<Course> list() {
        return courses;
    }

    @POST
    public Set<Course> add(Course course) {
        courses.add(course);
        return courses;
    }

    @DELETE
    @Path("/{number}")
    public Set<Course> delete(@PathParam("number") int number) {
        courses.removeIf(course -> course.getNumber() == number);
        return courses;
    }
}
