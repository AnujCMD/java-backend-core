package io.mongodbwithspringboot;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, Integer> {
    Optional<Student> findStudentsByEmail(String email);
}
