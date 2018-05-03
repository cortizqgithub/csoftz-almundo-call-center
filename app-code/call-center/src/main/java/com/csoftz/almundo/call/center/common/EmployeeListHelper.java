/*----------------------------------------------------------------------------*/
/* Source File:   EMPLOYEELISTHELPER.JAVA                                     */
/* Description:   Helper to build a list in memory and statically for         */
/*                employees.                                                  */
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
package com.csoftz.almundo.call.center.common;

import com.csoftz.almundo.call.center.domain.Employee;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper to build a list in memory and statically for employees.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.02/2018
 * @since 1.8 (JDK), May.02/2018
 */
public class EmployeeListHelper {

    /**
     * Constructs a list of employees for testing and execution purposes.
     *
     * @return List of employees set.
     */
    public List<Employee> build() {
        List<Employee> employeeList = new ArrayList<>();

        // OPERATORS
        employeeList.add(Employee.builder().id("OP1").
            firstName("OP").lastName("One").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.OPERATOR).employeeStatus(EmployeeStatus.WAITING).
            build());
        employeeList.add(Employee.builder().id("OP2").
            firstName("OP").lastName("Two").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.OPERATOR).employeeStatus(EmployeeStatus.WAITING).
            build());
        employeeList.add(Employee.builder().id("OP3").
            firstName("OP").lastName("Three").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.OPERATOR).employeeStatus(EmployeeStatus.WAITING).
            build());
        employeeList.add(Employee.builder().id("OP4").
            firstName("OP").lastName("Four").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.OPERATOR).employeeStatus(EmployeeStatus.WAITING).
            build());
        employeeList.add(Employee.builder().id("OP5").
            firstName("OP").lastName("Five").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.OPERATOR).employeeStatus(EmployeeStatus.WAITING).
            build());

        // SUPERVISORS
        employeeList.add(Employee.builder().id("SP1").
            firstName("SP").lastName("One").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.SUPERVISOR).employeeStatus(EmployeeStatus.WAITING).
            build());
        employeeList.add(Employee.builder().id("SP2").
            firstName("SP").lastName("Two").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.SUPERVISOR).employeeStatus(EmployeeStatus.WAITING).
            build());
        employeeList.add(Employee.builder().id("SP3").
            firstName("SP").lastName("Three").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.SUPERVISOR).employeeStatus(EmployeeStatus.WAITING).
            build());
        employeeList.add(Employee.builder().id("SP4").
            firstName("SP").lastName("Four").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.SUPERVISOR).employeeStatus(EmployeeStatus.WAITING).
            build());
        employeeList.add(Employee.builder().id("SP5").
            firstName("SP").lastName("Five").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.SUPERVISOR).employeeStatus(EmployeeStatus.WAITING).
            build());

        // DIRECTORS
        employeeList.add(Employee.builder().id("DT1").
            firstName("DT").lastName("One").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.DIRECTOR).employeeStatus(EmployeeStatus.WAITING).
            build());
        employeeList.add(Employee.builder().id("DT2").
            firstName("DT").lastName("Two").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.DIRECTOR).employeeStatus(EmployeeStatus.WAITING).
            build());
        employeeList.add(Employee.builder().id("DT3").
            firstName("DT").lastName("Three").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.DIRECTOR).employeeStatus(EmployeeStatus.WAITING).
            build());
        employeeList.add(Employee.builder().id("DT4").
            firstName("DT").lastName("Four").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.DIRECTOR).employeeStatus(EmployeeStatus.WAITING).
            build());
        employeeList.add(Employee.builder().id("DT5").
            firstName("DT").lastName("Five").
            creationDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).
            user("COQ").employeeType(EmployeeType.DIRECTOR).employeeStatus(EmployeeStatus.WAITING).
            build());
        return employeeList;
    }
}
