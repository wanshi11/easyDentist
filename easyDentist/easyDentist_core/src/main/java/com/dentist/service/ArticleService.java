package com.dentist.service;

import java.util.List;

import com.dentist.entity.Article;
import com.dentist.utils.LayuiPageParam;


public interface ArticleService extends IBaseService<Article>{

	
	//返回ID
	Integer addArticle(Article article);

	Article queryArticleByTitle(String title);

	
	//根据条件查询总数据条数
	int selectCountByExample(Article article);
	
	//根据条件查询分页数据
    List<Article> selectWithPageByExample(Article article,LayuiPageParam param);

	Article queryArticleById(int id);

	Article queryArticleNotRepeatByTitle(String title, Integer id);
}
