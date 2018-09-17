package com.dentist.service;

import java.util.List;

import com.dentist.entity.QuestionA;
import com.dentist.utils.LayuiPageParam;

public interface QaService extends IBaseService<QuestionA> {
	
	
	
	
	//根据ID名
	QuestionA queryQaById(Integer id);
	
	//根据条件查询分页数据
	List<QuestionA> selectWithPageByExample(QuestionA qA,LayuiPageParam param);
	
	//根据条件查询总数据条数
	int selectCountByExample(QuestionA qA);
	
	QuestionA queryQuestionANotRepeatByQuestion(String question, Integer id);

	QuestionA queryByQuestion(String question);

}
