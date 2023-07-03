package com.yojulab.study_springboots_gradle.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yojulab.study_springboots_gradle.dao.SharedDao;

@Service
public class CarCompanyService
{
    @Autowired
    SharedDao sharedDao;

    public Object CarCompanysearch(String search, String name)
    {
        String sqlMapId = "CarCompany.search";
        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search);
        dataMap.put("name", name);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object CarCompanyUpdate(Map dataMap)
    {
        String sqlMapId = "CarCompany.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }

    public Object CarCompanyDelete(String company_id)
    {
        HashMap dataMap = new HashMap<>();
        String sqlMapId = "CarCompany.delete";
        dataMap.put("company_id", company_id);

        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }
}
