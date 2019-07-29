package com.yjg.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/27
 *  @Description: 前端页面显示的客户字段
 */
public class CustomerVO {
    /**
     * 客户的姓
     */
    private String lastName;
    /**
     * 客户的名
     */
    private String firstName;
    /**
     * 客户的地址
     */
    private String address;
    /**
     * 客户的邮箱
     */
    private String email;
    /**
     * 客户的Id
     */
    private Short customerId;
    /**
     * 信息更新最晚时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Short customerId) {
        this.customerId = customerId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "CustomerVO{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", customerId=" + customerId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
