package com.sportclub.member;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MemberShipType {
    M("MONTHLY"),
    Q("QUARTERLY"),
    H("HALF YEARLY"),
    Y("YEARLY");

    private String type;

    MemberShipType(String type) {
        this.type=type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
