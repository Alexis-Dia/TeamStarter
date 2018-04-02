package com.mycompany.myapp.web.rest.custom.modulePojo;

public class TokenPojo {

    public TokenPojo() {
    }

    public TokenPojo(String jwt) {
        this.jwt = jwt;
    }

    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokenPojo)) return false;

        TokenPojo tokenPojo = (TokenPojo) o;

        return getJwt() != null ? getJwt().equals(tokenPojo.getJwt()) : tokenPojo.getJwt() == null;
    }

    @Override
    public int hashCode() {
        return getJwt() != null ? getJwt().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TokenPojo{" +
            "jwt='" + jwt + '\'' +
            '}';
    }
}
