package com.library.library_management_api.controller;

import com.library.library_management_api.dto.*;
import com.library.library_management_api.service.BorrowService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping
    public BorrowResponseDTO borrowBook(
            @Valid @RequestBody BorrowRequestDTO request) {

        return borrowService.borrowBook(request);
    }

    @PutMapping("/return/{borrowId}")
    public String returnBook(
            @PathVariable Long borrowId) {

        return borrowService.returnBook(borrowId);
    }

}