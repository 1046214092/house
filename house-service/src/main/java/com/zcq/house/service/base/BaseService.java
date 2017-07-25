package com.zcq.house.service.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */
public   class BaseService<T> {

    public Page<T> findPage(T t)  {
        Object invoke= getMapper(t);

        Method selectByExample=null;
        try {
            selectByExample = invoke.getClass().getMethod("selectByExample");
            Object invoke1 = selectByExample.invoke(invoke, t);

            System.out.println(invoke);
        }catch (Exception e){

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
