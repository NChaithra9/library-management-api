package com.library.library_management_api.repository;

import com.library.library_management_api.entity.BorrowRecord;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {

    Optional<BorrowRecord> findByBookIdAndReturnedFalse(Long bookId);

}