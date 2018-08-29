package com.dentist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.dentist.entity.ArticleExt;
import com.dentist.entity.ArticleExtExample;
import com.dentist.mapper.ArticleExtMapper;
import com.dentist.service.ArticleExtService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("articleExtService")
public class ArticleExtServiceImpl implements ArticleExtService {
	
	@Autowired
	private ArticleExtMapper articleExtMapper;

	@Override
	public int add(ArticleExt model) {
		// TODO Auto-generated method stub
		return articleExtMapper.insert(model);
	}

	@Override
	public int delete(ArticleExt model) {
		// TODO Auto-generated method stub
		ArticleExtExample example = new ArticleExtExample();
		ArticleExtExample.Criteria c = example.createCriteria();
		c.andArticleidEqualTo(model.getArticleid());
		return articleExtMapper.deleteByExample(example);
	}

	@Override
	public int update(ArticleExt model) {
		// TODO Auto-generated method stub
		return articleExtMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public ArticleExt detail(ArticleExt model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleExt> getList(ArticleExt model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LayuiPage<ArticleExt> page(ArticleExt model, LayuiPageParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleExt queryArticleExtByarticleId(int id) {
		try {
			// TODO Auto-generated method stub
			ArticleExtExample articleExtExample = new ArticleExtExample();
			ArticleExtExample.Criteria c = articleExtExample.createCriteria();
			c.andArticleidEqualTo(id);
			
			List<ArticleExt> list = articleExtMapper.selectByExampleWithBLOBs(articleExtExample);
			
			if(!CollectionUtils.isEmpty(list)){
				return list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
