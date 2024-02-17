package com.study.springrestfulapi.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {

    private URL() {
        throw new IllegalStateException("URL class");
    }

    public static String decodeParam(String text){
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
}
