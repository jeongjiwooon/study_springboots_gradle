package com.yojulab.study_springboots_gradle.controller;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yojulab.study_springboots_gradle.service.CarInforsService;

@Controller
@RequestMapping("/carInfor")
public class CarInforsController
{
    @Autowired
    CarInforsService carInforsService;

    @GetMapping("/selectAll/{car_infor_id}")
    public ResponseEntity selectAll(@PathVariable String car_infor_id)
    {
        Object result = carInforsService.selectAll(car_infor_id);
        return ResponseEntity.ok().body(result);
    }

    // /selectSearch?search=YEAR&words=2020
    // /selectSearch/car_name/소
    @GetMapping("/selectSearch")
    public ModelAndView selectSearch(@RequestParam Map params, ModelAndView modelAndView)
    {
        Object result = carInforsService.selectSearch(params);
        modelAndView.addObject("params", params);
        modelAndView.addObject("result", result);

        modelAndView.setViewName("/WEB-INF/views/carinfor/list.jsp");
        return modelAndView;
    }

    // delete with MVC
    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam Map params, ModelAndView modelAndView)
    {
        Object result = carInforsService.delete(params);
        modelAndView.addObject("params", params);

        modelAndView.setViewName("/WEB-INF/views/carinfor/list.jsp");
        return modelAndView;
    }

    // delete with MVC
    @PostMapping("/deleteAndSelectSearch")
    public ModelAndView deleteAndSelectSearch(@RequestParam Map params, ModelAndView modelAndView)
    {
        Object result = carInforsService.deleteAndSelectSearch(params);
        modelAndView.addObject("params", params);

        modelAndView.setViewName("/WEB-INF/views/carinfor/list.jsp");
        return modelAndView;
    }

    // /selectDetail/CI002
    @GetMapping("/selectDetail/{car_infor_id}")
    public ResponseEntity selectDetail(@PathVariable String car_infor_id)
    {
        Object result = carInforsService.selectDetail(car_infor_id);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody Map paramMap)
    {
        Object result = carInforsService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Map paramMap)
    {
        Object result = carInforsService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/insertDouble")
    public ResponseEntity insertDouble(@RequestBody Map paramMap)
    {
        Object result = null;
        try
        {
            result = carInforsService.insertDouble(paramMap);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/selectInUID")
    public ResponseEntity selectInUID(@RequestBody Map paramMap)
    {
        Object result = null;
        try
        {
            result = carInforsService.selectInUID(paramMap);
        }
        
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok().body(result);
    }
}
