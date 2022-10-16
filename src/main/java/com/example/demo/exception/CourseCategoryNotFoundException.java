package com.example.demo.exception;

import com.example.demo.model.ResponseMessage;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

public class CourseCategoryNotFoundException extends Throwable {

    private Long id;

    public CourseCategoryNotFoundException(Long id) {
        this.id = id;
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ResponseMessage> handleNotFoundException(MaxUploadSizeExceededException exc) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Category not found!"));
    }
}
