package hr.unizg.fer.karlo_sudec.Labos1.song.service;

import hr.unizg.fer.karlo_sudec.Labos1.song.entity.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {
}
