package com.endava;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person person = new Person();
        person.setFirstName("Bogdan");
        person.setLastName("Fusa");
        person.setAge(22);
        person.setAddress("Camin T19, Iasi");

        Rectangle rectangle = new Rectangle();
        rectangle.setX(2.3);
        rectangle.setY(6.1);
        rectangle.setHeight(200);
        rectangle.setWidth(300);

        new GenericClass<Person>().print(person);
        System.out.println("");
        new GenericClass<Rectangle>().print(rectangle);

    }
}
