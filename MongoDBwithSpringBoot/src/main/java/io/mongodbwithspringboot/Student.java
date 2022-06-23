package io.mongodbwithspringboot;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    @Indexed(unique = true)
    private String email;
    private Address address;
    private List<String> favouriteSubject;
    private Double totalSpent;
    private LocalDateTime created;

    public Student(String firstName,
                   String lastName,
                   Gender gender, String email, Address address,
                   List<String> favouriteSubject,
                   Double totalSpent, LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.favouriteSubject = favouriteSubject;
        this.totalSpent = totalSpent;
        this.created = created;
    }
}
