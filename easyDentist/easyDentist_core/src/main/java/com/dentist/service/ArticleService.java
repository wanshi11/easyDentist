package com.dentist.service;

import java.util.List;

import com.dentist.entity.Article;
import com.dentist.utils.LayuiPageParam;
import com.dentist.utils.Pager;


public interface ArticleService extends IBaseService<Article>{

	
	//杩斿洖ID
	Integer addArticle(Article article);

	Article queryArticleByTitle(String title);

	
	//鏍规嵁鏉′欢鏌ヨ鎬绘暟鎹潯鏁�
	int selectCountByExample(Article article);
	
	//鏍规嵁鏉′欢鏌ヨ鍒嗛〉鏁版嵁
    List<Article> selectWithPageByExample(Article article,LayuiPageParam param);

	Article queryArticleById(int id);

	Article queryArticleNotRepeatByTitle(String title, Integer id);

	//前台分页
	Pager<Article> queryArticlesByType(String type);
}
