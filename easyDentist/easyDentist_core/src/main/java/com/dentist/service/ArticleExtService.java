package com.dentist.service;

import com.dentist.entity.ArticleExt;

public interface ArticleExtService  extends IBaseService<ArticleExt>{

	ArticleExt queryArticleExtByarticleId(int id);

}
