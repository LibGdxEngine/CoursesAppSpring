package com.example.demo.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Component
public interface StorageService {

    void init();

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Resource load(String filename);


    void deleteAll();

}