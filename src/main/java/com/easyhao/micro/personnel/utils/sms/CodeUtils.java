package com.easyhao.micro.personnel.utils.sms;

import java.util.Random;

public class CodeUtils {

    private static String codes = "0123456789";


    private static char randomChar() {
        return codes.charAt(new Random().nextInt(codes.length()));
    }

    public static String getCode() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            String s = randomChar() + "";
            sb.append(s);
        }
        return sb.toString();
    }
}
