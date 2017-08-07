package com.zcq.house.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcq.house.dao.BaseDao;
import com.zcq.house.entity.Test;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.ibatis.annotations.Param;

import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.util.List;

/**
 * Created by changqingzhou on 2017/7/25.
 */
public   interface BaseService<Entity,Example> {

    public PageInfo<Entity> findPage(Example t, Integer start, Integer limit);

    long countByExample(Example example);

    int deleteByExample(Example example);

    int insert(Entity record);

    int insertSelective(Test record);

    List<Entity> selectByExample(Example example);

    int updateByExampleSelective( Entity record,Example example);

    int updateByExample(Entity record,  Example example);
}
