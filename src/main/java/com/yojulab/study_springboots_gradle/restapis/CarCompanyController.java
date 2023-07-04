package com.yojulab.study_springboots_gradle.restapis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yojulab.study_springboots_gradle.service.CarCompanyService;

@RestController
public class CarCompanyController
{
    @Autowired
    CarCompanyService carCompanyService;
    
    // /selectSearch/현대/C001
    @GetMapping("/carCompanySearch/{search}/{name}")
    public ResponseEntity CarCompanysearch(@PathVariable String search, @PathVariable String name)
    {
        Object result = carCompanyService.CarCompanysearch(search, name);
        return ResponseEntity.ok().body(result);
    }

   @PutMapping("/carCompanyUpdate")
    public ResponseEntity CarCompanyUpdate(@RequestBody Map paramMap)
    {
        Object result = carCompanyService.CarCompanyUpdate(paramMap);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/carCompanyDelete/{company_id}")
    public ResponseEntity delete(@PathVariable String company_id)
    {
        Object result = carCompanyService.CarCompanyDelete(company_id);
        return ResponseEntity.ok().body(result);
    }
}
