package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class StudentRepository {

    HashMap<String , Student > StudentMap = new HashMap<>();
    HashMap<String , Teacher> TeacherMap = new HashMap<>();
    HashMap<String , List<String>> StudentTeacherMap = new HashMap<>();

    public void addStudent(Student student){
        StudentMap.put(student.getName(), student);
    }
    public void addTeacher(Teacher teacher){
        TeacherMap.put(teacher.getName() , teacher);
    }

    public void addStudentTeacherPair(String student , String teacher){

        if(StudentMap.containsKey(student) && TeacherMap.containsKey(teacher)){
            List<String> StudentsOfTheTeacher = new ArrayList<>();
            if(StudentTeacherMap.containsKey(teacher))
                StudentsOfTheTeacher = StudentTeacherMap.get(teacher);
                StudentsOfTheTeacher.add(student);
                StudentTeacherMap.put(teacher , StudentsOfTheTeacher);

        }
    }
    public Student getStudent(String student){
        return StudentMap.get(student);

    }
    public Teacher getTeacherByName(String teacher){
        return TeacherMap.get(teacher);
    }
    public List<String> studentNames(String teacherName){
        List<String> studentList = new ArrayList<>();
        if(StudentTeacherMap.containsKey(teacherName)){
            studentList = StudentTeacherMap.get(teacherName);

        }
        return studentList;
    }

    public List<String> getAllSudents(){
        return new ArrayList<>(StudentMap.keySet());
    }

    public void deleteTeacher(String teacher) {
        List<String> students = new ArrayList<>();
        if (StudentTeacherMap.containsKey(teacher)) {
            students = StudentTeacherMap.get(teacher);
        }
        for (String student : students) {
            if (StudentMap.containsKey(student)) {
                StudentMap.remove(student);
            }
        }
        StudentTeacherMap.remove(teacher);

        if (TeacherMap.containsKey(teacher)) {
            TeacherMap.remove(teacher);
        }
    }

    public void deleteTeachers(){
            HashSet<String> studentSet = new HashSet<String>();


            TeacherMap = new HashMap<>();


            for(String teachers: StudentTeacherMap.keySet()){


                for(String student: StudentTeacherMap.get(teachers)){
                    studentSet.add(student);
                }
            }


            for(String student: studentSet){
                if(StudentMap.containsKey(student)){
                    StudentMap.remove(student);
                }
            }

            StudentTeacherMap = new HashMap<>();
        }

        }


