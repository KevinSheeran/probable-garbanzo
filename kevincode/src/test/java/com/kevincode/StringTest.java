package com.kevincode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: kevin.xie<br/>
 * Date: 29/09/2020<br/>
 * Time: 11:03<br/>
 */
public class StringTest {

    private static final Pattern AUTH_HEADER_PATTERN = Pattern.compile("Bear (\\S+)");

    public static void main(String[] args) {
//        subString();
        System.out.println(PatternUsage());


    }

    private static Boolean PatternUsage() {
        Matcher matcher = AUTH_HEADER_PATTERN.matcher("Bear eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.XbPfbIHMI6arZ3Y922BhjWgQzWXcXNrz0ogtVhfEd2o");
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    private static void subString() {
        String amstrong = "Amstrong";
        String substring = amstrong.substring("A".length());
        System.out.println(substring);
    }
}
