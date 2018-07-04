package com.dentist.controller.admin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dentist.entity.Article;
import com.dentist.entity.ArticleExt;
import com.dentist.entity.User;
import com.dentist.service.ArticleService;
import com.dentist.utils.Constant;
import com.dentist.utils.DateUtil;
import com.dentist.utils.JsonUtils;

@Controller
@RequestMapping(value = "/admin/article")
public class ArticleController {
	
	@Autowired
	private  ArticleService articleService;
	
	
	/**
	 * 到文章列表页 
	 */
	@RequestMapping(value="/toArticles", method = RequestMethod.GET)
	public String  toArticles(){
		
		return "/admin/article/article_list";
	}
	
	/**
	 * 到添加页面 
	 */
	@RequestMapping(value = "/toAdd")
	public String addArticle(Model model){
		
		return "/admin/article/article_add";
	}
	
	
	/**
	 * 添加文章
	 */
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ResponseBody
	public String add(Article article,ArticleExt articleExt,HttpServletRequest request){
		String result = "";
		
		    User u = (User)request.getSession().getAttribute(Constant.LOGIN_USER);
			
			/*if(num !=0){
				result = "ADD_SUCCESS";
			}else{
				result = "ADD_FAIL";
			}*/
	
		return result;
	}
	
	
	/**
	 * 上传文章中的缩略图
	 * @return
	 */
	@RequestMapping(value = "/uploadThumbnail",method=RequestMethod.POST)
	@ResponseBody
	public String uploadThumbnail(@RequestParam MultipartFile myfile,HttpServletRequest request){
		
        Map<String,Object> map= new HashMap<String,Object>();
        if(myfile.isEmpty()){
             map.put( "error", "error");
             map.put( "msg", "上传文件不能为空" );
       } else{
             String originalFilename=myfile.getOriginalFilename();
             String fileBaseName=FilenameUtils.getBaseName(originalFilename);
             String floderName=fileBaseName+"_" +DateUtil.getNowDate();
              try{
                   
                   String genePicPath=request.getSession().getServletContext().getRealPath("/upload/" +floderName);
                    //把上传的图片放到服务器的文件夹下
                   FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(genePicPath,originalFilename));
                    //coding
                   map.put( "error", "上传成功！");
                   map.put( "imgurl", "1111");
                   
             } catch (Exception e) {
                   map.put( "error", "error");
                   map.put( "msg",e.getMessage());
                   
             }
       }
       String result= JsonUtils.objectToString(map);
        return result;
	}

}
