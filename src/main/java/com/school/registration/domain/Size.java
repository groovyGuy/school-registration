package com.school.registration.domain;

public enum Size {
    YL("Youth Large"),
    S("Small"),
    M("Medium"),
    L("Large"),
    XL("Extra Large");

    private final String size;

    Size(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return this.size;
    }
}
