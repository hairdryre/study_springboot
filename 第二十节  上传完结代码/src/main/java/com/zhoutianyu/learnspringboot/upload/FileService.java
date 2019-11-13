package com.zhoutianyu.learnspringboot.upload;

public interface FileService {

    void saveFile(byte[] file, String filePath, String fileName) throws Exception;
}
