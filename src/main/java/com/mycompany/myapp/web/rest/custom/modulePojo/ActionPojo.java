package com.mycompany.myapp.web.rest.custom.modulePojo;

public class ActionPojo {

    private DataPojo data;

    private String type;

    public DataPojo getData() {
        return data;
    }

    public void setData(DataPojo data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActionPojo)) return false;

        ActionPojo that = (ActionPojo) o;

        if (getData() != null ? !getData().equals(that.getData()) : that.getData() != null)
            return false;
        return getType() != null ? getType().equals(that.getType()) : that.getType() == null;
    }

    @Override
    public int hashCode() {
        int result = getData() != null ? getData().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ActionPojo{" +
            "data=" + data +
            ", type='" + type + '\'' +
            '}';
    }
}
