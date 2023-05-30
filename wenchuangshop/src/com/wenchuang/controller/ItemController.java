package com.wenchuang.controller;

import com.wenchuang.base.BaseController;
import com.wenchuang.po.*;
import com.wenchuang.service.ItemCategoryService;
import com.wenchuang.service.ItemService;
import com.wenchuang.service.ScService;
import com.wenchuang.service.UserService;
import com.wenchuang.utils.Consts;
import com.wenchuang.utils.Pager;
import com.wenchuang.utils.SystemContext;
import com.wenchuang.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCategoryService itemCategoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private ScService scService;


    /**
     * 分页查询商品列表
     */
    @RequestMapping("/findBySql")
    public String findBySql(Model model, Item item){
        String sql = "select * from item where isDelete = 0 ";
        if(!isEmpty(item.getName())){
            sql += " and name like '%" + item.getName() + "%' ";
        }
        sql += " order by item_id desc";
        Pager<Item> pagers = itemService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",item);
        return "item/item";
    }



    /**
     * 添加商品入口
     */
    @RequestMapping("/add")
    public String add(Model model){
        String sql = "select * from item_category where isDelete = 0 and pid is not null order by ic_id";
        List<ItemCategory> listBySqlReturnEntity = itemCategoryService.listBySqlReturnEntity(sql);
        model.addAttribute("types",listBySqlReturnEntity);
        return "item/add";
    }

    /**
     * 执行添加商品
     */
    @RequestMapping("/exAdd")
    public String exAdd(Item item, @RequestParam("file")CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {
        itemCommon(item, files, request);
        item.setGmNum(0);
        item.setIsDelete(0);
        item.setScNum(0);
        itemService.insert(item);
        return "redirect:/item/findBySql.action";
    }

    /**
     * 修改商品入口
     */
    @RequestMapping("/update")
    public String update(Integer id,Model model){
        Item obj = itemService.load(id);
        String sql = "select * from item_category where isDelete = 0 and pid is not null order by ic_id";
        List<ItemCategory> listBySqlReturnEntity = itemCategoryService.listBySqlReturnEntity(sql);
        model.addAttribute("types",listBySqlReturnEntity);
        model.addAttribute("obj",obj);
        return "item/update";
    }

    /**
     * 执行修改商品
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(Item item, @RequestParam("file")CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {
        itemCommon(item, files, request);
        itemService.updateById(item);
        return "redirect:/item/findBySql.action";
    }

    /**
     * 新增和更新的公共方法
     */
    private void itemCommon(Item item, @RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {
        if(files.length>0) {
            for (int s = 0; s < files.length; s++) {
                String n = UUIDUtils.create();
                String path = SystemContext.getRealPath() + "\\resource\\ueditor\\upload\\" + n + files[s].getOriginalFilename();
                File newFile = new File(path);
                //通过CommonsMultipartFile的方法直接写文件
                files[s].transferTo(newFile);
                if (s == 0) {
                    item.setUrl1(request.getContextPath()+"\\resource\\ueditor\\upload\\" + n + files[s].getOriginalFilename());
                }
                if (s == 1) {
                    item.setUrl2(request.getContextPath()+"\\resource\\ueditor\\upload\\" + n + files[s].getOriginalFilename());
                }
                if (s == 2) {
                    item.setUrl3(request.getContextPath()+"\\resource\\ueditor\\upload\\" + n + files[s].getOriginalFilename());
                }
                if (s == 3) {
                    item.setUrl4(request.getContextPath()+"\\resource\\ueditor\\upload\\" + n + files[s].getOriginalFilename());
                }
                if (s == 4) {
                    item.setUrl5(request.getContextPath()+"\\resource\\ueditor\\upload\\" + n + files[s].getOriginalFilename());
                }
            }
        }
        ItemCategory byId = itemCategoryService.getById(item.getCategoryIdTwo());
        item.setCategoryIdOne(byId.getPid());
    }

    /**
     * 商品下架
     */
    @RequestMapping("/delete")
    public String update(Integer id){
        Item obj = itemService.load(id);
        obj.setIsDelete(1);
        itemService.updateById(obj);
        return "redirect:/item/findBySql.action";
    }

    /**
     * 按关键字或者二级分类查询 正序
     */
    @RequestMapping("/shoplist_new")
    public String shoplist_new(Item item,String condition,Model model,ItemCategory itemCategory){
        //int category_id_one = itemCategory.getId();
        //侧方菜单查询一二级
        String sql1 = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fatherList = itemCategoryService.listBySqlReturnEntity(sql1);
        List<CategoryDto> list = new ArrayList<>();
        if(!CollectionUtils.isEmpty(fatherList)){
            for(ItemCategory ic1:fatherList){
                CategoryDto dto = new CategoryDto();
                dto.setFather(ic1);
                //查询二级类目
                String sql2 = "select * from item_category where isDelete=0 and pid="+ic1.getId();
                List<ItemCategory> childrens = itemCategoryService.listBySqlReturnEntity(sql2);
                dto.setChildrens(childrens);
                list.add(dto);
                model.addAttribute("lbs",list);
            }
        }


        ItemCategory ic = itemCategoryService.load(itemCategory.getId());//搜索分类结果的title获取

        //搜索框模糊查询
        String sql = "select * from item where isDelete=0";
        if(!isEmpty(item.getCategoryIdOne())){
            sql +=" and category_id_two = " +item.getCategoryIdOne();
        }
        if(!isEmpty(itemCategory.getId())){
            if(ic.getPid()==null){
                item.setCategoryIdOne(itemCategory.getId());
                sql += " and category_id_one = " + item.getCategoryIdOne();
            }
        }

        if(!isEmpty(item.getCategoryIdTwo())){
            sql +=" and category_id_two = " +item.getCategoryIdTwo();
        }
        if(!isEmpty(itemCategory.getId())) {
            if(ic.getPid()!=null){
                item.setCategoryIdTwo(itemCategory.getId());
                sql +=" and category_id_two = " +item.getCategoryIdTwo();
            }
        }
        if(!isEmpty(condition)){
            sql += " and name like '%" + condition +"%' ";
            model.addAttribute("condition",condition);
        }
        if(!isEmpty(item.getPrice())){
            sql += " order by (price+0) desc";
        }
        if(!isEmpty(item.getGmNum())){
            sql += " order by gmNum desc";
        }
        if(isEmpty(item.getPrice())&&isEmpty(item.getGmNum())){
            sql += " order by item_id desc";
        }

        Pager<Item> pagers = itemService.findBySqlRerturnEntity(sql);

        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",item);
        model.addAttribute("ic",ic);

        //查询一级类目
        String sqlf = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fList = itemCategoryService.listBySqlReturnEntity(sqlf);
        model.addAttribute("flst",fList);

        return "item/shoplist_new";
    }


    /**
     * 按关键字或者二级分类查询 倒序
     */
    @RequestMapping("/shoplist_new2")
    public String shoplist_new2(Item item,String condition,Model model,ItemCategory itemCategory){
        //int category_id_one = itemCategory.getId();
        //查询一二级
        String sql1 = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fatherList = itemCategoryService.listBySqlReturnEntity(sql1);
        List<CategoryDto> list = new ArrayList<>();
        if(!CollectionUtils.isEmpty(fatherList)){
            for(ItemCategory ic1:fatherList){
                CategoryDto dto = new CategoryDto();
                dto.setFather(ic1);
                //查询二级类目
                String sql2 = "select * from item_category where isDelete=0 and pid="+ic1.getId();
                List<ItemCategory> childrens = itemCategoryService.listBySqlReturnEntity(sql2);
                dto.setChildrens(childrens);
                list.add(dto);
                model.addAttribute("lbs",list);
            }
        }

        //搜索框模糊查询
        ItemCategory ic = itemCategoryService.load(itemCategory.getId());

        //搜索框模糊查询
        String sql = "select * from item where isDelete=0";
        if(!isEmpty(item.getCategoryIdOne())){
            sql +=" and category_id_one = " +item.getCategoryIdOne();
        }
        if(!isEmpty(itemCategory.getId())){
            if(ic.getPid()==null){
                item.setCategoryIdOne(itemCategory.getId());
                sql += " and category_id_one = " + item.getCategoryIdOne();
            }
        }

        if(!isEmpty(item.getCategoryIdTwo())){
            sql +=" and category_id_two = " +item.getCategoryIdTwo();
        }
        if(!isEmpty(itemCategory.getId())) {
            if(ic.getPid()!=null){
                item.setCategoryIdTwo(itemCategory.getId());
                sql +=" and category_id_two = " +item.getCategoryIdTwo();
            }
        }

        if(!isEmpty(condition)){
            sql += " and name like '%" + condition +"%' ";
            model.addAttribute("condition",condition);
        }
        if(!isEmpty(item.getPrice())){
            sql += " order by (price+0) asc";
        }
        if(!isEmpty(item.getGmNum())){
            sql += " order by gmNum asc";
        }
        if(isEmpty(item.getPrice())&&isEmpty(item.getGmNum())){
            sql += " order by item_id desc";
        }

        Pager<Item> pagers = itemService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",item);
        model.addAttribute("ic",ic);

        //查询一级类目
        String sqlf = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fList = itemCategoryService.listBySqlReturnEntity(sqlf);
        model.addAttribute("flst",fList);

        return "item/shoplist_new";
    }

    /**
     *
     * 商品详情
     *
     */
    @RequestMapping("/view")
    public String view(Integer id,Model model, HttpServletRequest request) {
        Item obj = itemService.load(id);
        model.addAttribute("obj", obj);

        Object attribute = request.getSession().getAttribute(Consts.USERID);

        if(attribute==null){
            return "redirect:/login/uLogin_new";
        }

        Integer userId = Integer.valueOf(attribute.toString());
        User byId = userService.getById(userId);

        //判断用户是否重复收藏此商品
        String sqlsc = "select * from sc where item_id="+id +" and user_id="+userId;
        List<Sc>  sc = scService.listBySqlReturnEntity(sqlsc);

        model.addAttribute("scUser",sc);

        //查询一级类目
        String sqlf = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fList = itemCategoryService.listBySqlReturnEntity(sqlf);
        model.addAttribute("flst",fList);

        return "item/view";
    }






}
