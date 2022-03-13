package io.longtu.cloud_music.repository;

import io.longtu.cloud_music.model.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMusicRepository extends JpaRepository<Music, String> {

    Optional<Music> findById(String id);
}
