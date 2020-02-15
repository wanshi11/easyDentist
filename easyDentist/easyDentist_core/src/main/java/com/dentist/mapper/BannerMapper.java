package com.dentist.mapper;

import com.dentist.entity.Banner;
import com.dentist.entity.BannerExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BannerMapper {
    int countByExample(BannerExample example);

    int deleteByExample(BannerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    List<Banner> selectByExampleWithBLOBs(BannerExample example);

    List<Banner> selectByExample(BannerExample example);

    Banner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExampleWithBLOBs(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKeyWithBLOBs(Banner record);

    int updateByPrimaryKey(Banner record);
    
    List<Banner> selectWithPageByExample(@Param("example") BannerExample example,@Param("params") Map<String, String> params);

  	List<Banner> selectByExampleLimit6(BannerExample bannerExample);
  	
  	int insertAndGetId(Banner record);
}