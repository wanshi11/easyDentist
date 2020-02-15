package com.dentist.mapper;

import com.dentist.entity.ArticleExt;
import com.dentist.entity.ArticleExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleExtMapper {
    int countByExample(ArticleExtExample example);

    int deleteByExample(ArticleExtExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleExt record);

    int insertSelective(ArticleExt record);

    List<ArticleExt> selectByExampleWithBLOBs(ArticleExtExample example);

    List<ArticleExt> selectByExample(ArticleExtExample example);

    ArticleExt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleExt record, @Param("example") ArticleExtExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleExt record, @Param("example") ArticleExtExample example);

    int updateByExample(@Param("record") ArticleExt record, @Param("example") ArticleExtExample example);

    int updateByPrimaryKeySelective(ArticleExt record);

    int updateByPrimaryKeyWithBLOBs(ArticleExt record);

    int updateByPrimaryKey(ArticleExt record);
}