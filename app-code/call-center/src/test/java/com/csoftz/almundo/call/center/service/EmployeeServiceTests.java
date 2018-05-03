/*----------------------------------------------------------------------------*/
/* Source File:   EMPLOYEESERVICETESTS.JAVA                                   */
/* Description:   Employe Service tests                                       */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.02/2018                                                 */
/* Last Modified: May.02/2018                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2018 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.02/2018  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.almundo.call.center.service;

import com.csoftz.almundo.call.center.common.EmployeeStatus;
import com.csoftz.almundo.call.center.common.EmployeeType;
import com.csoftz.almundo.call.center.domain.Employee;
import com.csoftz.almundo.call.center.service.intr.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Employe Service tests
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.02/2018
 * @since 1.8 (JDK), May.02/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeServiceTests {
    @Autowired
    private EmployeeService employeeService;
    private List<Employee> employeeList;

    /**
     * Configure all tests initial settings.
     */
    @Before
    public void setup() {
        employeeList = employeeService.retrieveAll();
    }

    /**
     * Asserts that employeelist from service has 15 items.
     *
     * @throws Exception
     */
    @Test
    public void givenEmployeesListReturns15Items() throws Exception {
        assertThat(employeeList).hasSize(15);
    }

    /**
     * Given an Employee List
     * Test that it has 5 operators set.
     */
    @Test
    public void givenEmployeeListHas5Operators() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.OPERATOR);
        assertThat(employeeList).hasSize(5);
    }

    /**
     * Given an Employee List
     * Test that it has 5 supervisors set.
     */
    @Test
    public void givenEmployeeListHas5Supervisors() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.SUPERVISOR);
        assertThat(employeeList).hasSize(5);
    }

    /**
     * Given an Employee List
     * Test that it has 5 directors set.
     */
    @Test
    public void givenEmployeeListHas5Directors() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.DIRECTOR);
        assertThat(employeeList).hasSize(5);
    }

    /**
     * Given Employee List
     * When retrivieng operators validates that first in list is an operator employee.
     */
    @Test
    public void givenEmployeeListWhenOperatorsThenObjectIsOperator() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.OPERATOR);
        Employee employee = employeeList.get(0);
        assertThat(employee.getEmployeeType()).isEqualTo(EmployeeType.OPERATOR);
    }

    /**
     * Given Employee List
     * When retrivieng supervisors validates that first in list is a supervisor employee.
     */
    @Test
    public void givenEmployeeListWhenSupervisorsThenObjectIsSupervisor() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.SUPERVISOR);
        Employee employee = employeeList.get(0);
        assertThat(employee.getEmployeeType()).isEqualTo(EmployeeType.SUPERVISOR);
    }

    /**
     * Given Employee List
     * When retrivieng directors validates that first in list is a director employee.
     */
    @Test
    public void givenEmployeeListWhenDirectorsThenObjectIsDirector() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.DIRECTOR);
        Employee employee = employeeList.get(0);
        assertThat(employee.getEmployeeType()).isEqualTo(EmployeeType.DIRECTOR);
    }

    /**
     * Given Employee List
     * When retrieving operators validates that they are in WAITING status.
     */
    @Test
    public void givenEmployeeListWhenOperatorsWaitingThenListHas5Items() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.OPERATOR, EmployeeStatus.WAITING);
        assertThat(employeeList).hasSize(5);
    }

    /**
     * Given Employee List
     * When retrieving operators validates that they are in WAITING status.
     */
    @Test
    public void givenEmployeeListWhenSupervisorsWaitingThenListHas5Items() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.SUPERVISOR, EmployeeStatus.WAITING);
        assertThat(employeeList).hasSize(5);
    }

    /**
     * Given Employee List
     * When retrieving operators validates that they are in WAITING status.
     */
    @Test
    public void givenEmployeeListWhenDirectorsWaitingThenListHas5Items() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.DIRECTOR, EmployeeStatus.WAITING);
        assertThat(employeeList).hasSize(5);
    }

    /**
     * Given Employee List
     * When retrieving operators validates that they are in WAITING status.
     */
    @Test
    public void givenEmployeeListWhenOperatorsAttendingThenListHas0Items() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.OPERATOR, EmployeeStatus.ATTENDING);
        assertThat(employeeList).hasSize(0);
    }

    /**
     * Given Employee List
     * When retrieving operators validates that they are in WAITING status.
     */
    @Test
    public void givenEmployeeListWhenSupervisorsAttendingThenListHas0Items() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.SUPERVISOR, EmployeeStatus.ATTENDING);
        assertThat(employeeList).hasSize(0);
    }

    /**
     * Given Employee List
     * When retrieving operators validates that they are in WAITING status.
     */
    @Test
    public void givenEmployeeListWhenDirectorsAttendingThenListHas0Items() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.DIRECTOR, EmployeeStatus.ATTENDING);
        assertThat(employeeList).hasSize(0);
    }

    /**
     * Given Employee List
     * When there are 2 operators attending then list has 2 items.
     */
    @Test
    public void givenEmployeeListWhen2OperatorsThenListHas2Items() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.OPERATOR);
        Employee firstItem = employeeList.get(0);
        Employee secondItem = employeeList.get(1);
        firstItem.setEmployeeStatus(EmployeeStatus.ATTENDING);
        secondItem.setEmployeeStatus(EmployeeStatus.ATTENDING);

        List<Employee> employeeAttendingList = employeeService.retrieveAll(EmployeeType.OPERATOR, EmployeeStatus.ATTENDING);
        int employeeListSize = employeeAttendingList.size();
        firstItem.setEmployeeStatus(EmployeeStatus.WAITING);
        secondItem.setEmployeeStatus(EmployeeStatus.WAITING);

        assertThat(employeeListSize).isEqualTo(2);
    }

    /**
     * Given Employee List
     * When there are 2 supervisors attending then list has 2 items.
     */
    @Test
    public void givenEmployeeListWhen2SupervisorsThenListHas2Items() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.SUPERVISOR);
        Employee firstItem = employeeList.get(0);
        Employee secondItem = employeeList.get(1);
        firstItem.setEmployeeStatus(EmployeeStatus.ATTENDING);
        secondItem.setEmployeeStatus(EmployeeStatus.ATTENDING);

        List<Employee> employeeAttendingList = employeeService.retrieveAll(EmployeeType.SUPERVISOR, EmployeeStatus.ATTENDING);
        int employeeListSize = employeeAttendingList.size();
        firstItem.setEmployeeStatus(EmployeeStatus.WAITING);
        secondItem.setEmployeeStatus(EmployeeStatus.WAITING);

        assertThat(employeeListSize).isEqualTo(2);
    }

    /**
     * Given Employee List
     * When there are 2 directors attending then list has 2 items.
     */
    @Test
    public void givenEmployeeListWhen2DirectorsThenListHas2Items() {
        List<Employee> employeeList = employeeService.retrieveAll(EmployeeType.DIRECTOR);
        Employee firstItem = employeeList.get(0);
        Employee secondItem = employeeList.get(1);
        firstItem.setEmployeeStatus(EmployeeStatus.ATTENDING);
        secondItem.setEmployeeStatus(EmployeeStatus.ATTENDING);

        List<Employee> employeeAttendingList = employeeService.retrieveAll(EmployeeType.DIRECTOR, EmployeeStatus.ATTENDING);
        int employeeListSize = employeeAttendingList.size();
        firstItem.setEmployeeStatus(EmployeeStatus.WAITING);
        secondItem.setEmployeeStatus(EmployeeStatus.WAITING);

        assertThat(employeeListSize).isEqualTo(2);
    }

}