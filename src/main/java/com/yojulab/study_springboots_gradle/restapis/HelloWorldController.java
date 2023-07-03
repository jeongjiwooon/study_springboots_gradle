package com.yojulab.study_springboots_gradle.restapis;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yojulab.study_springboots_gradle.service.HelloWorldWithService;

@Controller // 클라이언트의 요청을 처리하는 결정만 해주고 응답을 보내주는 명령어
public class HelloWorldController
{
    @Autowired // 의존 객체의 타입에 해당하는 *[빈]을 찾아 주입하는 역할
               // 빈(Bean): 스프링이 제어권을 가져서 직접 생성하고 *[의존관계(DI)]를 부여하는 오브젝트
               // 의존관계(DI): 코드 상 객체를 직접 만드는 것이 아닌 외부에서 객체를 넣어주는 방식
    HelloWorldWithService helloWorldWithService;

    @GetMapping("/helloWorld") // Method를 doGet으로 바꾸어주는 명령어
    public int helloWorld()
    {
        return 0;
    }

    // /helloWorldGetRequest?Name=yojulab&Id=U-01
    // /helloWorldGetRequest/yojulab/U-01
    @GetMapping("/helloWorldGetRequest/{Name}/{Id}")
    public int helloWorldGetRequest(@PathVariable String Name, @PathVariable String Id)
    {
        return 0;
    }

    // ?serviceKey=1mwBjpqCO6bXF419htdzV8gUbaPE0z5s739L2aXrMPqsAxCScaCWRM6LuDNiVNREzenkFyglf9FQND2Rm1z7Fg%3D%3D
    // &currentPage=1
    // &perPage=10
    // &SN=1
    // /helloWorldResponse/{1}/{10}/{1}
    // /helloWorldResponse/1/10/1
    @GetMapping("/helloWorldResponse/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldResponse(@PathVariable String currentPage, @PathVariable String perPage, @PathVariable String SN)
    {
        // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null
        HashMap resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);

        return ResponseEntity.ok().body(resultMap);
    }

    // http://192.168.0.40:8080/helloWorldResponseList/1/10/1
    @GetMapping("/helloWorldResponseList/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldResponseList(@PathVariable String currentPage, @PathVariable String perPage, @PathVariable String SN)
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

        return ResponseEntity.ok().body(arrayList);
    }

    @GetMapping("/helloWorldResponseWithService/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldResponseWithService(@PathVariable String currentPage, @PathVariable String perPage, @PathVariable String SN)
    {
        ArrayList arrayList = new ArrayList<>();
        arrayList = helloWorldWithService.fakeSelect(currentPage, perPage);
        return ResponseEntity.ok().body(arrayList);
    }

    // /helloWorldResponseFake/C001
    @GetMapping("/helloWorldResponseFake/{companyId}")
    public ResponseEntity<Object> helloWorldResponseFake(@PathVariable String companyId)
    {
        ArrayList arrayList = new ArrayList<>();
        helloWorldWithService.fakeSelect(companyId);
        return ResponseEntity.ok().body(arrayList);
    }
}
