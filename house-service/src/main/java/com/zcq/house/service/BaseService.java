package com.zcq.house.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.MethodUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */
public   interface BaseService<T> {

    public Page<T> findPage(T t);


}
