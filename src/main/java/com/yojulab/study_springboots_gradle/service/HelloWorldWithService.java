package com.yojulab.study_springboots_gradle.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class HelloWorldWithService
{
    public ArrayList fakeSelect(String currentPage, String perPage)
    {
        // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null / 0
        // "spm_row": 571, "SN": 2, "CMPNM": "의료유통", "RDNMADR": 3 / 1
        ArrayList arrayList = new ArrayList<>();
        HashMap resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);
        arrayList.add(resultMap);

        resultMap = new HashMap<>();
        resultMap.put("spm_row", 571);
        resultMap.put("SN", 2);
        resultMap.put("CMPNM", "의료유통");
        resultMap.put("RDNMADR", 3);
        arrayList.add(resultMap);

        return arrayList;
    }
}
