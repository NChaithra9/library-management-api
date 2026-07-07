package com.library.library_management_api.dto;

import java.time.LocalDate;

public class BorrowResponseDTO {

    private Long borrowId;
    private String bookTitle;
    private String memberName;
    private LocalDate borrowDate;
    private boolean returned;

    public BorrowResponseDTO(Long borrowId,
                             String bookTitle,
                             String memberName,
                             LocalDate borrowDate,
                             boolean returned) {

        this.borrowId = borrowId;
        this.bookTitle = bookTitle;
        this.memberName = memberName;
        this.borrowDate = borrowDate;
        this.returned = returned;
    }

    public Long getBorrowId() {
        return borrowId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getMemberName() {
        return memberName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public boolean isReturned() {
        return returned;
    }
}