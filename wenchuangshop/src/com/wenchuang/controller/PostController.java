package com.wenchuang.controller;

import com.wenchuang.base.BaseController;
import com.wenchuang.po.Events;
import com.wenchuang.po.ItemCategory;
import com.wenchuang.po.Post;
import com.wenchuang.service.EventsService;
import com.wenchuang.service.ItemCategoryService;
import com.wenchuang.service.PostService;
import com.wenchuang.utils.Consts;
import com.wenchuang.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 发布作品管理
 */
@Controller
@RequestMapping("/post")
public class PostController extends BaseController {
    @Autowired
    private PostService postService;

    @Autowired
    private ItemCategoryService itemCategoryService;

    @Autowired
    private EventsService eventsService;


    /**
     * 前台根据活动id查看作品列表
     */
    @RequestMapping("/list")
    public String list(Integer id,Post post, Model model){
        //分页查询
        String sql = "select * from post where events_id="+id+ " and isDelete=0 and reviewStatus=1 and status=1";
        Pager<Post> pagers = postService.findBySqlRerturnEntity(sql);

        model.addAttribute("pagers",pagers);

        Events events = eventsService.load(id);
        model.addAttribute("events",events);

        //导航查询一级类目
        String sqlf = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fList = itemCategoryService.listBySqlReturnEntity(sqlf);
        model.addAttribute("flst",fList);
        return "post/list";
    }




    /**
     * 查看作品列表 后台
     */
    @RequestMapping("/findBySql")
    public String findBySql(Post post,Model model){
        //分页查询
        String sql = "select * from post,user where 1=1 and user.user_id=post.user_id";
        if(!isEmpty(post.getName())){
            sql += " and name like '%"+post.getName()+"%'";
        }
        sql += " and isDelete = 0 order by reviewStatus asc";
        Pager<Post> pagers = postService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",post);
        return "post/post";
    }


    /**
     * 我的作品
     */
    @RequestMapping("/my")
    public String my(Model model, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin_new";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        //全部订单
        String sql = "select * from post where user_id="+userId+" and isDelete=0 order by post_id desc";
        List<Post> all = postService.listBySqlReturnEntity(sql);
        //待发布(未审核) status= 0 and reviewStatus= 0
        String sql2 = "select * from post where user_id="+userId+" and status= 0 and reviewStatus= 0 and isDelete=0 order by post_id desc";
        List<Post> dfbwsh = postService.listBySqlReturnEntity(sql2);

        //待发布（已审核）status= 0 and reviewStatus= 1
        String sql3 = "select * from post where user_id="+userId+" and status=0 and reviewStatus=1 and isDelete=0 order by post_id desc";
        List<Post> dfbysh = postService.listBySqlReturnEntity(sql3);
        //已发布 status=1 and reviewStatus=1
        String sql4 = "select * from post where user_id="+userId+" and status=1 and reviewStatus=1 and isDelete=0 order by post_id desc";
        List<Post> yfb = postService.listBySqlReturnEntity(sql4);
        //活动结束 status=2
        String sql5 = "select * from post where user_id="+userId+" and status=2 and isDelete=0 order by post_id desc";
        List<Post> hdjs = postService.listBySqlReturnEntity(sql5);

        model.addAttribute("all",all);
        model.addAttribute("dfbwsh",dfbwsh);
        model.addAttribute("dfbysh",dfbysh);
        model.addAttribute("yfb",yfb);
        model.addAttribute("hdjs",hdjs);

        //导航查询一级类目
        String sqlf = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fList = itemCategoryService.listBySqlReturnEntity(sqlf);
        model.addAttribute("flst",fList);

        return "post/my";
    }

    /**
     * 用户发布作品
     */
    @RequestMapping("/fb")
    public String fb(Integer id, Model model) {
        Post obj = postService.load(id);
        obj.setStatus(1);
        postService.updateById(obj);
        model.addAttribute("obj",obj);
        return "redirect:/post/my";
    }

