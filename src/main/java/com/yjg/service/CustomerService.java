package com.yjg.service;

import com.yjg.vo.AddressListVO;
import com.yjg.vo.CustomerVO;
import com.yjg.vo.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/27
 *  @Description: 处理对客户信息操作业务层接口
 */
@Service
public interface CustomerService {
    /**
     * 查找所有的客户的信息
     * @param page
     * @param limit
     * @return
     */
    Result selectAllCustomInfo(Integer page, Integer limit);

    /**
     * 删除客户信息
     * @param customerId
     * @return
     */
    int deleteCustomerById(int customerId);

    /**
     *查询所有的地址信息
     * @return
     */
    List<AddressListVO> selectAddressList();

    /**
     * 通过客户的id来更新
     * @param customerVO
     * @return
     */
    int updateCustomerById(CustomerVO customerVO);

    /**
     * 添加一个客户信息
     * @param customerVO
     * @return
     */
    int addCustomer(CustomerVO customerVO);
}

