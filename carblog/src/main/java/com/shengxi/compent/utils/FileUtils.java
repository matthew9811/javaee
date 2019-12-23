package com.shengxi.compent.utils;


import cn.hutool.core.util.BooleanUtil;
import com.shengxi.compent.constant.UploadConstant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map;

/**
 * 通用文件呢操作
 *
 * @author yan
 * @version 1.0.0
 * @date 2019-12-23 11:14:54
 */
public class FileUtils {


    /**
     * @param fileName fileName
     * @param data data
     * @return url
     * @throws IOException
     */
    public static String saveFile(String fileName, Map data) throws IOException {
        String tmpPath = LocalDate.now(ZoneId.of("Asia/Shanghai")).toString().replace("-", "");
        File dirFile = new File(UploadConstant.UPLOAD_PATH_PREFIX + tmpPath);
        /* 单例模式双重校验锁 */
        if (BooleanUtil.isFalse(dirFile.exists())) {
            synchronized (dirFile) {
                if (BooleanUtil.isFalse(dirFile.exists())) {
                    dirFile.mkdirs();
                }
            }
        }
        File saveFile = new File(dirFile.getAbsolutePath(), fileName);
        if (BooleanUtil.isFalse(saveFile.exists())) {
            synchronized (saveFile) {
                if (BooleanUtil.isFalse(saveFile.exists())) {
                    saveFile.createNewFile();
                }
            }
        }
        FileOutputStream outputStream = new FileOutputStream(saveFile, true);
        outputStream.write(String.valueOf(data.get("content")).getBytes("utf-8"));
        outputStream.close();
        return tmpPath;
    }


    /**
     * 根据路径读取对应的html
     * @param url 相对路径
     * @return concent :StringBuffer
     */
    public static StringBuffer readHtml(String url) {
        StringBuffer content = new StringBuffer();
        String line = "";
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        /*
         * 根据路径读取数据
         */
        File file = new File(UploadConstant.SYSTEM_PATH + url);
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            bufferedReader = new BufferedReader(reader);
            line = bufferedReader.readLine();
            while (line != null) {
                content.append(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return content;
    }
}
