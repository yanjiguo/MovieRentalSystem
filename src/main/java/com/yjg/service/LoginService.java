package com.yjg.service;

import org.springframework.stereotype.Service;
/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/27
 *  @Description: 处理对登录用户的业务处理接口
 */
@Service
public interface LoginService {
    /**
     * 通过客户名称查询客户信息
     * @param username
     * @return
     */
    int selectCustomerByName(String username);
}
