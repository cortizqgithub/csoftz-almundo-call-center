/*----------------------------------------------------------------------------*/
/* Source File:   CALLTASK.JAVA                                               */
/* Description:   Runnable task to simulate concurrent call execution.        */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.03/2018                                                 */
/* Last Modified: May.03/2018                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2018 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.02/2018  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.almundo.call.center.concurrent;

import com.csoftz.almundo.call.center.common.EmployeeStatus;
import com.csoftz.almundo.call.center.domain.IncomingCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Runnable task to simulate concurrent call execution.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.03/2018
 * @since 1.8 (JDK), May.03/2018
 */

public class CallTask implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(CallTask.class);
    private static final Integer MIN_TIME = 5000;
    private static final Integer MAX_TIME = 10000;

    private IncomingCall incomingCall;
    private Integer duration;

    /**
     * Constructor with parameters
     *
     * @param incomingCall All needed information for incoming call.
     *                     After duration is exhausted the Employee set in the IncomingCall is set to WAITING
     */
    public CallTask(IncomingCall incomingCall) {
        this.incomingCall = incomingCall;
        this.duration = assignDurationForCall();
    }

    /**
     * Used to simulate attention to an incoming phone call.
     */
    @Override
    public void run() {
        try {
            log.info("[{}] Attending call with phoneNumber (LEFT)", incomingCall.getPhoneNumber());
            log.info("[{}] Employee attending=[{}]", incomingCall.getPhoneNumber(), incomingCall.getAttendingEmployee());
            log.info("[{}] Duration for call=[{}]", incomingCall.getPhoneNumber(), duration);

            Thread.currentThread().sleep(duration);

            // For some reason the next lines never get executed after Thread.sleep.
            incomingCall.getAttendingEmployee().setEmployeeStatus(EmployeeStatus.WAITING);
            log.info("[{}] Phone call ended", incomingCall.getPhoneNumber());
            // End For some reason...
        } catch (InterruptedException e) {
            log.info("[{}] InterruptedException Message=[{}]", incomingCall.getPhoneNumber(), e.getMessage());
            log.info("[{}] InterruptedException Cause=[{}]", incomingCall.getPhoneNumber(), e.getCause());
        }
    }

    /**
     * Get a number of milliseconds between 5 and 10 seconds to simulate a call for that time.
     *
     * @return The duration for incoming call.
     */
    private Integer assignDurationForCall() {
        final Random random = new Random();
        final Integer baseTime = MAX_TIME - MIN_TIME;
        return random.nextInt(baseTime) + MIN_TIME;
    }
}
