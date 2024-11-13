package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeService implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private CheckBox isMonday;
    @FXML
    private CheckBox isTuesday;
    @FXML
    private CheckBox isWednesday;
    @FXML
    private CheckBox isThursday;
    @FXML
    private CheckBox isFriday;
    @FXML
    private CheckBox isSaturday;
    @FXML
    private CheckBox isSunday;
    @FXML
    private ListView<Employee> employeeListView;

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JavaKd2");
    private final DatabaseService databaseService = new DatabaseService(entityManagerFactory);

    public void createEmployee() {
        Employee employee = new Employee(nameField.getText(),
                surnameField.getText(),
                isMonday.isSelected(),
                isTuesday.isSelected(),
                isWednesday.isSelected(),
                isThursday.isSelected(),
                isFriday.isSelected(),
                isSaturday.isSelected(),
                isSunday.isSelected());

        databaseService.createEmployee(employee);
    }

    public void getAllEmployees() {
        employeeListView.getItems().clear();
        List<Employee> employees = databaseService.getAllEmployees();

        employeeListView.getItems().addAll(employees);
    }

    public void updateEmployee() {
        Employee employee = employeeListView.getSelectionModel().getSelectedItem();
        Employee employeeInfoFromDatabase = databaseService.getEmployeeById(employee.getId());

        employeeInfoFromDatabase.setName(nameField.getText());
        employeeInfoFromDatabase.setSurname(surnameField.getText());
        employeeInfoFromDatabase.setMonday(isMonday.isSelected());
        employeeInfoFromDatabase.setTuesday(isTuesday.isSelected());
        employeeInfoFromDatabase.setWednesday(isWednesday.isSelected());
        employeeInfoFromDatabase.setThursday(isThursday.isSelected());
        employeeInfoFromDatabase.setFriday(isFriday.isSelected());
        employeeInfoFromDatabase.setSaturday(isSaturday.isSelected());
        employeeInfoFromDatabase.setSunday(isSunday.isSelected());

        databaseService.updateEmployee(employeeInfoFromDatabase);
    }

    public void deleteEmployee() {
        Employee employee = employeeListView.getSelectionModel().getSelectedItem();
        databaseService.deleteEmployee(employee.getId());
    }

    public void loadEmployeeData() {
        Employee employee = employeeListView.getSelectionModel().getSelectedItem();
        nameField.setText(employee.getName());
        surnameField.setText(employee.getSurname());
        isMonday.setSelected(employee.isMonday());
        isTuesday.setSelected(employee.isTuesday());
        isWednesday.setSelected(employee.isWednesday());
        isThursday.setSelected(employee.isThursday());
        isFriday.setSelected(employee.isFriday());
        isSaturday.setSelected(employee.isSaturday());
        isSunday.setSelected(employee.isSunday());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllEmployees();
    }
}
