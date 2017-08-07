package com.zcq.house.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.zcq.house.entity.Test;
import com.zcq.house.entity.TestExample;
import com.zcq.house.service.TestService;
import com.zcq.house.util.WebResult;
import com.zcq.house.vo.TestVo1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by changqingzhou on 2017/7/24.
 */
@RestController
@RequestMapping("a")
public class TestController {
    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;

    @RequestMapping("a/{id}")
    @ResponseBody
    public List<Test> a(@PathVariable String id) {
        logger.error(id);
        List<Test> list = testService.getList();
        logger.error("size:{},{}", list.size(), list);
        return list;
    }

    @RequestMapping(value = "b", method = RequestMethod.POST)
    @ResponseBody
    public TestVo1 a(@RequestBody TestVo1 testVo1, HttpServletRequest request) {
        try {
            logger.debug(new ObjectMapper().writeValueAsString(testVo1));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return testVo1;
    }


    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public WebResult save(@RequestBody Test test){
        WebResult result=new WebResult();
        int insert = testService.insert(test);
        result.setResult(insert);
        return  result;
    }


    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public PageInfo page(@RequestBody Test test) throws InvocationTargetException, IllegalAccessException {
        WebResult result=new WebResult();
        TestExample testExample = new TestExample();
        testExample.createCriteria().andIdEqualTo(test.getId());
        PageInfo<Test> page = testService.findPage(testExample, 1, 10);
         return  page;
    }

    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}
