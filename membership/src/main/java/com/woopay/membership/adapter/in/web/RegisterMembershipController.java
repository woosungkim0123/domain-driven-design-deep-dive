package com.woopay.membership.adapter.in.web;

import com.woopay.membership.application.port.in.RegisterMembershipCommand;
import com.woopay.membership.application.port.in.RegisterMembershipUseCase;
import com.woopay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Adapter
@RequiredArgsConstructor
@RestController
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    ResponseEntity<RegisterMemberResponse> registerMembership(@RequestBody RegisterMembershipRequest request) {

        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.name())
                .email(request.email())
                .address(request.address())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        Membership membership = registerMembershipUseCase.registerMembership(command);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(RegisterMemberResponse.from(membership));
    }
}
