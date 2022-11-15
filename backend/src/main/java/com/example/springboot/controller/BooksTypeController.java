package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.BooksType;
import com.example.springboot.service.IBooksTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/bookstype")
public class BooksTypeController {
    @Resource
    private IBooksTypeService booksTypeService;
//fen
    @GetMapping("/page")
    public IPage<BooksType> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,@RequestParam(defaultValue = "") String type){
        IPage<BooksType> page = new Page<>(pageNum, pageSize);
        QueryWrapper<BooksType> queryWrapper = new QueryWrapper<>();
        if(!"".equals(type)){
            queryWrapper.like("type",type);
        }
        return booksTypeService.page(page,queryWrapper);
    }
    @PostMapping
    public  boolean save(@RequestBody BooksType booksType) {//前台转json数据转java对象
        //新+或者更新
        return booksTypeService.saveBooksType(booksType);
    }
    //删除数据
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {return booksTypeService.removeById(id);}
    //批量删除接口
    @PostMapping ("/del/batch")
    public Boolean deleteBatch(@RequestBody List<Integer> ids ) {return booksTypeService.removeByIds(ids);}
    //条数查询
    @GetMapping("/nu")
    public Integer fin() {
        return Math.toIntExact(booksTypeService.count());
    }


}
