package com.robsonkades;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named(value = "CreateDevServiceImpl")
public class CreateDevServiceImpl implements CreateUserService {

    @Override
    public String execute() {
        return "[dev]: User";
    }
}
