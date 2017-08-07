package com.zcq.house.service;


import com.zcq.house.entity.Test;
import com.zcq.house.entity.TestExample;

import java.util.List;

/**
 * Created by changqingzhou on 2017/7/24.
 */

public interface TestService  extends BaseService<Test,TestExample>  {
    public List<Test> getList();
}
