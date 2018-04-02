package com.mycompany.myapp.web.rest.custom.modulePojo;

import java.util.ArrayList;

public class ErrorsPojo {

    private ArrayList<SignUpFieldPojo> errors;

    public ErrorsPojo() {
    }

    public ErrorsPojo(ArrayList<SignUpFieldPojo> errors) {
        this.errors = errors;
    }

    public ArrayList<SignUpFieldPojo> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<SignUpFieldPojo> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorsPojo)) return false;

        ErrorsPojo that = (ErrorsPojo) o;

        return getErrors() != null ? getErrors().equals(that.getErrors()) : that.getErrors() == null;
    }

    @Override
    public int hashCode() {
        return getErrors() != null ? getErrors().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ErrorsPojo{" +
            "errors=" + errors +
            '}';
    }
}
