package com.example.demo.model.Course;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class CourseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    @OneToMany
    private List<Course> course;

    public CourseCategory() {
    }

    public CourseCategory(String name) {
        this.name = name;
    }

    public CourseCategory(String name, List<Course> course) {
        this.name = name;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseCategory that = (CourseCategory) o;
        return id == that.id && Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course);
    }

    @Override
    public String toString() {
        return "CourseCategory{" +
                "course=" + course +
                '}';
    }
}
