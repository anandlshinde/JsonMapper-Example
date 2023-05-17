package com.sportclub.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Builder
@Entity(name = "member")
public class ClubMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;
    private String memberName;
    private String mobNumber;
    private String address;
    private String emailId;
    private LocalDate registrationDate;
    private String memberShipType;

}
