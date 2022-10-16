package com.example.demo.model.Course;

import javax.persistence.*;
import java.util.List;
@Entity
public class CoursePart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    private List<CourseContent> courseContent;

    public CoursePart() {
    }

    public CoursePart(List<CourseContent> courseContent) {
        this.courseContent = courseContent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<CourseContent> getCourseContent() {
        return courseContent;
    }

    public void setCourseContent(List<CourseContent> courseContent) {
        this.courseContent = courseContent;
    }

    @Override
    public String toString() {
        return "CoursePart{" +
                "courseContent=" + courseContent +
                '}';
    }
}
