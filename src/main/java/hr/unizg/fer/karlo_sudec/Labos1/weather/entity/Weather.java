package hr.unizg.fer.karlo_sudec.Labos1.weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Weather {
    @Id
    private Long id;

    private String main;

    private String description;

    private String icon;
}
