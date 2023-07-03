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
}
