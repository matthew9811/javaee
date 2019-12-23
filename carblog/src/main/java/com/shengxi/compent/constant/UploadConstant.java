package com.shengxi.compent.constant;

/**
 * 上传常量
 *
 * @author yan
 * @version 1.0.0
 * @date 2019-12-22 18:46:20
 */
public class UploadConstant {
    /**
     * 保存时使用的路径前缀，系统目录下对应模块的uploads文件夹
     */
    public final static String UPLOAD_PATH_PREFIX = System.getProperty("user.dir") + "/carblog/uploads/";
    /**
     * 模块路径
     */
    public final static String SYSTEM_PATH = System.getProperty("user.dir") + "/carblog";

    /**
     * 项目内相对路径
     */
    public final static String MODULE_PATH = "/carblog/uploads/";

    /**
     * 相对路径前缀
     */
    public final static String SQL_PATH_PREFIX = "/uploads/";
}
