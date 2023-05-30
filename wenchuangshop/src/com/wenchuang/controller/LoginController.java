package com.wenchuang.controller;


import com.alibaba.fastjson.JSONObject;
import com.wenchuang.base.BaseController;
import com.wenchuang.po.*;
import com.wenchuang.service.*;
import com.wenchuang.utils.Consts;
import com.wenchuang.utils.MD5;
import com.wenchuang.utils.Pager;
import com.wenchuang.utils.WarningMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录相关的控制器
 * @Controller:声明为Controller
 * @RequestMapping:声明访问地址
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private ManageService manageService;

    @Autowired
    private ItemCategoryService itemCategoryService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private EventsService eventsService;


    /**
     * 管理员登录前
     * @return
     */
    @RequestMapping("login")
    public String login(){
        return "/login/mLogin";
    }

    /**
     * 登录验证
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(Manage manage, HttpServletRequest request){
       Manage byEntity = manageService.getByEntity(manage);
       if(byEntity==null){
           return "redirect:/login/mtuichu";
       }
       request.getSession().setAttribute(Consts.MANAGE,byEntity);
       return "/login/mIndex";
    }

    /**
     * 管理员退出
     */
    @RequestMapping("mtuichu")
    public String mtuichu(HttpServletRequest request){
        request.getSession().setAttribute(Consts.MANAGE,null);
        return "/login/mLogin";
    }

    /**
     * 前端首页
     */
    @RequestMapping("/uIndex_new")
    public String uIndex(Model model, Item item,HttpServletRequest request){
        String sql1 = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fatherList = itemCategoryService.listBySqlReturnEntity(sql1);
        List<CategoryDto> list = new ArrayList<>();
        if(!CollectionUtils.isEmpty(fatherList)){
            for(ItemCategory ic:fatherList){
                CategoryDto dto = new CategoryDto();
                dto.setFather(ic);
                //查询二级类目
                String sql2 = "select * from item_category where isDelete=0 and pid="+ic.getId();
                List<ItemCategory> childrens = itemCategoryService.listBySqlReturnEntity(sql2);
                dto.setChildrens(childrens);
                list.add(dto);
                model.addAttribute("lbs",list);
            }
        }

        //查询所有商品
        Pager<Item> pagers = itemService.findByEntity(item);
        model.addAttribute("pagers",  pagers);

        //查询一级类目
        String sqlf = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fList = itemCategoryService.listBySqlReturnEntity(sqlf);
        model.addAttribute("flst",fList);

        //折扣商品
        List<Item> zks = itemService.listBySqlReturnEntity("select * from item where isDelete=0 and zk is not null order by zk desc limit 0,10");
        model.addAttribute("zks",zks);

        //热销商品
        List<Item> rxs = itemService.listBySqlReturnEntity("select * from item where isDelete=0 order by gmNum desc,scNum desc limit 0,5");
        model.addAttribute("rxs",rxs);




        return "login/uIndex_new";
    }




    /**普通用户注册*/
    @RequestMapping("/res_new")
    public String res(){
        return "login/res_new";
    }

    /**执行普通用户注册*/
    @RequestMapping("/toRes_new")
    public String toRes(User u, HttpServletRequest request, Model model) {
        String checkSql1 = "select count(userName) from user where userName='"+u.getUserName()+"'";
        int count1 = userService.countBySql(checkSql1);
        if (count1>0){
            WarningMsg warningMsg = new WarningMsg("用户名已被占用，请重新输入！");
            request.getSession().setAttribute("role",1);
            request.getSession().setAttribute(Consts.WARNINGMSG,warningMsg.getMsg());
            return "redirect:/login/res_new.action";
        }
        else{
            u.setPwdNoSalt(u.getPassWord()); //先把未加密的密码放进去
            String md5=MD5.generate(u.getPassWord()); //加密
            u.setPwdSalt(md5);
            u.setPassWord(md5); //准备把加密密码放入数据库

            userService.insert(u);
            return "login/uLogin_new";
        }
    }



    /**普通用户登录入口*/
    @RequestMapping("/uLogin_new")
    public String uLogin(){
        return "login/uLogin_new";
    }

    /**执行普通用户登录*/
    @RequestMapping("/utoLogin")
    public String utoLogin(User u,HttpServletRequest request){
        //会话信息中存在的验证码
        String verifyCodeExpected=(String)request.getSession().getAttribute("verifyCode");
        //前端输入的验证码
        String inputVerifyCode= request.getParameter("inputVerifyCode");

        String sql = "select * from user where binary userName like '%"+u.getUserName()+"%'";
        User byEntity = userService.getBySqlReturnEntity(sql);
        if(byEntity!=null) {
            if(MD5.verify(u.getPassWord(),byEntity.getPassWord())) {
                if(inputVerifyCode ==null || !inputVerifyCode.equals(verifyCodeExpected)){

                    WarningMsg warningMsg2 = new WarningMsg("验证码不正确，请重新输入！");
                    request.getSession().setAttribute("role",1);
                    request.getSession().setAttribute(Consts.ERRORCAP,warningMsg2.getMsg());

                    return "redirect:/login/uLogin_new.action";
                }else {
                    request.getSession().setAttribute("role",2);
                    request.getSession().setAttribute(Consts.USERNAME,byEntity.getUserName());
                    request.getSession().setAttribute(Consts.USERID,byEntity.getId());
                    return "redirect:/login/uIndex_new.action";
                }

            }else {
                WarningMsg warningMsg1 = new WarningMsg("用户名或密码不正确，请重新输入！");
                request.getSession().setAttribute("role",1);
                request.getSession().setAttribute(Consts.WARNINGMSG,warningMsg1.getMsg());

                return "redirect:/login/uLogin_new.action";

            }
        }else {
            WarningMsg warningMsg1 = new WarningMsg("用户名或密码不正确，请重新输入！");
            request.getSession().setAttribute("role",1);
            request.getSession().setAttribute(Consts.WARNINGMSG,warningMsg1.getMsg());


            return "redirect:/login/uLogin_new.action";
        }
    }



    /**前端用户退出*/
    @RequestMapping("/uTui")
    public String uTui(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login/uIndex_new.action";
    }

    /**
     * 修改密码入口
     */
    @RequestMapping("/pass")
    public String pass(HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin_new";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        User load = userService.load(userId);
        request.setAttribute("obj",load);
        return "login/pass";
    }


    /**
     * 修改密码操作
     */
    @RequestMapping("/upass")
    @ResponseBody
    public String upass(String password,HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        JSONObject js = new JSONObject();
        if(attribute==null){
            js.put(Consts.RES,0);
            return js.toString();
        }
        Integer userId = Integer.valueOf(attribute.toString());
        User load = userService.load(userId);

        load.setPwdNoSalt(password);//先把未加密的密码放进去

        String md5=MD5.generate(password); //加密
        load.setPwdSalt(md5);
        load.setPassWord(md5); //准备把加密密码放入数据库

        userService.updateById(load);
        js.put(Consts.RES,1);
        return js.toString();



    }


}
