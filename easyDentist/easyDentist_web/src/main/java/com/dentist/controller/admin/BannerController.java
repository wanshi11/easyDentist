package com.dentist.controller.admin;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
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
import com.dentist.entity.Banner;
import com.dentist.interceptor.RequiredPermission;
import com.dentist.service.BannerService;
import com.dentist.utils.DateUtil;
import com.dentist.utils.JsonUtils;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

/**
 * 
 * 轮播器管理
 */
@Controller
@RequestMapping(value = "/admin/banner")
@PropertySource("classpath:config.properties")
public class BannerController {
	
	@Autowired
	private BannerService bannerService;
	
	@Value("${pic_db_Path}")
	private String pic_db_Path;
	
	@Value("${picPath}")
	private String picPath;
	
	/**
	 * 到banner列表页 
	 */
	@RequiredPermission
	@RequestMapping(value="/toBanners", method = RequestMethod.GET)
	public String  toBanners(){
		
		return "/admin/banner/banner_list";
	}
	
	/**
	 * 到添加页面 
	 */
	@RequestMapping(value = "/toAdd")
	public String addBanner(){
		
		return "/admin/banner/banner_add";
	}
	
	/**
	 * 到轮播活动编辑页
	 */
	@RequestMapping(value="/toAddLunboContent", method = RequestMethod.GET)
	public String  toAddLunboContent(Model model,String id,String bannername){
		
		model.addAttribute("id", Integer.parseInt(id));
		model.addAttribute("bannername", bannername);
		return "/admin/banner/banner_lunbo";
	}
	
	/**
	 * 添加轮播
	 */
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ResponseBody
	public String add(Banner ban,HttpServletRequest request){
		String result = "";
		
		ban.setCreatetime(new Date());
		    if(Constant.BANNER_LUNBO.equals(ban.getType())){
		    	ban.setReadvalue(Integer.parseInt(((int)(Math.random() * 20))+""));
		    }
			int num = bannerService.insertAndGetId(ban);
			if(num !=0){
				result = ban.getId()+"";
			}else{
				result = "ADD_FAIL";
			}
	
		return result;
	}
	
	
	/**
	 * 添加轮播活动内容
	 */
	@RequestMapping(value = "/addlunboContent",method=RequestMethod.POST)
	@ResponseBody
	public String addlunboContent(Banner banner){
		String result = "";
		
			Banner ba = bannerService.queryBannerById(banner.getId());
			ba.setHref("/activity/showContentById?acId="+ba.getId());
			ba.setContent(banner.getContent());
			
			int num = bannerService.update(ba);
			if(num !=0){
				result = "ADD_SUCCESS";
			}else{
				result = "ADD_FAIL";
			}
	
		return result;
	}
	
	
	/**
	 * 到修改页面 
	 */
	@RequestMapping(value = "/toEdit")
	public String editBanner(Model model,int id){
		
		Banner banner = bannerService.queryBannerById(id);
		model.addAttribute("banner", banner);
		
		return "/admin/banner/banner_edit";
	}
	
	
	/**
	 * 修改Banner
	 */
	@RequestMapping(value = "/edit",method=RequestMethod.POST)
	@ResponseBody
	public String edit(Banner banner,HttpServletRequest request){
		String result = "";
		
		    banner.setCreatetime(new Date());
			int num = bannerService.update(banner);
			if(num !=0){
				result = "EDIT_SUCCESS";
			}else{
				result = "EDIT_FAIL";
			}
	
		return result;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(int id){
	
		int num = bannerService.deleteById(id);
		 return num > 0 ? "DELETE_SUCCESS":"DELETE_FAIL";
	}
	
	/**
	 * 查询轮播列表 
	 */
	@RequestMapping(value = "/bannerList",method=RequestMethod.POST)
	@ResponseBody
	public LayuiPage<Banner> userList(Banner banner,LayuiPageParam param) {
	
		return bannerService.page(banner, param);
	}
	
	
	/**
	 * 上传轮播图片
	 * @return
	 */
	@RequestMapping(value = "/uploadPic",headers = "Accept=application/json",produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
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
                   FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(picPath+"banner/",file_db_name));
                    //coding
                   map.put( "error", "success");
                   map.put( "msg", "上传成功！");
                   map.put( "imgurl", pic_db_Path+"banner/"+file_db_name);
                   
             } catch (Exception e) {
                   map.put( "error", "error");
                   map.put( "msg",e.getMessage());
                   
             }
       }
       String result= JsonUtils.objectToString(map);
        return result;
	}

}
