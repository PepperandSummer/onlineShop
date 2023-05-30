package com.wenchuang.controller;

import com.wenchuang.po.OrderDetail;
import com.wenchuang.service.OrderDetailService;
import com.wenchuang.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 订单详情c层
 */
@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping("/ulist")
    public String ulist(OrderDetail orderDetail, Model model){
        //分页查询
        String sql = "select * from order_detail  where order_id="+orderDetail.getOrderId();
        Pager<OrderDetail> pagers = orderDetailService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",orderDetail);
        return "orderDetail/ulist";
    }


    /**
     *后台手动退货
     */
    @RequestMapping("/sdth")
    public String sdth(Integer id, Integer orderId, Model model) {
        String sql="select * from order_detail where item_id="+id+" and order_id = "+orderId;
        List<OrderDetail> od = orderDetailService.listBySqlReturnEntity(sql);
        for(OrderDetail orderDetail:od){
            orderDetail.setStatus(1);
            orderDetailService.updateById(orderDetail);
        }
        return "redirect:/orderDetail/ulist";
    }
}
