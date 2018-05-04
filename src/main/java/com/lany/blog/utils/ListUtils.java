package com.lany.blog.utils;

import java.util.List;

public class ListUtils {
    private final static String TAG = "ListUtils";

    /**
     * 判断list是否为空
     */
    public static boolean isEmpty(List<?> lists) {
        return lists == null || lists.size() == 0;
    }
}
