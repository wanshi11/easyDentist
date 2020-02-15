package com.dentist.mapper;

import com.dentist.entity.Policlinic;
import com.dentist.entity.PoliclinicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoliclinicMapper {
    int countByExample(PoliclinicExample example);

    int deleteByExample(PoliclinicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Policlinic record);

    int insertSelective(Policlinic record);

    List<Policlinic> selectByExample(PoliclinicExample example);

    Policlinic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Policlinic record, @Param("example") PoliclinicExample example);

    int updateByExample(@Param("record") Policlinic record, @Param("example") PoliclinicExample example);

    int updateByPrimaryKeySelective(Policlinic record);

    int updateByPrimaryKey(Policlinic record);
}