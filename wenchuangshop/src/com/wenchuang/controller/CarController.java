package com.wenchuang.controller;

import com.alibaba.fastjson.JSONObject;
import com.wenchuang.po.Car;
import com.wenchuang.po.Item;
import com.wenchuang.po.ItemCategory;
import com.wenchuang.service.CarService;
import com.wenchuang.service.ItemCategoryService;
import com.wenchuang.service.ItemService;
import com.wenchuang.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 */
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCategoryService itemCategoryService;

    @RequestMapping("/exAdd")
    @ResponseBody
    public String exAdd(Car car, HttpServletRequest request){
        JSONObject js = new JSONObject();
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            js.put(Consts.RES,0);
            return js.toJSONString();
        }
        //保存到购物车
        Integer userId = Integer.valueOf(attribute.toString());
        car.setUserId(userId);
        Item item = itemService.load(car.getItemId());
        String price = item.getPrice();
        Double valueOf = Double.valueOf(price);
        car.setPrice(valueOf);

        //判断折扣
        if(item.getZk()!=null&&item.getZk()>0){
            valueOf = valueOf*item.getZk()/10;
            BigDecimal bg = new BigDecimal(valueOf).setScale(2, RoundingMode.UP);
            car.setPrice(bg.doubleValue());
            valueOf = bg.doubleValue();
        }
        Integer num = car.getNum();
        Double t = valueOf*num;
        BigDecimal bg = new BigDecimal(t).setScale(2, RoundingMode.UP);
        double doubleValue = bg.doubleValue();
        car.setTotal(doubleValue+"");

        carService.insert(car);
        js.put(Consts.RES,1);
        return js.toJSONString();
    }

    /**
     * 转向我的购物车页面
     */
    @RequestMapping("/findBySql")
    public String findBySql(Model model,HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            return "redirect:/login/toLogin";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        String sql = "select * from car where user_id="+userId+" order by car_id desc";
        List<Car> list = carService.listBySqlReturnEntity(sql);
        List<Item> items = new ArrayList<>();
        //购物车页面库存判断
        for (Car c:list) {
            Item item=itemService.load(c.getItemId());
            items.add(item);
            }
        model.addAttribute("item",items);
        model.addAttribute("list",list);

        //查询一级类目
        String sqlf = "select * from item_category where isDelete=0 and pid is null order by name";
        List<ItemCategory> fList = itemCategoryService.listBySqlReturnEntity(sqlf);
        model.addAttribute("flst",fList);

        return "car/car";
    }

    /**
     * 删除购物车
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        carService.deleteById(id);
        return "success";
    }
}
