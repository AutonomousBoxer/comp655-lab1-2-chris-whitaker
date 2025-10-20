/**
 * Purpose: Quarkus resource exposing CRUD endpoints for Student.
 * Uses an in-memory List. Status codes:
 * POST → 201 Created
 * GET  → 200 OK
 * PUT  → 200 OK
 * DELETE → 204 No Content
 * Author: Chris Whitaker
 */

package edu.franklin;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestPath;

import java.util.ArrayList;
import java.util.List;

@Path("/api/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {
    private final List<Student> students = new ArrayList<>();
    private int nextId;

    public StudentResource() {nextId = 0;}

    @POST
    @Tag(name = "Create")
    @Operation(summary = "Create a new student", description = "Accepts JSON without id.")
    @APIResponses({
            @APIResponse(responseCode = "201", description = "Created"),
            @APIResponse(responseCode = "400", description = "Bad request")
    })
    public Response createStudent(Student body) {
        if (body == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Request body is required.").build();
        }

        int id = ++nextId;
        body.setId(id);

        if (body.getCourses() == null) {
            body.setCourses(new ArrayList<>());
        }
        students.add(body);

        return Response.status(Response.Status.CREATED).entity(body).build();
    }

    @GET
    @Tag(name = "Read")
    @Operation(summary = "Get all students", description = "Returns a list of all students.")
    @APIResponse(responseCode = "200", description = "OK")
    public Response getAllStudents() {
        return Response.ok(students).build();
    }

    @GET
    @Path("/{id}")
    @Tag(name = "Read")
    @Operation(summary = "Get a student by id", description = "Returns the student if found.")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "OK"),
            @APIResponse(responseCode = "404", description = "Not found")
    })
    public Response getStudent(@RestPath int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return Response.ok(s).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    @Tag(name = "Update")
    @Operation(summary = "Update a student by id", description = "Returns 204 even if already deleted.")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "OK"),
            @APIResponse(responseCode = "400", description = "Bad request"),
            @APIResponse(responseCode = "404", description = "Not found")
    })
    public Response updateStudent(@RestPath int id, Student body) {
        if (body == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Request body is required.").build();
        }

        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(body.getName());
                student.setPhone(body.getPhone());
                student.setCourses(body.getCourses() == null ? new ArrayList<>() : body.getCourses());
                return Response.ok(student).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Tag(name = "Delete")
    @Operation(summary = "Delete all students", description = "Removes all students from the in-memory list.")
    @APIResponse(responseCode = "204", description = "No Content")
    public Response deleteAllStudents() {
        students.clear();
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    @Tag(name = "Delete")
    @Operation(summary = "Delete a student by id", description = "Deletes the student with the given id.")
    @APIResponse(responseCode = "204", description = "No Content")
    public Response deleteStudent(@RestPath int id) {
        students.removeIf(s -> s.getId() == id);
        return Response.noContent().build();
    }
}
