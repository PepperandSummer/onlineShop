package com.wenchuang.controller;

import com.wenchuang.base.BaseController;
import com.wenchuang.po.Comment;
import com.wenchuang.po.OrderDetail;
import com.wenchuang.service.CommentService;
import com.wenchuang.service.ItemOrderService;
import com.wenchuang.service.OrderDetailService;
import com.wenchuang.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 评论
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ItemOrderService itemOrderService;

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 添加执行
     */
    @RequestMapping("/exAdd")
    public String exAdd(Comment comment, Integer orderId, HttpServletRequest request, Model model){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin_new";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        comment.setAddTime(new Date());
        comment.setUserId(userId);

        //过滤敏感字符
        String cmt = comment.getContent();
        String[] contentList = {"sm","SM","SB","sb","sx","SX","傻逼","cnm","草泥马","CNM","共产党","zf","小日本","鬼子","qnmd","去你妈的","贱","艹"};
        for (int i=0; i< contentList.length;i++) {
            cmt = cmt.replace(contentList[i], "**");
        }
        comment.setContent(cmt);

        //插入评价
        commentService.insert(comment);
        model.addAttribute("content",comment);

        String sql = "select * from order_detail where order_id ="+ orderId + " and item_id="+ comment.getItemId();
        OrderDetail od = orderDetailService.getBySqlReturnEntity(sql);

        od.setStatus(2);//已评价
        orderDetailService.updateById(od);

        return "redirect:/itemOrder/my";
    }

}
