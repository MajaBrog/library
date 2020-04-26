package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.config.LibraryConfig;
import com.crud.kodillalibrary.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailCreatorService {
    @Autowired
    private final LibraryConfig libraryConfig;

    @Qualifier("templateEngine")
    private final TemplateEngine templateEngine;

    public String buildEmail(String message, User user) {

        Context context= new Context();
        context.setVariable("message", message);
        context.setVariable("user_name", user.getName());
        context.setVariable("goodbye_message", "Best regards");
        context.setVariable("library_details", libraryConfig);
        return templateEngine.process("/mail-template", context);
    }
}
