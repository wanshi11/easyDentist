package com.dentist.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.common.io.ByteStreams;

@Controller
@RequestMapping("/kindeditor")
public class KindEditorController {
	

	      @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	      @ResponseBody
	      public Map<String, Object> fileUpload(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException,
	              FileUploadException {
	          ServletContext application = request.getSession().getServletContext();
	          String savePath = application.getRealPath("/") + "images/";
	 
	          // 文件保存目录URL
	          String saveUrl = request.getContextPath() + "/images/";
	  
	          // 定义允许上传的文件扩展名
	          HashMap<String, String> extMap = new HashMap<String, String>();
	          extMap.put("image", "gif,jpg,jpeg,png,bmp");
	          extMap.put("flash", "swf,flv");
	          extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
	          extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
	  
	          // 最大文件大小
	          long maxSize = 1000000;
	  
	          response.setContentType("text/html; charset=UTF-8");
	  
	          if (!ServletFileUpload.isMultipartContent(request)) {
	              return getError("请选择文件。");
	          }
	          // 检查目录
	          File uploadDir = new File(savePath);
	          if (!uploadDir.isDirectory()) {
	              return getError("上传目录不存在。");
	          }
	          // 检查目录写权限
	          if (!uploadDir.canWrite()) {
	              return getError("上传目录没有写权限。");
	          }
	  
	          String dirName = request.getParameter("dir");
	          if (dirName == null) {
	              dirName = "image";
	          }
	          if (!extMap.containsKey(dirName)) {
	              return getError("目录名不正确。");
	          }
	          // 创建文件夹
	          savePath += dirName + "/";
	          saveUrl += dirName + "/";
	          File saveDirFile = new File(savePath);
	          if (!saveDirFile.exists()) {
	              saveDirFile.mkdirs();
	          }
	          SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	          String ymd = sdf.format(new Date());
	          savePath += ymd + "/";
	          saveUrl += ymd + "/";
	          File dirFile = new File(savePath);
	          if (!dirFile.exists()) {
	              dirFile.mkdirs();
	          }
	 
	         FileItemFactory factory = new DiskFileItemFactory();
	         ServletFileUpload upload = new ServletFileUpload(factory);
	         upload.setHeaderEncoding("UTF-8");
	 
	 
	         MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	         
	         Iterator item = multipartRequest.getFileNames();
	         while (item.hasNext()) {
	 
	             String fileName = (String) item.next();
	 
	             MultipartFile file = multipartRequest.getFile(fileName);
	 
	 
	             // 检查文件大小
	 
	             if (file.getSize() > maxSize) {
	 
	                 return getError("上传文件大小超过限制。");
	 
	             }
	 
	             // 检查扩展名
	 
	             String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
	 
	             if (!Arrays. asList(extMap.get(dirName).split(",")).contains(fileExt)) {
	                 return getError("上传文件扩展名是不允许的扩展名。\n只允许"
	                         + extMap.get(dirName) + "格式。");
	 
	             }
	             SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
	 
	             String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
	 
	             try {
	 
	             File uploadedFile = new File(savePath, newFileName);
	 
	             ByteStreams.copy(file.getInputStream(), new FileOutputStream(uploadedFile));
	 
	             } catch (Exception e) {
	 
	                 return getError("上传文件失败。");
	 
	             }
	             Map<String, Object> msg = new HashMap<String, Object>();
	             msg.put("error", 0);
	             msg.put("url", saveUrl + newFileName);
	             return msg;
	             }
	         return null;
	     }

	      
	      private Map<String, Object> getError(String message) {
	    	           Map<String, Object> msg = new HashMap<String, Object>();
	    	           msg.put("err", 1);
	    	           msg.put("message", message);
	    	           return msg;
	    	       }
	      
}
