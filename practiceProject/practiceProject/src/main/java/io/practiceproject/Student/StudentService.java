package io.practiceproject.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email Already Taken");
        }
        studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
        //return List.of( new  Student(1,"Anuj", LocalDate.of(2001,9,16),20,"anujjoshi32@gmail.com"));
    }
    public void deleteStudent(Integer id){
        boolean exist = studentRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("Student Id doesn't exist");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudents(Integer id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Id"+id+"doesn't exist"));
        if(name!=null && name.length()>0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if(email!=null && name.length()>0 && !Objects.equals(student.getEmail(), email)){
//            student.setEmail(email);
            Optional<Student> studentByEmail =  studentRepository.findStudentByEmail(email);
            if(studentByEmail.isPresent()){
                throw new IllegalStateException("Email Already Present");
            }
            student.setEmail(email);


        }
    }
}
