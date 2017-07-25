package com.zcq.house.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2017/7/24.
 */
@Controller
@RequestMapping("a")
public class AController {

    @RequestMapping("a")
    @ResponseBody
    public Map<String,Object> a(){

        return  new HashMap<>();
    }
}
