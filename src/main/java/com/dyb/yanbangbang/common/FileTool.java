package com.dyb.yanbangbang.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTool {
    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dir 将要删除的文件目录
     * @return
     */
    public static boolean deleteDir(File dir) {
        if (!dir.exists()) return false;
        if (dir.isDirectory()) {
            String[] childrens = dir.list();
            // 递归删除目录中的子目录下
            for (String child : childrens) {
                boolean success = deleteDir(new File(dir, child));
                if (!success) return false;
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }


    /**
     * 上传多个文件
     * @param files
     * @return
     * @throws IOException
     */
    public static List<String> uploadFileToLocal(List<MultipartFile> files, String filePath, String fileName) throws IOException {
        String fileUrl = "";
        List<String> urlList = new ArrayList<>();

        System.out.print("================");
        File path = new File(filePath);
        if (!path.exists()) {
            path.mkdirs();
        }
        //遍历文件数组
        for (MultipartFile file : files) {
            System.out.print("遍历文件================");

            try {
                //String date = sdf.format(new Date());
                //原始名称
                String originalFilename = file.getOriginalFilename();
                //新的文件名称
                String newFileName = fileName+originalFilename.substring(originalFilename.lastIndexOf("."));
                // 生成文件
                File newFile = new File(path, newFileName);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                //将内存中的数据写入磁盘
                file.transferTo(newFile);
                //将文件url信息写入数据库
                fileUrl = path + "/" + newFileName;
                urlList.add(fileUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.print("返回");
        return urlList;
    }
}
