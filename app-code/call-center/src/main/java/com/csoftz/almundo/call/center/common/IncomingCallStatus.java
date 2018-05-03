/*----------------------------------------------------------------------------*/
/* Source File:   INCOMINGCALLSTATUS.JAVA                                     */
/* Description:   Describes the various status an incoming call can have.     */
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
 * Describes the various status an incoming call can have.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.02/2018
 * @since 1.8 (JDK), May.02/2018
 */
public enum IncomingCallStatus {
    IN_PROGRESS, /* Indicates the incoming call is being attended. */
    CANCELLED,   /*  Indicates the incoming call is broken. */
    ENDED        /* Indicates the incoming call is done. */
}