package com.library.library_management_api.service;

//import com.library.library_management_api.*;//dto.BorrowRequestDTO;
//import com.library.library_management_api.controller.*;
import com.library.library_management_api.entity.*;
import com.library.library_management_api.exception.*;
import com.library.library_management_api.dto.*;
//import com.library.library_management_api.service.*;
import com.library.library_management_api.repository.*;


import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowService {

    private final BorrowRecordRepository borrowRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public BorrowService(BorrowRecordRepository borrowRepository,
                         BookRepository bookRepository,
                         MemberRepository memberRepository) {

        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    // Borrow a book
    public BorrowResponseDTO borrowBook(BorrowRequestDTO request) {

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() ->
                        new BookNotFoundException("Book not found"));

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() ->
                        new MemberNotFoundException("Member not found"));

        if (!book.isAvailable()) {
            throw new BookUnavailableException("Book is already borrowed");
        }

        book.setAvailable(false);
        bookRepository.save(book);

        BorrowRecord record = new BorrowRecord();
        record.setBook(book);
        record.setMember(member);
        record.setBorrowDate(LocalDate.now());
        record.setReturned(false);

        BorrowRecord savedRecord = borrowRepository.save(record);

        return new BorrowResponseDTO(
                savedRecord.getId(),
                book.getTitle(),
                member.getName(),
                savedRecord.getBorrowDate(),
                savedRecord.isReturned()
        );
    }

    // Return a book
    public String returnBook(Long borrowId) {

        BorrowRecord record = borrowRepository.findById(borrowId)
                .orElseThrow(() ->
                        new RuntimeException("Borrow record not found"));

        if (record.isReturned()) {
            return "Book already returned.";
        }

        record.setReturned(true);
        record.setReturnDate(LocalDate.now());

        Book book = record.getBook();
        book.setAvailable(true);

        bookRepository.save(book);
        borrowRepository.save(record);

        return "Book returned successfully.";
    }

}