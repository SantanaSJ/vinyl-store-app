package com.example.sampleproject.repository;

import com.example.sampleproject.model.entities.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

    @Query(value = "SELECT * FROM sample_app.albums", nativeQuery = true)
    List<AlbumEntity> getAllVinyls();

    @Query(value = "SELECT * FROM sample_app.albums as v " +
            "JOIN sample_app.artists a ON v.artist_id = a.id " +
            "WHERE a.name = :artistName", nativeQuery = true)
    List<AlbumEntity> findByArtist(@Param("artistName") String artistName);

    List<AlbumEntity> findByArtistId(Long id);

    Optional<AlbumEntity> findByAlbumName (String album);

    boolean existsByAlbumName(String name);

}
