package com.aliouswang.olympic.io.javaio;

import com.aliouswang.olympic.util.Log;

import java.util.regex.Pattern;

public class JavaPatternDemo {

    public static void main(String[] args) {
        String str = "I am noob from runoob.com.";
        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, str);
        Log.d("is contain runnob:" + isMatch);
    }

}
