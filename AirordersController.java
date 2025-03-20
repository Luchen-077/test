package com.example.controller;

import com.example.common.Result;
import com.example.entity.Airorders;
import com.example.service.AirordersService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

/**
 * 机票订单表前端操作接口
 **/
@RestController
@RequestMapping("/airorders")
public class AirordersController {

    @Resource
    private AirordersService airordersService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Airorders airorders) throws ParseException {
        airordersService.add(airorders);
        return Result.success();
    }

    @PostMapping("/returnTicket")
    public Result returnTicket(@RequestBody Airorders airorders) throws ParseException {
        airordersService.returnTicket(airorders);
        return Result.success();
    }

    @PostMapping("/change")
    public Result change(@RequestBody Airorders airorders) throws ParseException {
        airordersService.change(airorders);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        airordersService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        airordersService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Airorders airorders) {
        airordersService.updateById(airorders);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Airorders airorders = airordersService.selectById(id);
        return Result.success(airorders);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Airorders airorders ) {
        List<Airorders> list = airordersService.selectAll(airorders);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Airorders airorders,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Airorders> page = airordersService.selectPage(airorders, pageNum, pageSize);
        return Result.success(page);
    }

}