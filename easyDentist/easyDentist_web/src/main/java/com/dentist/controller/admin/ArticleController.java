package com.dentist.controller.admin;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dentist.cfg.Constant;
import com.dentist.entity.Article;
import com.dentist.entity.ArticleExt;
import com.dentist.entity.User;
import com.dentist.service.ArticleExtService;
import com.dentist.service.ArticleService;
import com.dentist.utils.DateUtil;
import com.dentist.utils.JsonUtils;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;


@Controller
@RequestMapping(value = "/admin/article")
@PropertySource("classpath:config.properties")//如果是application.properties，就不用写@PropertyScource("application.properties")，其他名字用些  
public class ArticleController {
	
	@Autowired
	private  ArticleService articleService;
	@Autowired
    private ArticleExtService articleExtService;
	
	@Value("${pic_db_Path}")
	private String pic_db_Path;
	
	@Value("${picPath}")
	private String picPath;
	
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
		    
		    article.setCreatetime(new Date());
		    article.setOperatorid(u.getId());
		    articleService.addArticle(article);
		    
		    articleExt.setArticleid(article.getId());
		    articleExt.setReadvalue(0);
		    int num = articleExtService.add(articleExt);
			if(num !=0){
				result = "ADD_SUCCESS";
			}else{
				result = "ADD_FAIL";
			}
	
		return result;
	}
	
	
	/**
	 * 上传文章中的缩略图
	 * @return
	 */
	@RequestMapping(value = "/uploadThumbnail",headers = "Accept=application/json",produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
	@ResponseBody
	public String uploadThumbnail(@RequestParam MultipartFile myfile,HttpServletRequest request){
		
        Map<String,Object> map= new HashMap<String,Object>();
        if(myfile.isEmpty()){
             map.put( "error", "error");
             map.put( "msg", "上传文件不能为空" );
       } else{
             String originalFilename=myfile.getOriginalFilename();
//             String fileBaseName=FilenameUtils.getBaseName(originalFilename);
             String file_db_name = DateUtil.format(new Date(), "yyyyMMddHHmmss")+"_"+originalFilename;
              try{
            	  
                   
                   //String genePicPath=request.getSession().getServletContext().getRealPath(picPath+"art_thumbnail/");
                    //把上传的图片放到服务器的文件夹下
                   FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(picPath+"art_thumbnail/",file_db_name));
                    //coding
                   map.put( "error", "success");
                   map.put( "msg", "上传成功！");
                   map.put( "imgurl", pic_db_Path+"art_thumbnail/"+file_db_name);
                   
             } catch (Exception e) {
                   map.put( "error", "error");
                   map.put( "msg",e.getMessage());
                   
             }
       }
       String result= JsonUtils.objectToString(map);
        return result;
	}
	
	/**
	 * 校验文章标题唯一性
	 * @param title
	 * @return
	 */
	@RequestMapping(value="/checkTitle",method=RequestMethod.POST)
	@ResponseBody
	public String  checkTitle(String title){
		
		Article a = articleService.queryArticleByTitle(title);
		if(a != null){  //已有该角色
			return "1";
		}
		return "0";
		
	}
	
	/**
	 * 到修改页面 
	 */
	@RequestMapping(value = "/toEdit")
	public String editArticle(Model model,int id){
		
		Article art = articleService.queryArticleById(id);
		ArticleExt artE = articleExtService.queryArticleExtByarticleId(id);
		
		
	/*	String content=artE.getContent().replaceAll("&","&amp")
		                                .replaceAll("<","&lt")
		                                .replaceAll(">","&gt");*/
		
//		String content=artE.getContent().replaceAll(" ", "");
//		artE.setContent(content);
		model.addAttribute("art", art);
		model.addAttribute("artE", artE);
		
		return "/admin/article/article_edit";
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@RequestMapping(value="/articleList",method=RequestMethod.POST)
	@ResponseBody
	public LayuiPage<Article> articleList(Article article,LayuiPageParam param){
		
		return articleService.page(article, param);
	}

}
