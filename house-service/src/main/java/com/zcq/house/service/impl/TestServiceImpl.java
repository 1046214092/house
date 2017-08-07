package com.zcq.house.service.impl;

import com.zcq.house.entity.Test;
import com.zcq.house.entity.TestExample;
import com.zcq.house.mapper.TestMapper;
import com.zcq.house.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/25.
 */
@Service
public class TestServiceImpl  extends BaseServiceImpl  <Test,TestExample>  implements TestService {

    @Autowired
    private TestMapper testMapper;


    public List<Test> getList(){
 //        findPage(new TestExample(),1,100);
        return  testMapper.selectByExample(new TestExample());
    }







    public TestMapper getTestMapper() {
        return testMapper;
    }

    public void setTestMapper(TestMapper testMapper) {
        this.testMapper = testMapper;
    }
}
