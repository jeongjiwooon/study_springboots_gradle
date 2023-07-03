package com.yojulab.study_springboots_gradle.restapis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yojulab.study_springboots_gradle.service.CarInforsService;

@RestController
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

    // /selectSearch/year/2020
    // /selectSearch/car_name/소
    @GetMapping("/selectSearch/{search}/{words}")
    public ResponseEntity selectSearch(@PathVariable String search, @PathVariable String words)
    {
        Object result = carInforsService.selectSearch(search, words);
        return ResponseEntity.ok().body(result);
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

    @DeleteMapping("/delete/{car_infor_id}")
    public ResponseEntity delete(@PathVariable String car_infor_id)
    {
        Object result = carInforsService.delete(car_infor_id);
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
}
