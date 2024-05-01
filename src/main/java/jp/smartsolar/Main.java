package jp.smartsolar;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        // Finding an Employee entity by its primary key
        Employee employee = entityManager.find(Employee.class, 1);

        if (employee != null) {
            System.out.println("Found Employee: " + employee.getName());
        } else {
            System.out.println("Employee not found");
        }

        entityManagerFactory.close();

    }

}