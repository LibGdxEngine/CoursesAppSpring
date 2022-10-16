package com.example.demo.model.Course;

import javax.persistence.*;

@Entity
public class CourseContent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Content content;

    public CourseContent() {
    }

    public CourseContent(Content content) {
        this.content = content;
    }

    @Entity
    public class Content {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String name;
        private String contentType;
        private int length;
        private String url;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CourseContent{" +
                "id=" + id +
                ", content=" + content +
                '}';
    }
}
