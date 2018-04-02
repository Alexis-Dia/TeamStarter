package com.mycompany.myapp.web.rest.custom.modulePojo;

public class SignUpFieldPojo {

    private String fieldName;

    private String errorName;

    private String errorDescription;

    private String fieldValue;

    public SignUpFieldPojo() {
        super();
    }


    public SignUpFieldPojo(String fieldName, String errorName, String errorDescription) {
        this.fieldName = fieldName;
        this.errorName = errorName;
        this.errorDescription = errorDescription;

    }

    public SignUpFieldPojo(String fieldName, String errorName, String errorDescription, String fieldValue) {
        this.fieldName = fieldName;
        this.errorName = errorName;
        this.errorDescription = errorDescription;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SignUpFieldPojo)) return false;

        SignUpFieldPojo that = (SignUpFieldPojo) o;

        if (getFieldName() != null ? !getFieldName().equals(that.getFieldName()) : that.getFieldName() != null)
            return false;
        if (getErrorName() != null ? !getErrorName().equals(that.getErrorName()) : that.getErrorName() != null)
            return false;
        if (getErrorDescription() != null ? !getErrorDescription().equals(that.getErrorDescription()) : that.getErrorDescription() != null)
            return false;
        return getFieldValue() != null ? getFieldValue().equals(that.getFieldValue()) : that.getFieldValue() == null;
    }

    @Override
    public int hashCode() {
        int result = getFieldName() != null ? getFieldName().hashCode() : 0;
        result = 31 * result + (getErrorName() != null ? getErrorName().hashCode() : 0);
        result = 31 * result + (getErrorDescription() != null ? getErrorDescription().hashCode() : 0);
        result = 31 * result + (getFieldValue() != null ? getFieldValue().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SignUpFieldPojo{" +
            "fieldName='" + fieldName + '\'' +
            ", errorName='" + errorName + '\'' +
            ", errorDescription='" + errorDescription + '\'' +
            ", fieldValue='" + fieldValue + '\'' +
            '}';
    }
}
