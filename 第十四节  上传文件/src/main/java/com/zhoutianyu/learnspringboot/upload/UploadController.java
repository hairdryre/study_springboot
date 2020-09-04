package com.zhoutianyu.learnspringboot.upload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    private static final String NULL_FILE = "";

    @Value("${define.nginx.path}")
    private String nginxPath;

    @Autowired
    private FileService fileService;

    @GetMapping(value = "/goToUpload")
    public String goToUploadHtml() {
        LOGGER.info("Go To upload.html");
        return "upload";
    }


    @PostMapping("/upload")
    @ResponseBody
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("fileName = {}", file.getOriginalFilename());
        }
        try {
            if (file == null || NULL_FILE.equals(file.getOriginalFilename())) {
                return "upload failure";
            }
            fileService.saveFile(file.getBytes(), nginxPath, file.getOriginalFilename());
        } catch (Exception e) {
            return "upload failure";
        }
        return "upload success";
    }

    @RequestMapping("/download")
    public void singleFileUpload(HttpServletResponse response, String filename) {
        fileService.download(response, filename);
    }

    @PostMapping("/uploadFiles")
    @ResponseBody
    public String multiFileUpload(@RequestParam("file") MultipartFile[] files) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("fileName = {}", files[0].getOriginalFilename());
        }
        try {

            for (int i = 0; i < files.length; i++) {
                //check file
                if (NULL_FILE.equals(files[i].getOriginalFilename())) {
                    continue;
                }
                fileService.saveFile(files[i].getBytes(), nginxPath, files[i].getOriginalFilename());
            }
        } catch (Exception e) {
            return "upload failure";
        }
        return "upload success";
    }

}
