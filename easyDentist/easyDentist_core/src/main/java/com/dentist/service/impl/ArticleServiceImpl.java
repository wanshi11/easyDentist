package com.dentist.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentist.entity.Article;
import com.dentist.service.ArticleService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Override
	public int add(Article model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Article model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Article model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Article detail(Article model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> getList(Article model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LayuiPage<Article> page(Article model, LayuiPageParam param) {
		// TODO Auto-generated method stub
		return null;
	}

}
