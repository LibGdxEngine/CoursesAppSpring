package com.example.demo.controller;

import com.example.demo.exception.CourseCategoryNotFoundException;
import com.example.demo.model.Course.CourseCategory;
import com.example.demo.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CoursesController {
    private final CourseRepository repository;

    CoursesController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/categories")
    List<CourseCategory> all() {
        return repository.findAll();
    }

    @PostMapping("/categories")
    CourseCategory newCategory(@RequestBody CourseCategory courseCategory) {
        return repository.save(courseCategory);
    }

    @GetMapping("/categories/{id}")
    CourseCategory one(@PathVariable Long id) throws CourseCategoryNotFoundException {

        return repository.findById(id)
                .orElseThrow(() -> new CourseCategoryNotFoundException(id));
    }

    @PutMapping("/categories/{id}")
    CourseCategory replaceCategory(@RequestBody CourseCategory courseCategory, @PathVariable Long id) {

        return repository.findById(id)
                .map(category -> {
                    category.setName(courseCategory.getName());
                    return repository.save(category);
                })
                .orElseGet(() -> {
                    courseCategory.setId(id);
                    return repository.save(courseCategory);
                });
    }

    @DeleteMapping("/categories/{id}")
    void deleteCategory(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
