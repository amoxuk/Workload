package com.hfut.util;

import com.hfut.exception.CustomException;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class ToolKit {
    /**
     * 根据字节数组获取File
     *
     * @param b          字节数组
     * @param outputFile 输出的路径(保存路径)
     * @return
     */
    public static File getFileFromBytes(byte[] b, String outputFile) throws CustomException {
        BufferedOutputStream stream = null;

        File file;
        try {
            file = new File(outputFile);
            FileOutputStream fstream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fstream);
            stream.write(b);
        } catch (Exception e) {
            throw new CustomException("文件保存出错" + e);
        } finally {

            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e1) {
                    throw new CustomException("文件流关闭出错");
                }
            }
        }
        return file;
    }

    public static void deleteFile(String path) {
        File file = new File(path);
        file.delete();
    }

    public static String psw2pwd(String s) {
        String psw = Encryp.strDec(s, "amoxu", "amoxu", "amoxu");
        return Encryp.encryptionStr(psw + "amoxu", "MD5");
    }
    public static String web2Word(String s) {
        return Encryp.strDec(s, "amoxu", "amoxu", "amoxu");
    }
    public static String word2Psw(String s) {
        return Encryp.encryptionStr(s + "amoxu", "MD5");
    }

}
