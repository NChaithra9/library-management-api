package com.library.library_management_api.service;

import com.library.library_management_api.entity.Member;
import com.library.library_management_api.repository.MemberRepository;
import org.springframework.stereotype.Service;
import com.library.library_management_api.dto.*;

import com.library.library_management_api.exception.BookNotFoundException;

import java.util.List;

@Service
public class MemberService {
    public MemberResponseDTO createMember(MemberRequestDTO dto) {
    Member member = new Member();
    member.setName(dto.getName());
    member.setEmail(dto.getEmail());
    member.setPhone(dto.getPhone());

    Member savedMember = memberRepository.save(member);

    return new MemberResponseDTO(
            savedMember.getId(),
            savedMember.getName(),
            savedMember.getEmail(),
            savedMember.getPhone()
    );
}

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }


    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Member not found with id: " + id));
    }


    public Member createMember(Member member) {
        return memberRepository.save(member);
    }


    public Member updateMember(Long id, Member updatedMember) {

        Member existingMember = memberRepository.findById(id)
                .orElse(null);

        if(existingMember != null) {

            existingMember.setName(updatedMember.getName());
            existingMember.setEmail(updatedMember.getEmail());
            existingMember.setPhone(updatedMember.getPhone());

            return memberRepository.save(existingMember);
        }

        return null;
    }


    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}