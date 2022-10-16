package com.example.demo.model.Course;

import javax.persistence.*;
import java.util.List;
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    private List<CoursePart> coursePart;

    public Course() {
    }

    public Course(List<CoursePart> coursePart) {
        this.coursePart = coursePart;
    }

    public List<CoursePart> getCoursePart() {
        return coursePart;
    }

    public void setCoursePart(List<CoursePart> coursePart) {
        this.coursePart = coursePart;
    }

    @Override
    public String toString() {
        return "Course{" +
                "coursePart=" + coursePart +
                '}';
    }
}
