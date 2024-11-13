package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;


public class DatabaseService {

    private final EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    public DatabaseService(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void createEmployee(Employee employee) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public List<Employee> getAllEmployees() {

        List<Employee> list;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            list = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return list;
    }

    public void updateEmployee(Employee employee) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(employee);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void deleteEmployee(int id) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            var employeeTemp = entityManager.find(Employee.class ,id);
            entityManager.remove(employeeTemp);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            employee = entityManager.find(Employee.class, id);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return employee;
    }
}
