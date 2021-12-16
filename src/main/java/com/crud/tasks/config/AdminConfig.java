package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("heroku")
@Component
@Getter
public class AdminConfig {
    @Value("${admin.mail}")
    private String adminMail;
}