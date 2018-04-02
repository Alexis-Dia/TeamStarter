package com.mycompany.myapp.web.rest.custom.security.jwt;

import com.mycompany.myapp.web.rest.custom.modulePojo.TokenPojo;

public interface MyTokenProvider {

    TokenPojo createToken(String id, String userName);

}
