package com.wenchuang.controller;

import com.wenchuang.base.BaseController;
import com.wenchuang.po.ItemCategory;
import com.wenchuang.po.User;
import com.wenchuang.service.ItemCategoryService;
import com.wenchuang.service.UserService;
import com.wenchuang.utils.Consts;
import com.wenchuang.utils.MD5;
import com.wenchuang.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户c层
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private ItemCategoryService itemCategoryService;

    @RequestMapping("/findBySql")
    public String findBySql(Model model,User user){
        String sql = "select * from user where 1=1 ";
        if(!isEmpty(user.getUserName())){
            sql += " and userName like '%"+user.getUserName()+"%' ";
        }
        sql+=" order by user_id";
        Pager<User> pagers = userService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",user);
        return "user/user";
    }

    /**
     * 查看用户信息
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/view_new")
    public String view(Model model, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin_new";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        User obj = userService.load(userId);
        model.addAttribute("obj",obj);

        //查询一级类目
        String sqlf = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fList = itemCategoryService.listBySqlReturnEntity(sqlf);
        model.addAttribute("flst",fList);

        return "user/view_new";
    }

    /**
     * 转向到新增用户页面
     */
    @RequestMapping(value = "/add")
    public String add(){
        return "user/add";
    }

    /**
     * 新增用户保存功能
     */
    @RequestMapping("/exAdd")
    public String exAdd(User user){
        //List<ItemCategory> listBySqlReturnEntity = itemCategoryService.listBySqlReturnEntity("SELECT * FROM item_category WHERE isDelete =0 and name="+itemCategory.getName());
        //if (!CollectionUtils.isEmpty(listBySqlReturnEntity)){
        userService.insert(user);
        //}
        return "redirect:/user/findBySql.action";
    }


    /**
     * 转向到修改用户页面
     */
    @RequestMapping(value = "/update")
    public String update(Integer id,Model model){
        User obj = userService.load(id);
        model.addAttribute("obj",obj);
        return "user/update";
    }



    /**
     * 用户执行修改用户信息的操作
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(User user,HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin_new";
        }
        user.setId(Integer.valueOf(attribute.toString()));
        userService.updateById(user);
        return "redirect:/user/view_new.action";
    }

    /**
     * 管理员执行修改用户信息的操作
     */
    @RequestMapping("/mexUpdate")
    public String mexUpdate(User user){

        String password = user.getPassWord();

        user.setPwdNoSalt(password);//先把未加密的密码放进去

        String md5= MD5.generate(password); //加密
        user.setPwdSalt(md5);
        user.setPassWord(md5); //准备把加密密码放入数据库

        userService.updateById(user);
        return "redirect:/user/findBySql.action";
    }




    /**
     * 删除用户
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        userService.deleteById(id);
        return "redirect:/user/findBySql";
    }



}
