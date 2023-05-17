package com.sportclub.member.repository;

import com.sportclub.member.entity.ClubMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<ClubMember,Long> {
}
