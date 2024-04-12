package com.encore.bbabap.api.favorite;

import com.encore.bbabap.service.favorite.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/babap/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;

    @PostMapping("/save")
    public String saveChargerInfoByName(@RequestParam("충전소명") String chargerName) {
        return favoriteService.saveChargerInfoByName(chargerName);
    }



}