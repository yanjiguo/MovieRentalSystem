package com.yjg.service.impl;

import com.yjg.mapper.CustomerMapper;
import com.yjg.pojo.Customer;
import com.yjg.pojo.CustomerExample;
import com.yjg.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/27
 *  @Description: 处理对客户登录的实现类
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int selectCustomerByName(String username) {
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        criteria.andFirstNameEqualTo(username);
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        if(customers.size()>0){
            //登录成功
            return 1;
        }else{
            //登录失败
            return 0;
        }
    }
}
