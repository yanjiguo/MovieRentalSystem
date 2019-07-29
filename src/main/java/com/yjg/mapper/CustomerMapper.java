package com.yjg.mapper;

import com.yjg.pojo.Customer;
import com.yjg.pojo.CustomerExample;
import java.util.List;

import com.yjg.vo.AddressListVO;
import com.yjg.vo.CustomerVO;
import org.apache.ibatis.annotations.Param;
/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/27
 *  @Description: 操作数据库中customer表的接口
 */
public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Short customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Short customerId);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    /**
     * @return  查询客户的信息
     */
    List<CustomerVO> findAllCustomers();

    /**
     *
     * @return 查询 AddressList的值
     */
    List<AddressListVO> selectAddressList();

    /**
     *
     * @return
     */
    void updateCustomerById(CustomerVO customerVO);

    /**
     *
     * @param customerVO
     */
    void addCustomer(CustomerVO customerVO);
}