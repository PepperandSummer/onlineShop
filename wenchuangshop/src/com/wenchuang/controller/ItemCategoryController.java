package com.wenchuang.controller;

import com.wenchuang.base.BaseController;
import com.wenchuang.po.Item;
import com.wenchuang.po.ItemCategory;
import com.wenchuang.po.TjDto;
import com.wenchuang.service.ItemCategoryService;
import com.wenchuang.service.ItemService;
import com.wenchuang.utils.Consts;
import com.wenchuang.utils.Pager;
import com.wenchuang.utils.WarningMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类目c层
 */
@Controller
@RequestMapping("/itemCategory")
public class ItemCategoryController extends BaseController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @Autowired
    private ItemService itemService;


    /**
     * 分页查询类目列表
     */
    @RequestMapping("/findBySql")
    public String findBySql(Model model,ItemCategory itemCategory){
        String sql = "select * from item_category where isDelete = 0 and pid is null order by ic_id";
        Pager<ItemCategory> pagers = itemCategoryService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",itemCategory);
        return "itemCategory/itemCategory";
    }

    /**
     * 转向到新增一级类目页面
     */
    @RequestMapping(value = "/add")
    public String add(Model model){
        String sql = "select name from item_category where isDelete = 0 and pid is null";
        List<ItemCategory> list = itemCategoryService.listBySqlReturnEntity(sql);
        model.addAttribute("types", list);
        return "itemCategory/add";
    }

    /**
     * 新增一级类目保存功能
     */
    @RequestMapping("/exAdd")
    public String exAdd(ItemCategory itemCategory, HttpServletRequest request){
        //String sql = "SELECT * FROM item_category WHERE isDelete =0 and name='"+itemCategory.getName()+"'";
        String checkSql1 = "select count(name) from item_Category where name ='"+itemCategory.getName()+"' and isDelete=0";
        int count1 = itemCategoryService.countBySql(checkSql1);
        if (count1>0){
            WarningMsg warningMsg = new WarningMsg("重复分类，请重新输入！");
            request.getSession().setAttribute("role",1);
            request.getSession().setAttribute(Consts.ADDMSG,warningMsg.getMsg());
            return "redirect:/itemCategory/add";
        } else {
                itemCategory.setIsDelete(0);
                itemCategoryService.insert(itemCategory);
                return "redirect:/itemCategory/findBySql.action";
        }
        //}

    }

    /**
     * 转向到修改一级类目页面
     */
    @RequestMapping(value = "/update")
    public String update(Integer id,Model model){
        ItemCategory obj = itemCategoryService.load(id);
        model.addAttribute("obj",obj);
        return "itemCategory/update";
    }

    /**
     * 修改一级类目
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(ItemCategory itemCategory){
        itemCategoryService.updateById(itemCategory);
        return "redirect:/itemCategory/findBySql.action";
    }

    /**
     * 删除类目
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        //删除本身
        ItemCategory load = itemCategoryService.load(id);
        load.setIsDelete(1);
        itemCategoryService.updateById(load);
        //将下级也删除
        String sql = "update item_category set isDelete=1 where pid="+id;
        itemCategoryService.updateBysql(sql);
        return "redirect:/itemCategory/findBySql.action";
    }

    /**
     * 查看二级类目
     */
    @RequestMapping("/findBySql2")
    public String findBySql2(ItemCategory itemCategory,Model model){

        String sql = "select * from item_category where isDelete=0 and pid="+itemCategory.getPid()+" order by ic_id";
        Pager<ItemCategory> pagers = itemCategoryService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",itemCategory);
        return "itemCategory/itemCategory2";
    }


    /**
     * 转向到新增二级类目页面
     */
    @RequestMapping(value = "/add2")
    public String add2(int pid,Model model){
        model.addAttribute("pid",pid);
        return "itemCategory/add2";
    }

    /**
     * 新增二级类目保存功能
     */
    @RequestMapping("/exAdd2")
    public String exAdd2(ItemCategory itemCategory){
        itemCategory.setIsDelete(0);
        itemCategoryService.insert(itemCategory);
        return "redirect:/itemCategory/findBySql2.action?pid="+itemCategory.getPid();
    }

    /**
     * 转向到修改二级类目页面
     */
    @RequestMapping(value = "/update2")
    public String update2(Integer id,Model model){
        ItemCategory obj = itemCategoryService.load(id);
        model.addAttribute("obj",obj);
        return "itemCategory/update2";
    }

    /**
     * 修改二级类目
     */
    @RequestMapping("/exUpdate2")
    public String exUpdate2(ItemCategory itemCategory){
        itemCategoryService.updateById(itemCategory);
        return "redirect:/itemCategory/findBySql2.action?pid="+itemCategory.getPid();
    }

    /**
     * 删除二级类目
     */
    @RequestMapping("/delete2")
    public String delete2(Integer id,Integer pid){
        //删除本身
        ItemCategory load = itemCategoryService.load(id);
        load.setIsDelete(1);
        itemCategoryService.updateById(load);
        return "redirect:/itemCategory/findBySql2.action?pid="+pid;
    }



    @RequestMapping(value = "/tj")
    public String tj(ItemCategory itemCategory, Model model, HttpServletRequest request, HttpServletResponse response) {
        //分页查询
        String sql = "SELECT * FROM item_category WHERE isDelete = 0 and pid is null";
        sql += " ORDER BY IC_ID DESC ";
        List<ItemCategory> list = itemCategoryService.listBySqlReturnEntity(sql);
        List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
        //List<TjDto> res = new ArrayList<TjDto>();
        if (!CollectionUtils.isEmpty(list)){
            for (ItemCategory c : list){
                TjDto td = new TjDto();
                int tot = 0;
                List<Item> listBySqlReturnEntity = itemService.listBySqlReturnEntity("SELECT * FROM item WHERE 1=1 and isDelete =0 and category_id_one="+c.getId());
                if (!CollectionUtils.isEmpty(listBySqlReturnEntity)){
                    for (Item i : listBySqlReturnEntity){
                        tot+= i.getGmNum();
                    }
                }
                //返回类名称和统计数量
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("name", c.getName());
                map.put("value", tot);
                maps.add(map);
            }
        }
        //存储查询条件
        model.addAttribute("maps", maps);
        return "itemCategory/tj";
    }



}
