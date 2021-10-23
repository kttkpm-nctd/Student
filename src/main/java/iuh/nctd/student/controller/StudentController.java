package iuh.nctd.student.controller;

import iuh.nctd.student.VO.StudentVO;
import iuh.nctd.student.entity.Student;
import iuh.nctd.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{studentId}")
    public StudentVO getStudentById(@PathVariable int studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/rateLimiter/{studentId}")
    public Student getStudentByIdRateLimiter(@PathVariable int studentId) {

        for (int i = 0; i < 10; i++) {
            studentService.getStudentByIdRateLimiter(studentId);
        }
        return null;
    }


    @PostMapping("/")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }


}
