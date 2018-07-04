package com.dentist.service;

import com.dentist.entity.Article;


public interface ArticleService extends IBaseService<Article>{

	
	//返回ID
	Integer addArticle(Article article);

}
