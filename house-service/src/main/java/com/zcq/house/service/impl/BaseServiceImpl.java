package com.zcq.house.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcq.house.dao.BaseDao;
import com.zcq.house.entity.Test;
import com.zcq.house.entity.TestExample;
import com.zcq.house.service.BaseService;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */
public class BaseServiceImpl <Entity,Example> implements BaseService<Entity,Example> {

    public Logger logger = LoggerFactory.getLogger(this.getClass());
    public PageInfo<Entity> findPage(Example t,Integer start,Integer limit)  {
            PageHelper.startPage(start,limit);
            List list = getMapper().selectByExample(t);
            PageInfo<Entity> p=new PageInfo<Entity>(list);
            logger.error("size{}",list.size());
        return p;
    }



   public long countByExample(Example example){
       return  getMapper().countByExample(example);
   }

    public  int deleteByExample(Example example){
        return  getMapper().deleteByExample(example);
    }

    @Transactional(readOnly = false)
  public   int insert(Entity record){
      return  getMapper().insert(record);
  }
    @Transactional(readOnly = false)
    public  int insertSelective(Test record){
        return  getMapper().insert(record);
    }
    @Transactional(readOnly = false)
   public List<Entity> selectByExample(Example example){
       return  getMapper().selectByExample(example);
   }
    @Transactional(readOnly = false)
   public int updateByExampleSelective( Entity record, Example example){
       return  getMapper().updateByExampleSelective(record,example);
   }

   public int updateByExample( Entity record, Example example){
       return  updateByExample(record,example);
   }


    private BaseDao getMapper() {
        Object invoke = null;
        try {
            Type genericSuperclass = this.getClass().getGenericSuperclass();
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            Class actualTypeArgument = (Class) (actualTypeArguments[0]);

            String name = actualTypeArgument.getSimpleName();

            name = name.substring(0, 1).toLowerCase() + name.substring(1);

            PropertyDescriptor propertyDescriptor=new PropertyDescriptor(name.replace("Example","") + "Mapper",this.getClass());
            Method readMethod = propertyDescriptor.getReadMethod();
            invoke = readMethod.invoke(this);
        }catch (Exception e){

        }

        return (BaseDao) invoke;
    }


}
