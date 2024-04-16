package com.encore.bbabap.api.favorite;

import com.encore.bbabap.api.favorite.response.FavoriteResponseDTO;
import com.encore.bbabap.service.favorite.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bbabap/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;
    //즐겨찾기 추가 >> 정확한 충전소명 입력 필
    @PostMapping("/save")
    public String saveFavoriteByName(@RequestParam("충전소명") String chargerName) {
        System.out.println("Save Favorite");
        return favoriteService.saveFavorite(chargerName);
    }
    //즐겨찾기 조회 >> 현재는 전체 조회만 가능.
    @GetMapping("/find")
    public List<FavoriteResponseDTO> findAllFavorite() {
        System.out.println("Find All Favorites");
        return favoriteService.findFavorite();
    }
    //즐겨찾기 삭제 >> id를 입력하여 삭제가능.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFavoriteById(@PathVariable Long id) {
        System.out.println("Delete number " + id + " Favorite");
        favoriteService.deleteFavorite(id);
        return ResponseEntity.ok().build();
    }

}