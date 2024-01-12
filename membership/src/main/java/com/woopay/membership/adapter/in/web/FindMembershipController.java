package com.woopay.membership.adapter.in.web;

import com.woopay.membership.application.port.in.FindMembershipCommand;
import com.woopay.membership.application.port.in.FindMembershipUseCase;
import com.woopay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping("/membership/{membershipId}")
    ResponseEntity<FindMemberResponse> findMembershipByMemberId(@PathVariable String membershipId) {

        FindMembershipCommand command = FindMembershipCommand.builder()
                .membershipId(membershipId)
                .build();

        Membership membership = findMembershipUseCase.findMembership(command);

        return ResponseEntity
                .ok()
                .body(FindMemberResponse.from(membership));
    }
}
