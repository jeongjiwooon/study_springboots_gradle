package com.yojulab.study_springboots_gradle.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yojulab.study_springboots_gradle.dao.SharedDao;

@Service
public class CarInforsService
{
    @Autowired
    SharedDao sharedDao;

    public Object selectSearch(Map dataMap)
    {
        String sqlMapId = "CarInfors.selectSearch";

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object selectSearch(String search, String words)
    {
        String sqlMapId = "CarInfors.selectSearch";
        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search);
        dataMap.put("words", words);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object selectAll(String car_infor_id)
    {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarInfors.selectAll";
        HashMap dataMap = new HashMap<>();
        dataMap.put("car_infor_id", car_infor_id);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object selectDetail(String car_infor_id)
    {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarInfors.selectByUID";
        HashMap dataMap = new HashMap<>();
        dataMap.put("car_infor_id", car_infor_id);

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object insert(Map dataMap)
    {
        String sqlMapId = "CarInfors.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object update(Map dataMap)
    {
        String sqlMapId = "CarInfors.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }

    // MVC view
    public Object delete(Map dataMap)
    {
        HashMap result = new HashMap<>();
        String sqlMapId = "CarInfors.delete";
        result.put("deleteCount", sharedDao.delete(sqlMapId, dataMap));

        sqlMapId = "CarInfors.selectDetail";
        result.put("resultList", sharedDao.getOne(sqlMapId, dataMap));
        return result;
    }

    // MVC view
    public Object deleteAndSelectSearch(Map dataMap)
    {
        HashMap result = new HashMap<>();
        // String sqlMapId = "CarInfors.delete";
        // result.put("deleteCount", sharedDao.delete(sqlMapId, dataMap));
        result.put("deleteCount", this.delete(dataMap));

        // sqlMapId = "CarInfors.selectDetail";
        // result.put("resultList", sharedDao.getOne(sqlMapId, dataMap));
        result.put("resultList", this.selectSearch(dataMap));
        return result;
    }

    // rest api
    public Object delete(String car_infor_id)
    {
        HashMap dataMap = new HashMap<>();
        String sqlMapId = "CarInfors.delete";
        dataMap.put("car_infor_id", car_infor_id);

        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }

    // 2PC
    @Transactional
    public Object insertDouble(Map dataMap)
    {
        String sqlMapId = "CarInfors.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);

        result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    // foreach Map("car_infor_id_list", car_infor_id_list)
    public Object selectInUID(Map dataMap)
    {
        String sqlMapId = "CarInfors.selectInUID";

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }
}
