package com.dentist.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dentist.cfg.Constant;
import com.dentist.entity.Appoint;
import com.dentist.entity.AppointExample;
import com.dentist.mapper.AppointMapper;
import com.dentist.service.AppointService;
import com.dentist.utils.DateUtil;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("appointService")
public class AppointServiceImpl implements  AppointService{
	
	
	@Autowired
	private AppointMapper appointMapper;
	

	@Override
	public int add(Appoint model) {
		// TODO Auto-generated method stub
		return appointMapper.insert(model);
	}

	@Override
	public int delete(Appoint model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return appointMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Appoint model) {
		// TODO Auto-generated method stub
		return appointMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public Appoint detail(Appoint model) {
		// TODO Auto-generated method stub
		return appointMapper.selectByPrimaryKey(model.getId());
	}

	@Override
	public List<Appoint> getList(Appoint model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LayuiPage<Appoint> page(Appoint model, LayuiPageParam param) {
		// TODO Auto-generated method stub
		LayuiPage<Appoint> layui = new LayuiPage<>();
		layui.setCount(selectCountByExample(model));
		layui.setData(selectWithPageByExample(model, param));
		return layui;
	}

	@Override
	public Appoint queryAppointById(Integer id) {
		// TODO Auto-generated method stub
		return appointMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Appoint> selectWithPageByExample(Appoint appoint,
			LayuiPageParam param) {
		
		AppointExample example = new AppointExample();
		AppointExample.Criteria c = example.createCriteria();
		if(null != appoint && !StringUtils.isEmpty(appoint.getMessagetype())){
			c.andMessagetypeEqualTo(appoint.getMessagetype());
		}
		
		if(null != appoint && !StringUtils.isEmpty(appoint.getStatus())){
			c.andStatusEqualTo(appoint.getStatus());
		}
		
		if(null != appoint && !StringUtils.isEmpty(appoint.getClinic())){
			c.andClinicEqualTo(appoint.getClinic());
		}
		
		if(null != appoint && !StringUtils.isEmpty(appoint.getDoctorname())){
			c.andDoctornameLike('%'+appoint.getDoctorname()+'%');
		}
				Map<String, String> params = new HashMap<>();
				params.put("order", param.getOrder());
				params.put("sort", param.getSort());	
				params.put("rowStart", (param.getPage()-1)*param.getLimit()+"");	
				params.put("pageSize", param.getLimit()+"");	
				
				
				
				return appointMapper.selectWithPageByExample(example, params);
	}

	@Override
	public int selectCountByExample(Appoint appoint) {
		// TODO Auto-generated method stub
		AppointExample example = new AppointExample();
		AppointExample.Criteria c = example.createCriteria();
		if(null != appoint && !StringUtils.isEmpty(appoint.getMessagetype())){
			c.andMessagetypeEqualTo(appoint.getMessagetype());
		}
		
		if(null != appoint && !StringUtils.isEmpty(appoint.getStatus())){
			c.andStatusEqualTo(appoint.getStatus());
		}
		
		if(null != appoint && !StringUtils.isEmpty(appoint.getClinic())){
			c.andClinicEqualTo(appoint.getClinic());
		}
		
		if(null != appoint && !StringUtils.isEmpty(appoint.getDoctorname())){
			c.andDoctornameLike('%'+appoint.getDoctorname()+'%');
		}
		
		return appointMapper.countByExample(example);
	}

	@Override
	public int queryNot_YYNums() {
		// TODO Auto-generated method stub
		AppointExample example = new AppointExample();
		AppointExample.Criteria c = example.createCriteria();
		c.andMessagetypeEqualTo(Constant.LEAVE_MSG_YUYUE);
		c.andStatusEqualTo(Constant.WAITING_REPLY);
		
		return appointMapper.countByExample(example);
	}

	@Override
	public int queryNot_ZXNums() {
		// TODO Auto-generated method stub
		AppointExample example = new AppointExample();
		AppointExample.Criteria c = example.createCriteria();
		c.andMessagetypeEqualTo(Constant.LEAVE_MSG_ZIXUN);
		c.andStatusEqualTo(Constant.WAITING_REPLY);
		
		return appointMapper.countByExample(example);
	}

	
	@Override
	public List<String> queryCSVList(Appoint appoint) {
		// TODO Auto-generated method stub
		AppointExample example = new AppointExample();
		AppointExample.Criteria c = example.createCriteria();
		if(null != appoint && !StringUtils.isEmpty(appoint.getMessagetype())){
			c.andMessagetypeEqualTo(appoint.getMessagetype());
		}
		
		if(null != appoint && !StringUtils.isEmpty(appoint.getStatus())){
			c.andStatusEqualTo(appoint.getStatus());
		}
		
		if(null != appoint && !StringUtils.isEmpty(appoint.getClinic())){
			c.andClinicEqualTo(appoint.getClinic());
		}
		
		if(null != appoint && !StringUtils.isEmpty(appoint.getDoctorname())){
			c.andDoctornameLike('%'+appoint.getDoctorname()+'%');
		}
		
		List<Appoint> aList = appointMapper.selectByExample(example);
		List<String> returnData = prepareData(aList);
		
		return returnData;
	}
	
	 /* 组合数据 */
	 private List<String> prepareData(List<Appoint> list){
	        List<String> returnData = new ArrayList<String>();
	        
	            if(null != list){
	            	StringBuffer headerData = new StringBuffer();
	            	headerData.append("患者名").append(",");
	            	headerData.append("患者电话").append(",");
	            	headerData.append("消息类型").append(",");
	            	headerData.append("诊所").append(",");
	            	headerData.append("医生名").append(",");
	            	headerData.append("预约日期").append(",");
	            	headerData.append("消息状态").append(",");
	            	headerData.append("创建时间");
	            	
	                for(int i=0;i<list.size();i++){
	                	Appoint appoint = list.get(i);
	                	StringBuffer writerData = new StringBuffer();
	                	writerData.append("\t"+appoint.getPatientname()).append(",");
	                	writerData.append("\t"+appoint.getPhone()).append(",");
	                	writerData.append("\t"+appoint.getMessagetype()).append(",");
	                	writerData.append("\t"+appoint.getClinic()).append(",");
	                	writerData.append("\t"+appoint.getDoctorname()).append(",");
	                	writerData.append("\t"+DateUtil.dateToString(appoint.getAppointdate(), "YYYY-MM-dd")).append(",");
	                	writerData.append("\t"+appoint.getStatus()).append(",");
	                	writerData.append("\t"+DateUtil.dateToString(appoint.getCreatetime(), "YYYY-MM-dd HH:mm:ss"));
	                	
	                	if(i == 0){
	                		returnData.add(headerData.toString());
	                	}
	                	
	                	returnData.add(writerData.toString());
	                } 
	            }
	        
	        return returnData;
	    }
	
	
}
