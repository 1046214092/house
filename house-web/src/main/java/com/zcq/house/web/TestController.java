package com.zcq.house.web;

import com.zcq.house.dao.entity.Test;
import com.zcq.house.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2017/7/24.
 */
@RestController
@RequestMapping("a")
public class TestController {
    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;

    @RequestMapping("a/{id}")
    @ResponseBody
    public List<Test> a(@PathVariable String id){
        logger.error(id);
        List<Test> list = testService.getList();
        logger.error("size:{},{}",list.size(),list);
        return  list;
    }



    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}
