package com.talk.auth.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private long userId;
    private String userName;
    private CharSequence password;
    private String email;
    private Object authorityList;
}
