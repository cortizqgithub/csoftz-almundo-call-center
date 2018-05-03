/*----------------------------------------------------------------------------*/
/* Source File:   INCOMINGCALL.JAVA                                           */
/* Description:   Describes the serveral status an incoming call can have.    */
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

package com.csoftz.almundo.call.center.domain;

import com.csoftz.almundo.call.center.common.IncomingCallStatus;
import lombok.Builder;
import lombok.Data;

/**
 * Describes the serveral status an incoming call can have.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.02/2018
 * @since 1.8 (JDK), May.02/2018
 */
@Data
public class IncomingCall {
    private String phoneNumber;
    private IncomingCallStatus incomingCallStatus;
    private Employee attendingEmployee;

    /**
     * Internal constructor to use in Builder itself.
     *
     * @param phoneNumber
     * @param incomingCallStatus
     * @param attendingEmployee
     */
    @Builder
    private IncomingCall(String phoneNumber, IncomingCallStatus incomingCallStatus, Employee attendingEmployee) {
        this.phoneNumber = phoneNumber;
        this.incomingCallStatus = incomingCallStatus;
        this.attendingEmployee = attendingEmployee;
    }
}
