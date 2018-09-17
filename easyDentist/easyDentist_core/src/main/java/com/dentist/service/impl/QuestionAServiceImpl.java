package com.dentist.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.dentist.entity.QuestionA;
import com.dentist.entity.QuestionAExample;
import com.dentist.entity.Role;
import com.dentist.entity.RoleExample;
import com.dentist.mapper.QuestionAMapper;
import com.dentist.service.QaService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("qaService")
public class QuestionAServiceImpl implements  QaService{
	
	@Autowired
	private QuestionAMapper questionAMapper;

	@Override
	public int add(QuestionA model) {
		// TODO Auto-generated method stub
		return questionAMapper.insert(model);
	}

	@Override
	public int delete(QuestionA model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return questionAMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(QuestionA model) {
		// TODO Auto-generated method stub
		return questionAMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public QuestionA detail(QuestionA model) {
		// TODO Auto-generated method stub
		return null;
	}

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
	public QuestionA queryQaById(Integer id) {
		// TODO Auto-generated method stub
		return questionAMapper.selectByPrimaryKey(id);
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
	
	
}
