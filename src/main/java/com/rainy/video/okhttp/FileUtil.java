package com.rainy.video.okhttp;

import java.io.*;

/**
 * @author Jacky
 * @date 2024/12/4
 **/
public class FileUtil {
    public static void writeFile(InputStream inputStream, File destFile) {
        OutputStream outputStream = null;

        try {
            if (!destFile.exists()) {
                destFile.createNewFile();
            }

            outputStream = new FileOutputStream(destFile);
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            destFile.delete();
        } finally {

            try {
                if (inputStream != null)
                    inputStream.close();
                if (outputStream != null)
                    outputStream.close();
            }catch (IOException e) {
                e.printStackTrace();
                destFile.delete();
            }
        }
    }

}
