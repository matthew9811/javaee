package com.shengxi.compent.constant;

/**
 * 正则常量
 *
 * @author yan
 * @version 1.0.0
 * @date 2019-12-23 14:51:33
 */
public class RegularConstant {

    /**
     * img标签正则
     */
    public static final String IMG_REGULAR = "<img.*src\\s*=\\s*(.*?)[^>]*?>";


    /**
     * src内的正则
     */
    public static final String SRC_REGULAR = "src\\s*=\\s*\"?(.*?)(\"|>|\\s+)";
}
