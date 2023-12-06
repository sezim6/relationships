package org.example;

import org.example.models.Laptop;
import org.example.models.Person;
import repositories.LaptopRepository;
import repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) {
        PersonRepository person = new PersonRepository();
        LaptopRepository laptop = new LaptopRepository();
        Person person1 = new Person();
        person1.setInfo("Arun Jumabekov");
        person1.setAge(17);
        person.save(person1);
        Laptop laptop1 = new Laptop();
        laptop1.setModel("Apple");
        laptop1.setInvented_by("Steve Jobs");
        laptop1.setPerson(person1);
        laptop.save(laptop1);
        Laptop laptop2 = new Laptop();
        laptop2.setModel("Acer");
        laptop2.setInvented_by(" Stan Shih");
        laptop2.setPerson(person1);
        laptop.save(laptop2);
        Laptop laptop3 = new Laptop();
        laptop3.setModel("HP");
        laptop3.setInvented_by("Bill Hewlet");
        laptop3.setPerson(person1);
        laptop.save(laptop3);
    }
}
