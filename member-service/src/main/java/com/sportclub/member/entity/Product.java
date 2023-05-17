package com.sportclub.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class Product {


    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    @JsonIgnore
    private List<Integer> temlList;
    private List<TempData> temlList1;



}
