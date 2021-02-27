package com.lemonzuo.manager.controller;

import com.lemonzuo.model.PageResult;
import com.lemonzuo.model.ResponseMessage;
import com.lemonzuo.model.Seller;
import com.lemonzuo.sellergoods.service.SellerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LemonZuo
 * @create 2019-09-04 15:49
 */
@RestController
@RequestMapping("/seller")
public class SellerController {
    @Reference
    private SellerService sellerService;

    /**
     * 商家信息分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/findPage.do")
    public PageResult<Seller> findPage(Integer pageNum, Integer pageSize) {
        Seller seller = new Seller();
        seller.setStatus("0");
        PageResult<Seller> pageResult = sellerService.findSellerInfo(seller, pageNum, pageSize);
        return pageResult;
    }

    /**
     * 查询商家信息
     *
     * @param sellerId
     * @return
     */
    @GetMapping("/findSellerDetialInfo.do")
    public Seller findSellerDetialInfo(String sellerId) {
        return sellerService.findSellerDetialInfo(sellerId);
    }

    @PutMapping("/sellerInfo.do/sellerId/{sellerId}/status/{status}")
    public ResponseMessage sellerInfo(@PathVariable("sellerId") String sellerId,
                                      @PathVariable("status") String status,
                                      ResponseMessage responseMessage) {
        Seller checkExist = sellerService.findSellerDetialInfo(sellerId);
        if (ObjectUtils.isEmpty(checkExist)) {
            responseMessage.setResponseStatus(false);
            responseMessage.setResponseMessageInfo("商家不存在");
            return responseMessage;
        }
        Seller seller = new Seller();
        seller.setStatus(status);
        seller.setSellerId(sellerId);
        Integer updateSellerRes = sellerService.updateSeller(seller);
        if (updateSellerRes != 1) {
            // 操作失败
            responseMessage.setResponseStatus(false);
            responseMessage.setResponseMessageInfo("操作失败");
            return responseMessage;
        }
        responseMessage.setResponseStatus(true);
        responseMessage.setResponseMessageInfo("操作成功");
        return responseMessage;
    }

}
