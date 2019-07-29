package com.yjg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjg.mapper.CustomerMapper;
import com.yjg.service.CustomerService;
import com.yjg.vo.AddressListVO;
import com.yjg.vo.CustomerVO;
import com.yjg.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/27
 *  @Description: 处理对客户信息操作的业务层实现类
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    /**
     * 注入CustomerMapper
     */
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Result selectAllCustomInfo(Integer page, Integer limit) {
        Result result = new Result();
        PageHelper.startPage(page, limit);
        //查询所有的客户的信息
        List<CustomerVO> allCustomers = customerMapper.findAllCustomers();
        //进行分页处理
        PageInfo<CustomerVO> pageInfo = new PageInfo<>(allCustomers);
        result.setData(allCustomers);
        result.setTotalPages(pageInfo.getPages());
        return result;
    }

    @Override
    public int deleteCustomerById(int customerId) {
        int i = customerMapper.deleteByPrimaryKey((short) customerId);
        return i;
    }

    @Override
    public List<AddressListVO> selectAddressList() {
        List<AddressListVO> all = customerMapper.selectAddressList();
        return all;
    }

    @Override
    public int updateCustomerById(CustomerVO customerVO) {
        int num = 0;
        try{
            customerMapper.updateCustomerById(customerVO);
            num = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int addCustomer(CustomerVO customerVO) {

        int msg = 0;
        try{
            customerMapper.addCustomer(customerVO);
            msg = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return msg;
    }
}
