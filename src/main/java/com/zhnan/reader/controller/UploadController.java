package com.zhnan.reader.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhnan.reader.constant.Constants;

@Controller
public class UploadController {
    
    @RequestMapping(value = "/fileList.spring", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getFileList(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        File file=new File(Constants.ROOT_DIR);
        File[] tempList = file.listFiles();
        if(tempList != null) {
        	for (int i = 0; i < tempList.length; i++) {
                if (tempList[i].isDirectory()) {
                 File[] files = tempList[i].listFiles();
                 List<String> fileList = new ArrayList<String>();
                 
                 for (File file2 : files) {
                     fileList.add(file2.getName());
                 }
                 map.put(tempList[i].getName(), fileList);
                }
               }
        }
        
        
        model.addObject("fileMap", map);
        model.setViewName("view2.jsp");
        
        return model;
    }

	
	 @RequestMapping(value="/upload.spring", method=RequestMethod.POST)
	 @ResponseBody 
	 public String handleFileUpload(@RequestParam("uploadMeta") MultipartFile file){
	        if (!file.isEmpty()) {
	            try {
	                String dirStr = Constants.ROOT_DIR + getFileType(file.getOriginalFilename());
                    File dir = new File(dirStr);
                    if (!dir.exists()){
                        dir.mkdirs();
                    }
                    String name = dir + "/" + file.getOriginalFilename();
                    byte[] b1 = name.getBytes("ISO-8859-1");
                    String fileName =  new String(b1,"UTF-8");
                    InputStream is = file.getInputStream();
                    BufferedOutputStream outfile = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
                    byte[] b = new byte[1024];
                    int i = is.read(b);
                   // FileOutputStream fos = new FileOutputStream(new File("e://Winter.jpg"));
                    try {
                        while (i!=-1) {
                            outfile.write(b, 0, i);
                            outfile.flush();
                            i = is.read(b);
                        }
                        outfile.flush();
                    } catch (Exception e) {
                      e.printStackTrace();
                    }

	                return "You successfully uploaded " + file.getName() + " into " + file.getName() + "-uploaded !";
	            } catch (Exception e) {
	                return "You failed to upload " + file.getName() + " => " + e.getMessage();
	            }
	        } else {
	            return "You failed to upload " + file.getName() + " because the file was empty.";
	        }
	  }
	 
	   @RequestMapping(value="/downLoad.spring", method=RequestMethod.GET)
	   @ResponseBody 
       public String downLoad(){
            System.out.print("download.....");
            return "view.html";
         }

	
	  private String getFileType(String fileName) {
	        return fileName.substring(fileName.lastIndexOf(".") + 1,fileName.length());
	    }
}
