package com.dentist.controller.admin;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dentist.entity.Doctor;
import com.dentist.service.DoctorService;
import com.dentist.utils.DateUtil;
import com.dentist.utils.JsonUtils;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;



@Controller
@RequestMapping(value = "/admin/doctor")
public class DoctorController {

	
	@Autowired
	private DoctorService doctorService;
	
	@Value("${pic_db_Path}")
	private String pic_db_Path;
	
	@Value("${picPath}")
	private String picPath;
	
	
	/**
	 * 到医生列表页面 
	 */
	@RequestMapping(value = "/toDoctors", method = RequestMethod.GET)
	public String toDoctorList(Model model) {

	
		return "/admin/doctor/doctor_list";
	}
	
	/**
	 * 到添加页面 
	 */
	@RequestMapping(value = "/toAdd")
	public String addDoctor(){
		
		return "/admin/doctor/doctor_add";
	}
	
	
	/**
	 * 添加医生
	 */
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ResponseBody
	public String add(Doctor doctor,HttpServletRequest request){
		
		doctor.setCreatetime(new Date());
		int num = doctorService.add(doctor);
	
		return num !=0 ? "ADD_SUCCESS":"ADD_FAIL";
	}

	
	/**
	 * 查询列表 
	 */
	@RequestMapping(value = "/doctorList",method=RequestMethod.POST)
	@ResponseBody
	public LayuiPage<Doctor> userList(Doctor doctor,LayuiPageParam param) {
	
		return doctorService.page(doctor, param);
	}
	
	
	/**
	 * 删除医生
	 */
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(Integer id){
	
		int num = doctorService.deleteById(id);
	
		return num > 0 ? "DELETE_SUCCESS":"DELETE_FAIL";
	}
	
	
	
	/**
	 * 到修改页面 
	 */
	@RequestMapping(value = "/toEdit")
	public String editRole(Model model,int id){
		
		Doctor doctor = doctorService.queryDoctorById(id);
		model.addAttribute("doctor", doctor);
		
		return "/admin/doctor/doctor_edit";
	}

	
	/**
	 * 修改医生信息
	 */
	@RequestMapping(value = "/edit",method=RequestMethod.POST)
	@ResponseBody
	public String edit(Doctor doctor){
		
		doctor.setCreatetime(new Date());
		int num = doctorService.update(doctor);
		return num > 0 ? "EDIT_SUCCESS":"EDIT_FAIL";
	}
	
	
	
	/**
	 * 上传医生一寸照
	 * @return
	 */
	@RequestMapping(value = "/uploadInchPhoto",headers = "Accept=application/json",produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
	@ResponseBody
	public String uploadInchPhoto(@RequestParam MultipartFile myfile1,HttpServletRequest request){
		
        Map<String,Object> map= new HashMap<String,Object>();
        if(myfile1.isEmpty()){
             map.put( "error", "error");
             map.put( "msg", "上传文件不能为空" );
       } else{
             String originalFilename=myfile1.getOriginalFilename();
//             String fileBaseName=FilenameUtils.getBaseName(originalFilename);
             String file_db_name = DateUtil.format(new Date(), "yyyyMMddHHmmss")+"_"+originalFilename;
              try{
          
                   //String genePicPath=request.getSession().getServletContext().getRealPath(picPath+"art_thumbnail/");
                    //把上传的图片放到服务器的文件夹下
                   FileUtils.copyInputStreamToFile(myfile1.getInputStream(), new File(picPath+"doctor_inchphoto/",file_db_name));
                    //coding
                   map.put( "error", "success");
                   map.put( "msg", "上传成功！");
                   map.put( "imgurl", pic_db_Path+"doctor_inchphoto/"+file_db_name);
                   
             } catch (Exception e) {
                   map.put( "error", "error");
                   map.put( "msg",e.getMessage());
                   
             }
       }
       String result= JsonUtils.objectToString(map);
        return result;
	}
	
	
	/**
	 * 上传医生宣传照
	 * @return
	 */
	@RequestMapping(value = "/uploadDoctorPic",headers = "Accept=application/json",produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
	@ResponseBody
	public String uploadDoctorPic(@RequestParam MultipartFile myfile2,HttpServletRequest request){
		
        Map<String,Object> map= new HashMap<String,Object>();
        if(myfile2.isEmpty()){
             map.put( "error", "error");
             map.put( "msg", "上传文件不能为空" );
       } else{
             String originalFilename=myfile2.getOriginalFilename();
//             String fileBaseName=FilenameUtils.getBaseName(originalFilename);
             String file_db_name = DateUtil.format(new Date(), "yyyyMMddHHmmss")+"_"+originalFilename;
              try{
          
                   //String genePicPath=request.getSession().getServletContext().getRealPath(picPath+"art_thumbnail/");
                    //把上传的图片放到服务器的文件夹下
                   FileUtils.copyInputStreamToFile(myfile2.getInputStream(), new File(picPath+"doctor_pic/",file_db_name));
                    //coding
                   map.put( "error", "success");
                   map.put( "msg", "上传成功！");
                   map.put( "imgurl", pic_db_Path+"doctor_pic/"+file_db_name);
                   
             } catch (Exception e) {
                   map.put( "error", "error");
                   map.put( "msg",e.getMessage());
                   
             }
       }
       String result= JsonUtils.objectToString(map);
        return result;
	}
}
