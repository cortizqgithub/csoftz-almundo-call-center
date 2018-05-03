/*----------------------------------------------------------------------------*/
/* Source File:   CALLCENTERDISPATCHERSERVICEIMPL.JAVA                        */
/* Description:   Implementation for handling call center duties.             */
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

import com.csoftz.almundo.call.center.service.intr.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * Implementation for handling call center duties.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.02/2018
 * @since 1.8 (JDK), May.02/2018
 */
@Service
public class CallCenterDispatcherServiceImpl {
    private EmployeeService employeeService;

    /**
     * Constructor with parameters
     *
     * @param employeeService Injects the service for employee management.
     */
    public CallCenterDispatcherServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
