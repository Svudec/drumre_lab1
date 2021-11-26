package hr.unizg.fer.karlo_sudec.Labos1.user.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    @Id
    private String id;

    private String name;

    private String email;
}
