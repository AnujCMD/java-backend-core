package io.practiceproject.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
@RestController
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //    @GetMapping
//    public String hello(){
//        return "Hello World";
//    }
//    @GetMapping("/hello")
//    public List<String> helloList(){
//        return List.of("Hello", "World");
//    }
    @GetMapping()
    public List<Student> getStudents(){
        // moving it to Service Layer
//        return List.of( new  Student(1,"Anuj", LocalDate.of(2001,9,16),20,"anujjoshi32@gmail.com"));
        return studentService.getStudents();
    }
    @PostMapping()
    public void registerStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
    @DeleteMapping(path =  "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer id){
        studentService.deleteStudent(id);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudents(id, name, email);
    }
}