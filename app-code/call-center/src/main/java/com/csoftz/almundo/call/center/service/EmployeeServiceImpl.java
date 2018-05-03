/*----------------------------------------------------------------------------*/
/* Source File:   EMPLOYEESERVICEIMPL.JAVA                                    */
/* Description:   Implementation for service for handling employees.          */
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

import com.csoftz.almundo.call.center.common.EmployeeListHelper;
import com.csoftz.almundo.call.center.common.EmployeeStatus;
import com.csoftz.almundo.call.center.common.EmployeeType;
import com.csoftz.almundo.call.center.domain.Employee;
import com.csoftz.almundo.call.center.service.intr.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Implementation for service for handling employees.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.02/2018
 * @since 1.8 (JDK), May.02/2018
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private List<Employee> employeeList;

    /**
     * Default constructor.
     */
    public EmployeeServiceImpl() {
        this.employeeList = new EmployeeListHelper().build();
    }

    /**
     * @see EmployeeService#retrieveAll()
     */
    @Override
    public List<Employee> retrieveAll() {
        log.debug("Call retrieveAll no params");
        return this.employeeList;
    }

    /**
     * @See EmployeeService#retrieveAll(EmployeeType)
     */
    @Override
    public List<Employee> retrieveAll(EmployeeType employeeType) {
        log.debug("Call retrieveAll(EmployeeType)");
        log.debug("Parameter EmployeeType=[{}]", employeeType.name());

        Predicate<Employee> employeePredicate = null;
        Predicate<Employee> employeeOperatorPredicate = e -> e.getEmployeeType() == EmployeeType.OPERATOR;
        Predicate<Employee> employeeSupervisorPredicate = e -> e.getEmployeeType() == EmployeeType.SUPERVISOR;
        Predicate<Employee> employeeDirectorPredicate = e -> e.getEmployeeType() == EmployeeType.DIRECTOR;

        switch (employeeType) {
            case OPERATOR:
                employeePredicate = employeeOperatorPredicate;
                break;
            case SUPERVISOR:
                employeePredicate = employeeSupervisorPredicate;
                break;
            case DIRECTOR:
                employeePredicate = employeeDirectorPredicate;
                break;
        }
        return employeeList.stream().
            filter(employeePredicate).
            collect(Collectors.toList());
    }

    /**
     * @see EmployeeService#retrieveAll(EmployeeType, EmployeeStatus)
     */
    @Override
    public List<Employee> retrieveAll(EmployeeType employeeType, EmployeeStatus employeeStatus) {
        log.debug("Call retrieveAll(EmployeeType, EmployeeStatus)");
        log.debug("Parameters EmployeeType=[{}], EmployeeStatus=[{}]", employeeType.name(), employeeStatus.name());
        return employeeList.stream().
            filter(e -> e.getEmployeeType() == employeeType && e.getEmployeeStatus() == employeeStatus).
            collect(Collectors.toList());
    }
}
