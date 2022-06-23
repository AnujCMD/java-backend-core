package io.mongodbwithspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongoDBwithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDBwithSpringBootApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate){
     return args -> {
         Address address = new Address("India","Delhi","11B3A");
         String email = "anujjoshi32@gmail.com";
         Student student = new Student("Anuj", "Joshi", Gender.Male, email,address, List.of("Mathematics","Psychology"), 120D, LocalDateTime.now());
         //usingMongoTemplateAndQuery(studentRepository, mongoTemplate, email, student);
         studentRepository.findStudentsByEmail(email).ifPresentOrElse(s->{
             System.out.println(s+"already exists");
         },()-> {
             System.out.println("Inserting Student Data: " + student);
             studentRepository.insert(student);
         });
     };

    }

    private void usingMongoTemplateAndQuery(StudentRepository studentRepository, MongoTemplate mongoTemplate, String email, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        List<Student> students = mongoTemplate.find(query, Student.class);
        System.out.println(students);
        if(students.size()>1){
            throw new IllegalStateException("Email already taken");
        }
        if(students.isEmpty()) {
            System.out.println("Inserting Student Data: "+ student);
            studentRepository.insert(student);
        }
        else{
            System.out.println("Student email already taken choose another Email");
        }
    }

}
