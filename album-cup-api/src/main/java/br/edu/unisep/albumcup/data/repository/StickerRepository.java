package br.edu.unisep.albumcup.data.repository;

import br.edu.unisep.albumcup.data.entity.Sticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StickerRepository extends JpaRepository<Sticker, Integer> {

    @Query(value = "SELECT * FROM stickers WHERE nm_country =:country", nativeQuery = true)
    List<Sticker> findByCountry(@Param("country")String country);

    @Query(value = "SELECT * FROM stickers WHERE id_sticker =:id", nativeQuery = true)
    Sticker findByID(@Param("id") Integer id);

}
