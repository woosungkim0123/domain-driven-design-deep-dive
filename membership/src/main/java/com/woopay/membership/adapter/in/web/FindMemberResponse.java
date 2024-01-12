package com.woopay.membership.adapter.in.web;

import com.woopay.membership.domain.Membership;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindMemberResponse {

    private String membershipId;
    private String name;
    private String email;
    private String address;
    private boolean isCorp;

    public static FindMemberResponse from(Membership membership) {
        return FindMemberResponse.builder()
                .membershipId(membership.getMembershipId().membershipId())
                .name(membership.getName().membershipName())
                .email(membership.getEmail().membershipEmail())
                .address(membership.getAddress().membershipAddress())
                .isCorp(membership.getIsCorp().membershipIsCorp())
                .build();
    }
}
