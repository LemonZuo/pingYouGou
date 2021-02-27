package com.lemonzuo.mapper;

import com.lemonzuo.model.Addres;
import com.lemonzuo.model.AddresExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddresMapper {
    long countByExample(AddresExample example);

    int deleteByExample(AddresExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Addres record);

    int insertSelective(Addres record);

    List<Addres> selectByExample(AddresExample example);

    Addres selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Addres record, @Param("example") AddresExample example);

    int updateByExample(@Param("record") Addres record, @Param("example") AddresExample example);

    int updateByPrimaryKeySelective(Addres record);

    int updateByPrimaryKey(Addres record);
}