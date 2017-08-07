package com.zcq.house.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by changqingzhou on 2017/8/2.
 */
@Controller
@RequestMapping("ft")
public class FreemarkerTestController {

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("views/ft");
        modelAndView.addObject("message","12132");
        return modelAndView ;
    }
}
