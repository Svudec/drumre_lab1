package hr.unizg.fer.karlo_sudec.Labos1.city.entity;

import hr.unizg.fer.karlo_sudec.Labos1.weather.entity.Weather;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class City {
    @Id
    private String id;

    private String name;

    private String country;

    @DBRef
    private Weather weather;

    public void overrideId(){
        id = country.toLowerCase() + "-" + name.toLowerCase();
    }
}
