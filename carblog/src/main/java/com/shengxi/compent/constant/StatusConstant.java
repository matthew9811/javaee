package com.shengxi.compent.constant;

/**
 * 状态常量
 *
 * @author yan
 * @version 1.0.0
 * @date 2019-11-19 14:08:37
 */
public abstract class StatusConstant {
    /**
     * 用户初始化状态
     */
    public static final String USER_CONFIG_STATUS = "0";
    /**
     * 用户禁用状态
     */
    public static final String USER_DISABLE_STATUS = "1";

    /**
     * 博客初始化状态
     */
    public static final String BLOG_CONFIG_STATUS = "0";
    /**
     * 博客通过状态
     */
    public static final String BLOG_PASS_STATUS = "1";
    /**
     * 博客不通过状态
     */
    public static final String BLOG_REFUSE_STATUS = "2";
    /**
     * 推荐初始化状态
     */
    public static final String RECOMMEND_CONFIG_STATUS = "0";
    /**
     * 文章推荐状态
     */
    public static final String RECOMMEND_STATUS = "1";


}
