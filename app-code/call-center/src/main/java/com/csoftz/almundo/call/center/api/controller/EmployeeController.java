/*----------------------------------------------------------------------------*/
/* Source File:   EMPLOYEECONTROLLER.JAVA                                     */
/* Description:   Rest API Employee Controller                                */
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
package com.csoftz.almundo.call.center.api.controller;

import com.csoftz.almundo.call.center.domain.Employee;
import com.csoftz.almundo.call.center.service.intr.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest API Employee Controller
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.03/2018
 * @since 1.8 (JDK), May.02/2018
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeService employeeService;

    /**
     * Constructor with parameters.
     *
     * @param employeeService Injects the service for employee management.
     */
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * REST API Get entry point to gather all registered employees.
     * GET: /api/v1/employee/all
     *
     * @return List of employees set (in-memory storate) in system.
     */
    @GetMapping("/all")
    public List<Employee> getAll() {
        log.debug("Calling getAll()");
        return employeeService.retrieveAll();
    }
}
