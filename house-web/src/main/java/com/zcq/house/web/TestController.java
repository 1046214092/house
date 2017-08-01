package com.zcq.house.web;

 import com.fasterxml.jackson.core.JsonProcessingException;
 import com.fasterxml.jackson.databind.ObjectMapper;
 import com.zcq.house.entity.Test;
 import com.zcq.house.service.TestService;
 import com.zcq.house.service.impl.TestServiceImpl;
 import com.zcq.house.vo.TestVo1;
 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.*;
  import javax.servlet.http.HttpServletRequest;
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
    private TestServiceImpl testService;

    @RequestMapping("a/{id}")
    @ResponseBody
    public List<Test> a(@PathVariable String id){
        logger.error(id);
        List<Test> list = testService.getList();
        logger.error("size:{},{}",list.size(),list);
        return  list;
    }

    @RequestMapping(value = "b",method = RequestMethod.POST)
    @ResponseBody
    public  TestVo1 a(@RequestBody TestVo1 testVo1,HttpServletRequest request){
        try {
            logger.debug(new ObjectMapper().writeValueAsString(testVo1));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  testVo1;
    }

    public TestServiceImpl getTestService() {
        return testService;
    }

    public void setTestService(TestServiceImpl testService) {
        this.testService = testService;
    }
}
