package com.encore.bbabap.repository.favorite;

import com.encore.bbabap.domain.favorite.FavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Long> {

}