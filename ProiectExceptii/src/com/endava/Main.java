package com.endava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // throw exceptions
        // catch exceptions
        // use try-with-resources
        // define your own exception

        Catalog catalogPC = new Catalog();

        Student student1 = new Student();
        student1.setMedie(8);
        student1.setName("Bogdan");
        catalogPC.addStudent(student1);

        String textFromFile = new String();

        try (BufferedReader br = new BufferedReader(new FileReader("./src/file.txt"))){
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                //sb.append(System.lineSeparator());
                line = br.readLine();
            }
            textFromFile = sb.toString();
            //System.out.println("text from file:" + textFromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        float medieForSearch = 8;

        try {
            System.out.println("Studentul " + catalogPC.getStudentByName(textFromFile).getName() + " exista");
            System.out.println(catalogPC.getStudentByMedie(medieForSearch).getName() + " are media " + medieForSearch);
        } catch (StudentNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        String nameForDelete = "Bogdann";
        try {
            catalogPC.removeStudentByName(nameForDelete);
            System.out.println("studentul " + nameForDelete + " a fost sters cu succes din catalog");
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }
    }
}
