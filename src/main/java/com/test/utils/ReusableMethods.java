package com.test.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class ReusableMethods {

    public static String genetateRandomString(int number){
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomString = new String(array, StandardCharsets.UTF_8);
        StringBuffer stringBuffer = new StringBuffer();

        for(int k = 0; k < randomString.length();k++){
            char ch = randomString.charAt(k);
            if(((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) && (number > 0)){
                stringBuffer.append(ch);
                number--;
            }
        }
        System.out.println(stringBuffer.toString());


        return stringBuffer.toString() + "@gmail.com";
    }

    public static void main(String[] args) {
        System.out.println(genetateRandomString(10));
    }
}
