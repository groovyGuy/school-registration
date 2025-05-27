package com.school.registration.domain;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String grade;
    private Birthday birthday;
    private Size shirtSize;
    private Size shortsSize;
}
