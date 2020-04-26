package com.crud.kodillalibrary.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class LibraryConfig {
    @Value("${info.library.name}")
    private String companyName;

    @Value("${info.library.email}")
    private String companyMail;

    @Value("${info.library.phone}")
    private String companyPhone;
}
