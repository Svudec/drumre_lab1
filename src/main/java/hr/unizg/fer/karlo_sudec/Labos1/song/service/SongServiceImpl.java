package hr.unizg.fer.karlo_sudec.Labos1.song.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.unizg.fer.karlo_sudec.Labos1.song.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class SongServiceImpl implements SongService{

    private final SongRepository songRepository;
    private final RestTemplate restTemplate;
    @Value("${songsApiKey}")
    private String songApiKey;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public SongServiceImpl(SongRepository songRepository, RestTemplate restTemplate) {
        this.songRepository = songRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public void saveSongsIfNotExists(Song[] songs) {
        for (Song song : songs) {
            saveSongIfNotExists(song);
        }
    }

    @Override
    @Transactional
    public void saveSongIfNotExists(Song song) {
        if (songRepository.findById(song.getUrl()).isEmpty()){
            songRepository.save(song);
        }
    }

    @Override
    public Song[] getSongsFromApi(String query) {
        String SongApiUrl
                = "https://ws.audioscrobbler.com/2.0/?method=track.search&track="+ query +
                "&limit=10&api_key=" + songApiKey + "&format=json";
        ResponseEntity<String> response = restTemplate.getForEntity(SongApiUrl, String.class);
        try {
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            Song[] songs = objectMapper.treeToValue(jsonNode.findValue("track"), Song[].class);
            saveSongsIfNotExists(songs);
            return songs;
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
