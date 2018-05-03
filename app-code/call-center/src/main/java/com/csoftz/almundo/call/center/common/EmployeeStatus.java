/*----------------------------------------------------------------------------*/
/* Source File:   EMPLOYEESTATUS.JAVA                                         */
/* Description:   Describes the status of an employee when attending an       */
/*                icoming call.                                               */
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

/**
 * Describes the status of an employee when attending an icoming call.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.02/2018
 * @since 1.8 (JDK), May.02/2018
 */
public enum EmployeeStatus {
    WAITING,  /* Employee is waiting to receive an incoming call. */
    ATTENDING /* Employee is attending an incoming call. */
}
