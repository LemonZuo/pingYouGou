package com.lemonzuo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LemonZuo
 * @create 2019-09-03 17:07
 * 商家
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller implements Serializable {
    private String sellerId;
    private String name;
    private String nickName;
    private String password;
    private String email;
    private String mobile;
    private String telephone;
    private String status;
    private String addressDetail;
    private String linkmanName;
    private String linkmanQq;
    private String linkmanMobile;
    private String linkmanEmail;
    private String licenseNumber;
    private String taxNumber;
    private String orgNumber;
    private Long address;
    private String logoPic;
    private String brief;
    private Date createTime;
    private String legalPerson;
    private String legalPersonCardId;
    private String bankUser;
    private String bankName;
    private String bankBranch;
}
