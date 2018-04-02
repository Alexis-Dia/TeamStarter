package com.mycompany.myapp.web.rest.custom.modulePojo;

public class DataPojo {

    private FullUserPojo user;

    public FullUserPojo getUser() {
        return user;
    }

    public void setUser(FullUserPojo user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataPojo)) return false;

        DataPojo data = (DataPojo) o;

        return getUser() != null ? getUser().equals(data.getUser()) : data.getUser() == null;
    }

    @Override
    public int hashCode() {
        return getUser() != null ? getUser().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DataPojo{" +
            "user=" + user +
            '}';
    }
}
