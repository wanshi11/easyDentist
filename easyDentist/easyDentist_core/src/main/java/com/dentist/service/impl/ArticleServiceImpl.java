package com.dentist.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.dentist.cfg.Constant;
import com.dentist.entity.Article;
import com.dentist.entity.ArticleExample;
import com.dentist.mapper.ArticleMapper;
import com.dentist.service.ArticleService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;
import com.dentist.utils.Page;

@Transactional
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public int add(Article model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Article model) {
		// TODO Auto-generated method stub
		return articleMapper.deleteByPrimaryKey(model.getId());
	}

	@Override
	public int update(Article model) {
		// TODO Auto-generated method stub
		return articleMapper.updateByPrimaryKey(model);
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
		LayuiPage<Article> page = new LayuiPage<>();
		page.setData(selectWithPageByExample(model, param));
		page.setCount(selectCountByExample(model));
		return page;
	}

	@Override
	public Integer addArticle(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.insertArticle(article);
	}

	@Override
	public Article queryArticleByTitle(String title) {
		// TODO Auto-generated method stub
		ArticleExample example  = new ArticleExample();
		ArticleExample.Criteria c = example.createCriteria();
		c.andTitleEqualTo(title);
		
		List<Article> list = articleMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Article> selectWithPageByExample(Article article,
			LayuiPageParam param) {

		ArticleExample example = new ArticleExample();
		ArticleExample.Criteria c  = example.createCriteria();
		if(null != article && !StringUtils.isEmpty(article.getTitle())){
			c.andTitleLike('%'+article.getTitle()+'%');
		}
		
		Map<String, String> params = new HashMap<>();
		params.put("order", param.getOrder());
		params.put("sort", param.getSort());	
		params.put("rowStart", (param.getPage()-1)*param.getLimit()+"");	
		params.put("pageSize", param.getLimit()+"");	
		
		return articleMapper.selectWithPageByExample(example, params);
	}

	@Override
	public int selectCountByExample(Article article) {
		// TODO Auto-generated method stub
		ArticleExample example = new ArticleExample();
		ArticleExample.Criteria c  = example.createCriteria();
		if(null != article && !StringUtils.isEmpty(article.getTitle())){
			c.andTitleLike('%'+article.getTitle()+'%');
		}
		
		return articleMapper.countByExample(example);
	}

	@Override
	public Article queryArticleById(int id) {
		// TODO Auto-generated method stub
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public Article queryArticleNotRepeatByTitle(String title, Integer id) {
		// TODO Auto-generated method stub
		ArticleExample example = new ArticleExample();
		ArticleExample.Criteria c  = example.createCriteria();
		c.andTitleEqualTo(title);
		c.andIdNotEqualTo(id);
		
		List<Article> list = articleMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public Page<Article> queryArticlesByType(String type,Integer currentPage) {
		// TODO Auto-generated method stub
		Page<Article> pager = new Page<>();
		
		if(StringUtils.isEmpty(type)){
			type = Constant.ARTICLE_NEWS;
		}
		if(currentPage == null){
			currentPage = 1;
		}
		
		int total = articleMapper.queryArticlePageCountByType(type);
		pager.setTotalRecord(total);
		
		List<Article> list = articleMapper.queryArticlePageInfoByType((currentPage-1)*pager.getPageSize(), pager.getPageSize(), type);
		pager.setList(list);
		pager.setCurrentPage(currentPage);
		
		
		return pager;
	}

	@Override
	public List<Article> queryTop5Article() {
		
		return articleMapper.queryTop5Article();
	}

	@Override
	public Article queryThePreArticle(int articleId) {
		// TODO Auto-generated method stub
		return articleMapper.queryThePreArticle(articleId);
	}

	@Override
	public Article queryTheNextArticle(int articleId) {
		// TODO Auto-generated method stub
		return articleMapper.queryTheNextArticle(articleId);
	}

	
	
	
	
	
	
	
	
	
	
}
