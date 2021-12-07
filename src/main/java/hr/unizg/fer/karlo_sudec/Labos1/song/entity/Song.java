package hr.unizg.fer.karlo_sudec.Labos1.song.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Document
public class Song {

    @Id
    private String url;

    private String name;

    private String artist;
}
