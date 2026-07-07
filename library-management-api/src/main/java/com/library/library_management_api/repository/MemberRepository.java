package com.library.library_management_api.repository;

import com.library.library_management_api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;    

public interface MemberRepository extends JpaRepository<Member, Long> {
        // JpaRepository provides CRUD operations and more for the Book entity.
}

