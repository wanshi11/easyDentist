package com.dentist.mapper;

import com.dentist.entity.QuestionA;
import com.dentist.entity.QuestionAExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface QuestionAMapper {
    int countByExample(QuestionAExample example);

    int deleteByExample(QuestionAExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionA record);

    int insertSelective(QuestionA record);

    List<QuestionA> selectByExample(QuestionAExample example);

    QuestionA selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuestionA record, @Param("example") QuestionAExample example);

    int updateByExample(@Param("record") QuestionA record, @Param("example") QuestionAExample example);

    int updateByPrimaryKeySelective(QuestionA record);

    int updateByPrimaryKey(QuestionA record);

	List<QuestionA> selectWithPageByExample(@Param("example") QuestionAExample qAExample,
			@Param("params") Map<String, String> params);
}