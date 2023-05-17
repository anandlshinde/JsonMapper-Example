package com.sportclub.member.service;

import com.sportclub.member.entity.ClubMember;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Optional<ClubMember> registerMember(ClubMember clubMember);
    Optional<List<ClubMember>> getMembers();
    Optional<ClubMember> getMemberById(String memberId);
    Optional<ClubMember> updateMmeberById(String memberId,ClubMember member);
    String deleteMemberById(String memberId);
}
