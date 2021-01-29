package com.kevincode.model;

import java.util.Collection;

/**
 * User: kevin.xie<br/>
 * Date: 13/04/2020<br/>
 * Time: 18:37<br/>
 */
public class User {

    private String userName;
    private String age;

    public User() {
    }

    public User (String userName, String age, Collection<?> of) {
        this.userName = userName;
        this.age = age;
    }

}
