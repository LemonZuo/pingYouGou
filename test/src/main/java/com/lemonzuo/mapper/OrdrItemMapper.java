package com.lemonzuo.mapper;

import com.lemonzuo.model.OrdrItem;
import com.lemonzuo.model.OrdrItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdrItemMapper {
    long countByExample(OrdrItemExample example);

    int deleteByExample(OrdrItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrdrItem record);

    int insertSelective(OrdrItem record);

    List<OrdrItem> selectByExample(OrdrItemExample example);

    OrdrItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrdrItem record, @Param("example") OrdrItemExample example);

    int updateByExample(@Param("record") OrdrItem record, @Param("example") OrdrItemExample example);

    int updateByPrimaryKeySelective(OrdrItem record);

    int updateByPrimaryKey(OrdrItem record);
}