package com.southwind.feign;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVo;
import com.southwind.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "menu")//访问menu的服务
public interface MenuFeign {

    //声明接口
    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVo findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);//MenuVo分页时使用，否则只用Menu

    @GetMapping("/menu/index")
    public String index();

    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);

    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();

    @PostMapping("/menu/save")
    public void save(@RequestBody Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") long id);

    @PutMapping("/menu/update")
    public void update(Menu menu);

}
