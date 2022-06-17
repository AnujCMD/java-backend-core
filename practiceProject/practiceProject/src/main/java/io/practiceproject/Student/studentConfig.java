package io.practiceproject.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.SEPTEMBER;


@Configuration
public class studentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student Anuj = new Student
                    ("Anuj",
                            LocalDate.of(2001, SEPTEMBER, 16),
                            "anujjoshi32@gmail.com");
            Student Rajesh = new Student
                    ("Rajesh",
                            LocalDate.of(1995, JANUARY, 20),
                            "anujjoshi32@gmail.com");

            studentRepository.saveAll(List.of(Anuj, Rajesh));
        };
    }

}
