package com.mycompany.myapp.web.rest.custom.modulePojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class FullUserPojo {

    private Integer id;

    @NotNull
    @Pattern(regexp = "^[1-9a-zA-Z]{3,20}$", message="Login has to has between 3 and 20 symbols")
    private String username;

    @NotNull
    @Pattern(regexp = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$", message="Email has wrog format")
    private String email;

    @NotNull
    @Pattern(regexp = "^[1-9a-zA-Z]{3,30}$", message="Password has to has between 3 and 30 symbols")
    private String password;

    @NotNull
    @Pattern(regexp = "^[1-9a-zA-Z]{3,30}$", message="Password-confirmation has to has between 3 and 30 symbols")
    private String passwordConfirmation;

    @NotNull
    @Pattern(regexp = ".{3,255}$", message="Timezone has to be chosen")
    private String timezone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FullUserPojo)) return false;

        FullUserPojo that = (FullUserPojo) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getUsername() != null ? !getUsername().equals(that.getUsername()) : that.getUsername() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getPassword() != null ? !getPassword().equals(that.getPassword()) : that.getPassword() != null)
            return false;
        if (getPasswordConfirmation() != null ? !getPasswordConfirmation().equals(that.getPasswordConfirmation()) : that.getPasswordConfirmation() != null)
            return false;
        return getTimezone() != null ? getTimezone().equals(that.getTimezone()) : that.getTimezone() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getPasswordConfirmation() != null ? getPasswordConfirmation().hashCode() : 0);
        result = 31 * result + (getTimezone() != null ? getTimezone().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FullUserPojo{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", passwordConfirmation='" + passwordConfirmation + '\'' +
            ", timezone='" + timezone + '\'' +
            '}';
    }
}
