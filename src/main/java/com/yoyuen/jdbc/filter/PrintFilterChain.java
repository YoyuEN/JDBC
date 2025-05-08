package com.yoyuen.jdbc.filter;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrintFilterChain {
    @Autowired
    private List<SecurityFilterChain> securityFilterChains;

    @PostConstruct
    public void init() {
        securityFilterChains.forEach(
                filterChain -> {
                    filterChain.getFilters().forEach(
                            filter -> {
                                System.out.println(filter.getClass().getSimpleName());
                            }
                    );
                }
        );
    }
}