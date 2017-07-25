package com.zcq.house.service;

import com.zcq.house.dao.entity.Test;
import com.zcq.house.dao.entity.TestExample;
import com.zcq.house.dao.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/24.
 */
@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;


    public List<Test> getList(){
        return  testMapper.selectByExample(new TestExample());
    }

    public TestMapper getTestMapper() {
        return testMapper;
    }

    public void setTestMapper(TestMapper testMapper) {
        this.testMapper = testMapper;
    }
}
