package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void StuTeaPair(String student , String teacher){
        studentRepository.addStudentTeacherPair(student , teacher);
    }
    public Student getStudentByName(String student){
        return studentRepository.getStudent(student);
    }
    public Teacher getTeacherByName(String teacher){
        return studentRepository.getTeacherByName(teacher);
    }

    public List<String> StudentList (String teacher){
        return studentRepository.studentNames(teacher);
    }
    public List<String> allStudents(){
      return studentRepository.getAllSudents();
    }
    public void deleteTeacher(String teacher){
      studentRepository.deleteTeacher(teacher);
    }
    public void deleteAllTeachers() {
        studentRepository.deleteTeachers();
    }
}
