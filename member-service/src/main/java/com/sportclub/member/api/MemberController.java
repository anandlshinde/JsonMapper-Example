package com.sportclub.member.api;

import com.sportclub.member.entity.ClubMember;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface MemberController {

    Optional<ClubMember> registerMember(@RequestBody ClubMember clubMember);
    Optional<List<ClubMember>> getMembers();
    Optional<ClubMember> getMemberById(@PathVariable String memberId);
    Optional<ClubMember> updateMemberById(@PathVariable String memberId,@RequestBody ClubMember member);

    Optional<ClubMember> updateMemberByIdPatch(@PathVariable String memberId,@RequestBody ClubMember member);
    String deleteMemberById(@PathVariable String memberId);
}
