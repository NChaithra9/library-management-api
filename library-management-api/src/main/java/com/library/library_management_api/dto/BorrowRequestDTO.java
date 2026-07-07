package com.library.library_management_api.dto;

import jakarta.validation.constraints.NotNull;

public class BorrowRequestDTO {

    @NotNull
    private Long bookId;

    @NotNull
    private Long memberId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}