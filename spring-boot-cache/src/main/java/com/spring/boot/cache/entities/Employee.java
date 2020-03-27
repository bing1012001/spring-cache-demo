package com.spring.boot.cache.entities;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Employee implements Serializable {

    private String id;

    private String lastName;
    private String email;
    private String gender;
    private Department department;
    private Date birthday;




}
