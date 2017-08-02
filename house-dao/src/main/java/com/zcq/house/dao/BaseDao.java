package com.zcq.house.dao;

import com.zcq.house.entity.Test;
import com.zcq.house.entity.TestExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */
public interface BaseDao<Example,Entity> {
    long countByExample(Example example);

    int deleteByExample(Example example);

    int insert(Entity record);

    int insertSelective(Test record);

    List<Entity> selectByExample(Example example);

    int updateByExampleSelective(@Param("record") Entity record, @Param("example") Example example);

    int updateByExample(@Param("record") Entity record, @Param("example") Example example);
}
