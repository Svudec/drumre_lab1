package hr.unizg.fer.karlo_sudec.Labos1.song.service;

import hr.unizg.fer.karlo_sudec.Labos1.song.entity.Song;

public interface SongService {
    void saveSongsIfNotExists(Song[] songs);

    void saveSongIfNotExists(Song song);

    Song[] getSongsFromApi(String query);
}
