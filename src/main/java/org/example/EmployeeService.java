package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeeService {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JavaKd2");
    private final DatabaseService databaseService = new DatabaseService(entityManagerFactory);

    public void createEmployee(Employee employee) {
        databaseService.createEmployee(employee);
    }
}
