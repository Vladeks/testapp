package com.vladeks.testapp.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;

public class SecurityUtils {

    public static void runAs(String username, String password, String... roles) {
        Assert.notNull(username, "Username must not be null");
        Assert.notNull(password, "Password must not be null");
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(username, password, createAuthorityList(roles))
        );
    }
}
