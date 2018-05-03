/*----------------------------------------------------------------------------*/
/* Source File:   CALLCENTERCONTROLLER.JAVA                                   */
/* Description:   REST API Call Center Controller.                            */
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

import com.csoftz.almundo.call.center.domain.IncomingCall;
import com.csoftz.almundo.call.center.service.intr.CallCenterDispatcherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * REST API Call Center Controller.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.03/2018
 * @since 1.8 (JDK), May.03/2018
 */
@RestController
@RequestMapping("/api/v1/call-center")
public class CallCenterController {
    private CallCenterDispatcherService callCenterDispatcherService;

    /**
     * Constructor with parameters.
     *
     * @param callCenterDispatcherService Injects the call center dispatcher service.
     */
    public CallCenterController(CallCenterDispatcherService callCenterDispatcherService) {
        this.callCenterDispatcherService = callCenterDispatcherService;
    }

    /**
     * REST API Get entry point to make a phone call with a given phone number.
     * GET: /api/v1/call-center/make/call/{phoneNumber}
     *
     * @param phoneNumber Sets the phone number for incoming call being attended.
     * @return A register detailing the phone call processing status.
     */
    @GetMapping("/make/call/{phoneNumber}")
    public IncomingCall makeCall(@PathVariable String phoneNumber) {
        return callCenterDispatcherService.dispatchCall(phoneNumber);
    }

    /**
     * REST API Get entry point to simulate multiple phone calls
     * GET: /api/v1/call-center/simulate/multiple/calls/{times}
     *
     * @param times Number of phone calls to handle.
     * @return A list of phone call processing status.
     */
    @GetMapping("/simulate/multiple/calls/{times}")
    public List<IncomingCall> simulateMultipleCalls(@PathVariable Integer times) {
        List<IncomingCall> incomingCallList = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            String phoneNumber = "5743" + Integer.valueOf(i).toString();
            incomingCallList.add(callCenterDispatcherService.dispatchCall(phoneNumber));
        }
        return incomingCallList;
    }
}
