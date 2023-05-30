package com.wenchuang.controller;

import com.wenchuang.base.BaseController;
import com.wenchuang.po.Events;
import com.wenchuang.po.ItemCategory;
import com.wenchuang.po.Post;
import com.wenchuang.service.EventsService;
import com.wenchuang.service.ItemCategoryService;
import com.wenchuang.service.PostService;
import com.wenchuang.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;


/**
 * 活动管理
 */
@Controller
@RequestMapping("/events")
public class EventsController extends BaseController {

    @Autowired
    private EventsService eventsService;

    @Autowired
    private ItemCategoryService itemCategoryService;


    @Autowired
    private PostService postService;
    /**
     * 活动列表 后台
     * @param events
     * @param model
     * @return
     */
    @RequestMapping("/findBySql")
    public String findBySql(Events events, Model model){
        String sql = "select * from events where 1=1 ";
        if(!isEmpty(events.getName())){
            sql += " and name like '%"+events.getName()+"%'";
        }
        sql += " order by events_id desc";
        Pager<Events> pagers = eventsService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",events);
        return "events/events";
    }

    /**
     * 活动列表 前台
     * @param events
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Events events, Model model){
        String sql = "select * from events where 1=1 ";
        if(!isEmpty(events.getName())){
            sql += " and name like '%"+events.getName()+"%'";
        }
        sql += " order by events_id desc";
        Pager<Events> pagers = eventsService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",events);

        //导航查询一级类目
        String sqlf = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fList = itemCategoryService.listBySqlReturnEntity(sqlf);
        model.addAttribute("flst",fList);
        return "events/list";
    }


    /**
     * 跳转到添加页面
     */
    @RequestMapping("/add")
    public String add(){
        return "events/add";
    }

    /**
     * 添加执行
     */
    @RequestMapping("/exAdd")
    public String exAdd(Events events){
        events.setAddTime(new Date());
        eventsService.insert(events);
        return "redirect:/events/findBySql";
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping("/update")
    public String update(Integer id,Model model){
        Events obj = eventsService.load(id);
        model.addAttribute("obj",obj);
        return "events/update";
    }

    /**
     * 修改执行
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(Events events){
        events.setUpdateTime(new Date());
        eventsService.updateById(events);
        return "redirect:/events/findBySql";
    }

    /**
     * 删除公告
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        String sql ="select * from post where events_id="+id;
        List<Post> posts = postService.listBySqlReturnEntity(sql);
        for (Post p: posts) {
            p.setStatus(2); //活动结束 对应作品直接下架 但不删除
            postService.updateById(p);
        }
        eventsService.deleteById(id);
        return "redirect:/events/findBySql";
    }
}
