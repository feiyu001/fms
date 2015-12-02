/**
 * 
 */
package com.zhnan.reader.service.impl;


import java.io.File;
import java.io.FileOutputStream;

import com.zhnan.reader.constant.Constants;
import com.zhnan.reader.service.UploadService;
import com.zhnan.reader.utils.StringUtils;


public class UploadServiceImpl implements UploadService {

    /* (non Javadoc) 
    * <p>Title: uploadFile</p>
    * <p>Description: </p>
    * @param fileName
    * @see com.zhnan.reader.service.UploadService#uploadFile(java.lang.String)
    */
    public void uploadFile(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return;
        }
        String type= getFileType(fileName);
        checkOrInitDirectory(type);
        if (fileName.endsWith(Constants.DOC) || fileName.endsWith(Constants.DOCX)) {
            
        } else if (fileName.endsWith(Constants.PDF)) {
            
        } else if (fileName.endsWith(Constants.EXCEL)) {
            
        } else {
            
        }
        
   
    }
    
    private void checkOrInitDirectory(String type) {
        String dir = Constants.ROOT_DIR + type;
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdir();
        }
    }
    
    private String getFileType(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."),fileName.length());
    }
    
    public static void main(String[] aGRStrings) {
        String fileName = "asad.d.doc";
        System.out.print(fileName.substring(fileName.lastIndexOf(".") +1,fileName.length()));
    }

}
