package com.dentist.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dentist.entity.Appoint;
import com.dentist.entity.AppointExample;
import com.dentist.mapper.AppointMapper;
import com.dentist.service.AppointService;
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
			c.andDoctornameLike('%'+appoint.getClinic()+'%');
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
	
	/*





	@SuppressWarnings("unused")
	@Override
	public List<QuestionA> getList(QuestionA model) {
		// TODO Auto-generated method stub
		QuestionAExample qAExample = new QuestionAExample();
		QuestionAExample.Criteria c = qAExample.createCriteria();
		return questionAMapper.selectByExample(qAExample);
	}

	@Override
	public LayuiPage<QuestionA> page(QuestionA model, LayuiPageParam param) {
		// TODO Auto-generated method stub
		LayuiPage<QuestionA> layui = new LayuiPage<>();
		layui.setCount(selectCountByExample(model));
		layui.setData(selectWithPageByExample(model, param));
		return layui;
	}


	@Override
	public List<QuestionA> selectWithPageByExample(QuestionA qA,
			LayuiPageParam param) {
		
		QuestionAExample qAExample = new QuestionAExample();
		QuestionAExample.Criteria c = qAExample.createCriteria();
		if(null != qA && !StringUtils.isEmpty(qA.getQuestion())){
			c.andQuestionLike('%'+qA.getQuestion()+'%');
		}
				Map<String, String> params = new HashMap<>();
				params.put("order", param.getOrder());
				params.put("sort", param.getSort());	
				params.put("rowStart", (param.getPage()-1)*param.getLimit()+"");	
				params.put("pageSize", param.getLimit()+"");	
				
				
				
				return questionAMapper.selectWithPageByExample(qAExample, params);
	}

	@Override
	public int selectCountByExample(QuestionA qA) {
		// TODO Auto-generated method stub
		QuestionAExample qAExample = new QuestionAExample();
		QuestionAExample.Criteria c = qAExample.createCriteria();
		if(null != qA && !StringUtils.isEmpty(qA.getQuestion())){
			c.andQuestionLike('%'+qA.getQuestion()+'%');
		}
		
		return questionAMapper.countByExample(qAExample);
	}

	@Override
	public QuestionA queryQuestionANotRepeatByQuestion(String question,
			Integer id) {
   		
		QuestionAExample qAExample = new QuestionAExample();
		QuestionAExample.Criteria c  = qAExample.createCriteria();
			c.andQuestionEqualTo(question);
			c.andIdNotEqualTo(id);
			List<QuestionA> list = questionAMapper.selectByExample(qAExample);
			if(!CollectionUtils.isEmpty(list)){
				return list.get(0);
			}
			
			return null;
	}
	@Override
	public QuestionA queryByQuestion(String question) {
		// TODO Auto-generated method stub
		QuestionAExample qAExample = new QuestionAExample();
		QuestionAExample.Criteria c  = qAExample.createCriteria();
		if(!StringUtils.isEmpty(question)){
			c.andQuestionEqualTo(question);
			
			List<QuestionA> list = questionAMapper.selectByExample(qAExample);
			if(!CollectionUtils.isEmpty(list)){
				return list.get(0);
			}
			
		}
		return null;
	}
	*/
	
}
