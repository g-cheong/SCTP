package com.example.didemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    // @Autowired
    private MathTeacher mathTeacher;
    @Autowired
    private ScienceTeacher scienceTeacher;  
    private CodingTeacher codingTeacher;
    private AlgorithimsTeacher algorithimsTeacher;  
    @Autowired
    private DatabaseTeacher databaseTeacher;
    // private MathTeacher mathTeacher = new MathTeacher();
    // private ScienceTeacher scienceTeacher = new ScienceTeacher();
    
    //Constructor Injection
    public TeacherController(CodingTeacher codingTeacher) {
        this.codingTeacher = codingTeacher;
    }

    @GetMapping("/math-teacher")
    public String mathTeacher() {
        return mathTeacher.teach();
    }

    @GetMapping("/science-teacher")
    public String scienceTeacher() {
        return scienceTeacher.teach();
    }

    @GetMapping("/coding-teacher")
    public String codingTeacher() {
        return codingTeacher.teach();
    }

    @GetMapping("/algorithims-teacher")
    public String algorithimsTeacher() {
        return algorithimsTeacher.teach();
    }

    @GetMapping("/database-teacher")
    public String databaseTeacher() {
        return databaseTeacher.teach();
    }

    @Autowired
    public void setAlgorithimsTeacher(AlgorithimsTeacher algorithimsTeacher) {
        this.algorithimsTeacher = algorithimsTeacher;
    }

    @Autowired
    public void setMathTeacher(MathTeacher mathTeacher) {
        this.mathTeacher = mathTeacher;
    }
}
