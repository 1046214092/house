package com.zcq.house.service;


import com.zcq.house.entity.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/7/24.
 */

public interface TestService  extends BaseService<Test> {
    public List<Test> getList();
}
