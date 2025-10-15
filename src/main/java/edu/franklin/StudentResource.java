package edu.franklin;

import jakarta.ws.rs.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/students")
public class StudentResource {
    private final Set<Student> students = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public StudentResource() {
        students.add(new Student(1,"Mikey","111-111-111", new ArrayList<>()));
        students.add(new Student(2,"Donnie","222-222-222", new ArrayList<>()));
        students.add(new Student(3,"Leo","333-333-333", new ArrayList<>()));
        students.add(new Student(4,"Raph","444-444-444", new ArrayList<>()));
    }

    @GET
    public Set<Student> list() {
        return students;
    }

    @POST
    public Set<Student> add(Student student) {
        students.add(student);
        return students;
    }

    @DELETE
    @Path("/{id}")
    public Set<Student> delete(@PathParam("id") int id) {
        students.removeIf(student -> student.getId() == id);
        return students;
    }
}
