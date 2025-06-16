package com.hiberus.hiberus.utils;

import org.springframework.util.StringUtils;

public  class StringUtil {
    private StringUtil() {
    }

    public static Boolean validateText(String text) {
       return StringUtils.hasLength(text);
    }
}
