package com.encore.bbabap.api.kakaomap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bbabap/kakao")
public class KakaomapUi {

    @GetMapping(value = "/map")
    public String mymap(){
        System.out.println(">>> 카카오 맵 UI 출력 완료 <<<");
        return "map";
    }//method end

}
