package com.robsonkades;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named(value = "CreateManagerServiceImpl")
public class CreateManagerServiceImpl implements CreateUserService {

    @Override
    public String execute() {
        return "[manager]: User";
    }
}
