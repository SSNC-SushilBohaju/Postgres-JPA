package jp.smartsolar;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Employee employee = new Employee("Desolated", "Hell");
        entityManager.persist(employee);
        entityTransaction.commit();
        System.out.println("Employee created with ID: " + employee.getId());

        // Read
        Employee foundEmployee = entityManager.find(Employee.class, employee.getId());
        System.out.println("Employee found: " + foundEmployee);

        // Update
        entityTransaction.begin();
        foundEmployee.setName("Jane Doe");
        entityManager.merge(foundEmployee);
        entityTransaction.commit();
        System.out.println("Employee updated: " + foundEmployee);

        // Delete
        entityTransaction.begin();
        entityManager.remove(foundEmployee);
        entityTransaction.commit();
        System.out.println("Employee deleted");

        entityManager.close();
        entityManagerFactory.close();

    }

}