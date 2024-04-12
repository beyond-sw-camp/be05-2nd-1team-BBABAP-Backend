package com.encore.bbabap.domain.favorite;

import com.encore.bbabap.api.favorite.request.FavoriteRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="myfavorite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(name = "charger_Name")
    private String chargerName;

    @Column(name = "charger_Address")
    private String chargerAddress;

    @Column(name = "charger_Power")
    private String chargerPower;

    @Column(name = "charger_Type")
    private String chargerType;

    public static FavoriteEntity favoriteEntity(FavoriteRequestDTO favoriteRequestDTO){
        FavoriteEntity favoriteEntity = new FavoriteEntity();
        favoriteEntity.setId(favoriteRequestDTO.getId());
        favoriteEntity.setChargerName(favoriteRequestDTO.getChargerName());
        favoriteEntity.setChargerAddress(favoriteRequestDTO.getChargerAddress());
        favoriteEntity.setChargerPower(favoriteRequestDTO.getChargerPower());
        favoriteEntity.setChargerType(favoriteRequestDTO.getChargerType());
        return favoriteEntity;
    }
}