package com.encore.bbabap.api.chargerinfo;

import com.encore.bbabap.service.chargerinfo.ChargerInfoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bbabap")
public class ChargerInfoController {

    private final ChargerInfoService chargerInfoService;

    //주소만 가져오기. pathvalue를 통해 특정 지역의 충전소위치, 충전소명 가져오도록 설정.
    @GetMapping("/getchargeraddress/{filter}")
    public String getChargerAddress(@PathVariable("filter") String filter) {
        System.out.println("debug >>> getChargerAddress Controller activate. filter : " + filter);
        String reasult = chargerInfoService.getChargerAddName(filter);
        return reasult;
    }//getChargerAddress end

}//class end
