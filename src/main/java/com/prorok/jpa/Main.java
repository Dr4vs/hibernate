package com.prorok.jpa;

import com.prorok.jpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
//        employee.setId(1);
        employee.setFirstName("Jan");
        employee.setLastName("Nowak");
        employee.setSalary(3333.3);

        Employee employee2 = new Employee();
        employee2.setFirstName("Marek");
        employee2.setLastName("Kapusta");
        employee2.setSalary(2133.3);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(employee2);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
