package com.woopay.membership.adapter.in.web;

import com.woopay.membership.application.port.in.ModifyMembershipCommand;
import com.woopay.membership.application.port.in.ModifyMembershipUseCase;
import com.woopay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PostMapping("/membership/{membershipId}")
    ResponseEntity<FindMemberResponse> findMembershipByMemberId(@RequestBody ModifyMembershipRequest request) {

        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                .membershipId(request.membershipId())
                .name(request.name())
                .email(request.email())
                .address(request.address())
                .isValid(request.isValid())
                .isCorp(request.isCorp())
                .build();

        Membership membership = modifyMembershipUseCase.modifyMembership(command);

        return ResponseEntity
                .ok()
                .body(FindMemberResponse.from(membership));
    }
}
