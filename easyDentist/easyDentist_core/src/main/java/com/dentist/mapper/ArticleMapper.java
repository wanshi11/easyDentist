package com.dentist.mapper;

import com.dentist.entity.Article;
import com.dentist.entity.ArticleExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    int countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);
    
    int insertArticle(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
    
    List<Article> selectWithPageByExample(@Param("example") ArticleExample example,@Param("params") Map<String, String> params);

    
    List<Article> queryArticlePageInfoByType(@Param(value="start") Integer start,@Param(value="size") Integer size,@Param(value="type") String type);//start 从第几条数据开始
    
    Integer queryArticlePageCountByType(@Param(value="type") String type);//总条数
    
    
}