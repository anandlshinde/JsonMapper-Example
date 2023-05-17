package com.sportclub.member.api;

import com.sportclub.member.entity.ClubMember;
import com.sportclub.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberControllerImpl implements MemberController{

    private final MemberService memberService;
   private final Logger LOGGER=LoggerFactory.getLogger(MemberControllerImpl.class);

    @Override
    @PostMapping("/")
    public Optional<ClubMember> registerMember(ClubMember clubMember) {
        LOGGER.info("Club membership registration called");
        return memberService.registerMember(clubMember);
    }

    @Override
    @GetMapping("/")
    public Optional<List<ClubMember>> getMembers() {
        LOGGER.info("get all Club members list");
        return memberService.getMembers();
    }

    @Override
    @GetMapping("/{memberId}")
    public Optional<ClubMember> getMemberById(String memberId) {
        LOGGER.info("fetch member by memberId");
        return memberService.getMemberById(memberId);
    }

    @Override
    @PutMapping("/{memberId}")
    public Optional<ClubMember> updateMemberById(String memberId, ClubMember member) {
        LOGGER.info("update member by memberId");
        return memberService.updateMmeberById(memberId,member);
    }

    @Override
    @PatchMapping("/{memberId}")
    public Optional<ClubMember> updateMemberByIdPatch(String memberId, ClubMember member) {
        LOGGER.info("update member by memberId using patch");
        return memberService.updateMmeberById(memberId,member);
    }


    /*@Override
    @DeleteMapping("/{memberId}")
    public String deleteMemberById(String memberId) {
        LOGGER.info("Delete member by memberId");
        return memberService.deleteMemberById(memberId);
    }*/

    @DeleteMapping("/{memberId}")
    public String deleteMemberById(@PathVariable String memberId) {
        LOGGER.info("Delete member by memberId");
        return memberService.deleteMemberById(memberId);
    }
}
