package com.errorit.erroritoverflow.app.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PasswordDto {
    private Long memberId;
    private String password;
}