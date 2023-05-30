package com.wenchuang.controller;

import com.alibaba.fastjson.JSONObject;
import com.wenchuang.base.BaseController;
import com.wenchuang.po.ItemCategory;
import com.wenchuang.po.Message;
import com.wenchuang.po.User;
import com.wenchuang.service.ItemCategoryService;
import com.wenchuang.service.MessageService;
import com.wenchuang.service.UserService;
import com.wenchuang.utils.Consts;
import com.wenchuang.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 留言管理
 */
@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ItemCategoryService itemCategoryService;

    @Autowired
    private UserService userService;

    /**
     * 留言列表
     */
    @RequestMapping("/findBySql")
    public String findBySql(Message message, Model model){
        String sql = "select * from message where 1=1 ";
        if(!isEmpty(message.getContent())){
            sql += " and content like '%"+message.getContent()+"%'";
        }
        sql += " order by msg_id desc";
        Pager<Message> pagers = messageService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",message);
        return "message/message";
    }

    /**
     * 删除留言
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        messageService.deleteById(id);
        return "redirect:/message/findBySql";
    }

    /**
     * 发表留言进入
     */
    @RequestMapping("/add")
    public String add(Model model, HttpServletRequest request){

        Object attribute = request.getSession().getAttribute(Consts.USERID);
        JSONObject js = new JSONObject();
        if(attribute!=null){
            Integer userId = Integer.valueOf(attribute.toString());
            User user = userService.load(userId);
            if(user.getPhone() != null){
                model.addAttribute("user",user);
            }
        }else{
            User user=new User();
            model.addAttribute("user",user);
        }



        //查询一级类目
        String sqlf = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fList = itemCategoryService.listBySqlReturnEntity(sqlf);
        model.addAttribute("flst",fList);

        return "message/add";
    }

    /**
     * 发表留言
     */
    @RequestMapping("/exAdd")
    @ResponseBody
    public String exAdd(Message message,  HttpServletRequest request){

        String mess = message.getContent();
        String[] contentList = {"sm","SM","SB","sb","sx","SX","傻逼","cnm","草泥马","CNM","共产党","zf","小日本","鬼子","qnmd","去你妈的","贱","艹"};
        for (int i=0; i< contentList.length;i++) {
            mess = mess.replace(contentList[i], "**");
        }
        message.setContent(mess);

        /*String content = request.getParameter("content").trim();

        if (content != null) {
            SensitiveWordsUtil.init();
            boolean flag = SensitiveWordsUtil.contains(content);
            if (flag) {
                String replaceContent = SensitiveWordsUtil.replaceSensitiveWord(content, "**");
            }
        }
         */
        messageService.insert(message);
        JSONObject js = new JSONObject();
        js.put("message","添加成功");
        return js.toString();
    }

}
