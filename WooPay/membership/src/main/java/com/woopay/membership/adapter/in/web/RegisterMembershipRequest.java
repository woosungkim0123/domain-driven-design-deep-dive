package com.woopay.membership.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMembershipRequest {
    private String name;
    private String address;
    private String email;
    private boolean isCorp;
}
