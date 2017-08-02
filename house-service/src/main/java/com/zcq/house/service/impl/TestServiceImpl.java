package com.zcq.house.service.impl;

import com.github.pagehelper.PageHelper;

import com.zcq.house.entity.Test;
import com.zcq.house.entity.TestExample;
import com.zcq.house.mapper.TestMapper;
import com.zcq.house.service.TestService;
import com.zcq.house.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */
@Service
public class TestServiceImpl  extends BaseServiceImpl  <Test,TestExample>  implements TestService {

    @Autowired
    private TestMapper testMapper;


    public List<Test> getList(){
        PageHelper.startPage(1,200);
        findPage(new TestExample());
        return  testMapper.selectByExample(new TestExample());
    }






    public TestMapper getTestMapper() {
        return testMapper;
    }

    public void setTestMapper(TestMapper testMapper) {
        this.testMapper = testMapper;
    }
}
