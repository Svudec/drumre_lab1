package hr.unizg.fer.karlo_sudec.Labos1.city.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class City {
    @Id
    private Long id;

    private String name;

    private String country;
}
