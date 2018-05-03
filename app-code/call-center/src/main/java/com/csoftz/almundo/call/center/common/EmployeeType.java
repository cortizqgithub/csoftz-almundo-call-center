/*----------------------------------------------------------------------------*/
/* Source File:   EMPLOYEETYPE.JAVA                                           */
/* Description:   Designate employee kind                                     */
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
 * Designate employee kind
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.02/2018
 * @since 1.8 (JDK), May.02/2018
 */
public enum EmployeeType {
    OPERATOR,   /* Denotes user is an operator in system. */
    SUPERVISOR, /* Denotes user is a supervisor in system. */
    DIRECTOR    /* Denotes user is a director in system. */
}
