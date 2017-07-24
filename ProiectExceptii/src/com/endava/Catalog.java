package com.endava;

import java.util.ArrayList;

public class Catalog {
    private ArrayList<Student> catalog;

    Catalog(){
        catalog = new ArrayList<>();
    }

    public void addStudent(Student student) {
        catalog.add(student);
    }

    public Student getStudentByName(String name) throws StudentNotFoundException {

        Student x = new Student();
        for (Student student : catalog) {
            if(student.getName().equals(name)) {
                x = student;
                break;
            }
            else {
                throw new StudentNotFoundException("student inexistent");
            }
        }
        return x;
    }

    public Student getStudentByMedie(float medie) throws StudentNotFoundException {

        Student x = new Student();
        for (Student student : catalog) {
            if(student.getMedie() == medie) {
                x = student;
                break;
            }
            else {
                throw new StudentNotFoundException("nu exista student cu media respectiva");
            }
        }
        return x;
    }

    public void removeStudentByName(String name) throws StudentNotFoundException{
        int ok=0;
        for (Student student : catalog) {
            if (student.getName().equals(name)) {
                catalog.remove(student);
                ok=1;
                break;
            }
        }

        if(ok==0)
            throw new StudentNotFoundException("Studentul " + name + " nu exista pentru stergere");
    }

}
