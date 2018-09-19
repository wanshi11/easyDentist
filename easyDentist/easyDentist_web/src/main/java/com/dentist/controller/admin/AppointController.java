package com.dentist.controller.admin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dentist.entity.Appoint;
import com.dentist.interceptor.RequiredPermission;
import com.dentist.service.AppointService;
import com.dentist.service.UserService;
import com.dentist.utils.CsvUtil;
import com.dentist.utils.DateUtil;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;
import com.sun.org.apache.bcel.internal.generic.NEW;


/**
 * 
 *  预约控制器
 */

@Controller
@RequestMapping(value = "/admin/appoint")
public class AppointController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@Autowired
	private AppointService appointService;
	
	@Autowired
	private UserService userService;
	
	 
	
	/**
	 * 到预约列表页 
	 */
	@RequiredPermission
	@RequestMapping(value="/toAppoints", method = RequestMethod.GET)
	public String  toAppoints(){
		
		return "/admin/appoint/appoint_list";
	}

	/**
	 * 查询预约列表 
	 */
	@RequestMapping(value = "/appointList",method=RequestMethod.POST)
	@ResponseBody
	public LayuiPage<Appoint> appointList(Appoint appoint,LayuiPageParam param) {
	
		return appointService.page(appoint, param);
	}
	
	
	/**
	 * 到回访、回复页面 
	 */
	@RequestMapping(value = "/toEdit")
	public String editAppoint(Model model,int id){
		
		Appoint appoint = appointService.queryAppointById(id);
		model.addAttribute("appoint", appoint);
		
		return "/admin/appoint/appoint_edit";
	}
	
	
	
	/**
	 * 进行处理预约
	 */
	/*@RequestMapping(value = "/edit",method=RequestMethod.POST)
	@ResponseBody
	public String edit(QuestionA qA,HttpServletRequest request){
		String result = "";
		
		User u = (User)request.getSession().getAttribute(Constant.LOGIN_USER);
		
		QuestionA qa = qaService.queryQuestionANotRepeatByQuestion(qA.getQuestion(), qA.getId());
		if(qa != null){
			result = "QUESTION_EXIST";
			return result;
		}
		qA.setTime(new Date());
		qA.setOperatorid(u.getId());
			int num = qaService.update(qA);
			if(num !=0){
				result = "EDIT_SUCCESS";
			}else{
				result = "EDIT_FAIL";
			}
	
		return result;
	}*/
	
	
	/**
	 * 删除消息
	 */
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public String delete(Integer id){
		String result = "";
		int num =  appointService.deleteById(id);
		if(num > 0){
			result="DELETE_SUCCESS";
		}else{
			result="DELETE_FAIL";
		}
	
		return result;
	}	
	
	/**
	 * 导出CSV文件
	 */
/*	@RequestMapping(value = "/exportCSV",method=RequestMethod.POST)
	@ResponseBody
	public File exportCSV(Appoint appoint){

        File csvFile = null;
        String outPutPath = System.getProperty("user.dir");
        
        SimpleDateFormat matter1 = new SimpleDateFormat("yyyyMMdd");
        String date = matter1.format(new Date());
        
        csvFile = new File(outPutPath+date+".csv");
        
        List<String> data = appointService.queryCSVList(appoint);
          
        
        FileWriter fw = null;
        BufferedWriter writer = null;
        try {
            fw = new FileWriter(csvFile);
            writer = new BufferedWriter(fw);
            writer.write(date+"/"+data.size());
            writer.newLine();//换行
            if(null != data){
                for(int i=0;i<data.size();i++){
                    writer.write(data.get(i));
                    writer.newLine();//换行
                }
            }
            writer.flush();
        }catch (Exception e) {
        	logger.error("导出文件失败："+e.getMessage());
            return null;
        }finally{
            try {
                writer.close();
                fw.close();
            } catch (IOException e) {
            	logger.error(""+e.getMessage());
            }
        }
        logger.info("成功导出文件"+csvFile.getName()+"到："+csvFile.getPath());
        
        return csvFile;
	}
	*/
	
	@RequestMapping(value = "/exportCSV",method=RequestMethod.POST)
	public void exportCSV(HttpServletResponse response,Appoint appoint){
		
	List<String> data = appointService.queryCSVList(appoint);
		
	boolean isSuccess = CsvUtil.exportCsv(data, null);
	if(isSuccess)
		CsvUtil.download(response);
		
	}
	
}