    /**
     * 前台用户查看作品详情
     */
    @RequestMapping("/detail")
    public String detail(Integer id, Model model){
        String sql1 = "select * from post where isDelete=0 and post_id="+id;
        Post obj = postService.getBySqlReturnEntity(sql1);
        model.addAttribute("obj",obj);

        Events events = eventsService.load(obj.getEventsId());
        model.addAttribute("events",events);

        //上方导航菜单
        String sqlf = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fList = itemCategoryService.listBySqlReturnEntity(sqlf);
        model.addAttribute("flst",fList);

        return "post/detail";
    }

    /**
     * 跳转到添加页面
     */
    @RequestMapping("/add")
    public String add(Model model, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin_new";
        }
        String sql = "select * from events order by events_id";
        List<Events> listBySqlReturnEntity = eventsService.listBySqlReturnEntity(sql);
        model.addAttribute("events",listBySqlReturnEntity);


        //导航查询一级类目
        String sqlf = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fList = itemCategoryService.listBySqlReturnEntity(sqlf);
        model.addAttribute("flst",fList);
        return "post/add";
    }

    /**
     * 添加执行
     */
    @RequestMapping("/exAdd")
    public String exAdd(Post post, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin_new";
        }
        post.setUserId(Integer.valueOf(attribute.toString()));
        post.setAddTime(new Date());
        post.setStatus(0);
        post.setReviewStatus(0);
        post.setIsDelete(0);
        postService.insert(post);
        return "redirect:/post/my.action";
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping("/update")
    public String update(Integer id,Model model){
        Post obj = postService.load(id);
        String sql = "select * from events order by events_id";
        List<Events> listBySqlReturnEntity = eventsService.listBySqlReturnEntity(sql);
        model.addAttribute("events",listBySqlReturnEntity);
        model.addAttribute("obj",obj);

        //导航查询一级类目
        String sqlf = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fList = itemCategoryService.listBySqlReturnEntity(sqlf);
        model.addAttribute("flst",fList);
        return "post/update";
    }

    /**
     * 修改执行
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(Post post){
        post.setIsDelete(0);
        postService.updateById(post);
        return "redirect:/post/my";
    }

    /**
     * 删除作品 前台
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        postService.deleteById(id);
        return "redirect:/post/my";
    }

    /**
     * 修改作品状态 后台 活动结束
     *
     */
    @RequestMapping("/mhdjs")
    public String mhdjs(Integer id, Model model){
        Post obj = postService.load(id);
        obj.setStatus(2);
        postService.updateById(obj);
        model.addAttribute("obj",obj);
        return "redirect:/post/findBySql";
    }

    /**
     *修改作品状态 未通过审核删除
     */
    @RequestMapping("/mdelete")
    public String mdelete(Integer id){
        Post obj = postService.load(id);
        obj.setIsDelete(1);
        postService.updateById(obj);
        return "redirect:/post/findBySql.action";
    }

    /**
     * 修改作品状态 通过审核 用户待发布
     *
     */
    @RequestMapping("/msh")
    public String msh(Integer id, Model model){
        Post obj = postService.load(id);
        obj.setStatus(0);
        obj.setReviewStatus(1);
        postService.updateById(obj);
        model.addAttribute("obj",obj);
        return "redirect:/post/findBySql.action";
    }

    /**
     * 后台审核作品时查看作品详情
     */
    @RequestMapping("view")
    public String view(Integer id, Model model){

        String sql1 = "select * from post where isDelete=0 and post_id="+id;
        Post obj = postService.getBySqlReturnEntity(sql1);
        model.addAttribute("obj",obj);

        String sql = "select * from events order by events_id";
        List<Events> listBySqlReturnEntity = eventsService.listBySqlReturnEntity(sql);
        model.addAttribute("events",listBySqlReturnEntity);
        return "post/view";
    }

}
