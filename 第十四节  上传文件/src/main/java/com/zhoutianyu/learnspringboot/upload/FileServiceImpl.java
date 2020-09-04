package com.zhoutianyu.learnspringboot.upload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@Service
@Transactional
public class FileServiceImpl implements FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);
    private static final String UTF_8 = "UTF-8";

    @Value("${define.nginx.path}")
    private String nginxPath;

    @Override
    public void saveFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    @Override
    public void download(HttpServletResponse response, String filename) {
        try {
            // 文件地址，真实环境是存放在文件服务器的
            File file = new File(nginxPath + filename);
            filename = new String((filename).getBytes(), UTF_8);
            // 输入对象
            FileInputStream fis = new FileInputStream(file);
            // 设置相关格式
            response.setContentType("application/force-download");
            response.setCharacterEncoding(UTF_8);
            // 设置下载后的文件名以及header
            response.addHeader("Content-disposition", "attachment;fileName=" + URLEncoder.encode(filename, UTF_8));
            // 创建输出对象
            OutputStream os = response.getOutputStream();
            // 常规操作
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                os.write(buf, 0, len);
            }
            fis.close();
        } catch (Exception e) {
            throw new RuntimeException("下载异常异常", e.fillInStackTrace());
        }
    }
}
