/*----------------------------------------------------------------------------*/
/* Source File:   CALLCENTERDISPATCHERSERVICEIMPL.JAVA                        */
/* Description:   Implementation for handling call center duties.             */
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
package com.csoftz.almundo.call.center.service;

import com.csoftz.almundo.call.center.common.IncomingCallStatus;
import com.csoftz.almundo.call.center.domain.IncomingCall;
import com.csoftz.almundo.call.center.service.intr.CallCenterDispatcherService;
import com.csoftz.almundo.call.center.service.intr.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.csoftz.almundo.call.center.common.consts.GlobalConstants.CALL_CENTER_DISPATCHER_CALL_IN_PROGRESS;
import static com.csoftz.almundo.call.center.common.consts.GlobalConstants.CALL_CENTER_DISPATCHER_NULL_PHONE_NUM_SUPLLIED;

/**
 * Implementation for handling call center duties.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.03/2018
 * @since 1.8 (JDK), May.02/2018
 */
@Service
public class CallCenterDispatcherServiceImpl implements CallCenterDispatcherService {
    private static final Logger log = LoggerFactory.getLogger(CallCenterDispatcherServiceImpl.class);
    private EmployeeService employeeService;

    /**
     * Constructor with parameters
     *
     * @param employeeService Injects the service for employee management.
     */
    public CallCenterDispatcherServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public IncomingCall dispatchCall(String phoneNumber) {
        log.debug("Calling dispatchCall()");

        IncomingCall incomingCall = IncomingCall.builder().phoneNumber(phoneNumber).build();

        if (phoneNumber == null || phoneNumber.isEmpty()) {
            log.info("Invalid phoneNumber parameter found");
            incomingCall.setStatusMsg(CALL_CENTER_DISPATCHER_NULL_PHONE_NUM_SUPLLIED);
        } else {
            incomingCall.setIncomingCallStatus(IncomingCallStatus.IN_PROGRESS);
            incomingCall.setStatusMsg(CALL_CENTER_DISPATCHER_CALL_IN_PROGRESS);
            incomingCall.setAttendingEmployee(this.employeeService.retrieveAvailable());
            log.info("Dispatching call with phoneNumber=[{}]", phoneNumber);
        }
        log.debug("IncomingCall data is set to [{}]", incomingCall);
        return incomingCall;
    }
}
