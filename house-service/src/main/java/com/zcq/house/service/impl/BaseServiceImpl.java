package com.zcq.house.service.impl;

import com.github.pagehelper.Page;
import com.zcq.house.service.BaseService;
import org.apache.commons.beanutils.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/7/25.
 */
public class BaseServiceImpl <T> implements BaseService<T> {
    public Logger logger = LoggerFactory.getLogger(this.getClass());
    public Page<T> findPage(T t)  {
        Object invoke= getMapper(t);

        Method selectByExample=null;
        try {
            Object selectByExample1 = MethodUtils.invokeExactMethod(invoke, "selectByExample", t);


        }catch (Exception e){
            e.printStackTrace();
        }




        Page p=new Page();
        return p;
    }

    private Object getMapper(T t) {
        Object invoke = null;
        try {
            Type genericSuperclass = this.getClass().getGenericSuperclass();
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            Class actualTypeArgument = (Class) (actualTypeArguments[0]);

            String name = actualTypeArgument.getSimpleName();

            name = name.substring(0, 1).toLowerCase() + name.substring(1);
            PropertyDescriptor propertyDescriptor=new PropertyDescriptor(name + "Mapper",this.getClass());
            Method readMethod = propertyDescriptor.getReadMethod();
            invoke = readMethod.invoke(this);
        }catch (Exception e){

        }

        return invoke ;
    }
}
