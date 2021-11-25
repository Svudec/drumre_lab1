package hr.unizg.fer.karlo_sudec.Labos1.user.service;

import hr.unizg.fer.karlo_sudec.Labos1.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
