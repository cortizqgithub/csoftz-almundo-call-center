/*----------------------------------------------------------------------------*/
/* Source File:   EMPLOYEESERVICE.JAVA                                        */
/* Description:   Interface for handling employees.                           */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.02/2018                                                 */
/* Last Modified: May.03/2018                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2018 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.02/2018  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.almundo.call.center.service.intr;

import com.csoftz.almundo.call.center.common.EmployeeStatus;
import com.csoftz.almundo.call.center.common.EmployeeType;
import com.csoftz.almundo.call.center.domain.Employee;

import java.util.List;

/**
 * Interface for handling employees.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.03/2018
 * @since 1.8 (JDK), May.02/2018
 */
public interface EmployeeService {
    /**
     * Retrieves a list of employees.
     *
     * @return List of employees.
     */
    List<Employee> retrieveAll();

    /**
     * Retrieves a list of employees of given employee type.
     *
     * @param employeeType Kind of employee to retrieve.
     * @return List of requested employee type, one of OPERATOR, SUPERVISOR or DIRECTOR
     */
    List<Employee> retrieveAll(EmployeeType employeeType);

    /**
     * Retrieves a list of employees given below filters
     *
     * @param employeeType   Kind of employee to look for
     * @param employeeStatus Ealuates an status for employee.
     * @return List of filtered employees with such criteria.
     */
    List<Employee> retrieveAll(EmployeeType employeeType, EmployeeStatus employeeStatus);

    /**
     * Retrieves one of the available employees to attend a incoming call.
     * Rules are as follows, it will pick one of the available OPERATORS, and
     * if none is available then it will pick one of the available SUPERVISORS,
     * and if none is available then it will pick one of the available DIRECTORS.
     *
     * @return NULL if there are not employees to attend and incoming call
     * otherwise it will return an employee.
     */
    Employee retrieveAvailable();
}
