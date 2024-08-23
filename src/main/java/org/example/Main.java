package org.example;

import org.example.config.FactoryConfiguration;
import org.example.embed.FullName;
import org.example.entity.Pet;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();

        FullName fullName = new FullName("pql","omn");
        Student student = new Student();
        student.setId(2);
        student.setName(fullName);
        student.setAddress("ab");

        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("rocky");
        pet.setAge(5);


        /*---------------------Open Transaction---------------------*/
        Transaction transaction = session.beginTransaction();

        /*session.save(student);*/
        /*session.update(student);*/
        /*session.delete("1",student);*/
        /*Student student1 = session.get(Student.class,2);*/
        session.save(pet);
        transaction.commit();
        session.close();
    }

}