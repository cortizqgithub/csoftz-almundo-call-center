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
import com.csoftz.almundo.call.center.concurrent.CallTask;
import com.csoftz.almundo.call.center.domain.Employee;
import com.csoftz.almundo.call.center.domain.IncomingCall;
import com.csoftz.almundo.call.center.service.intr.CallCenterDispatcherService;
import com.csoftz.almundo.call.center.service.intr.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.csoftz.almundo.call.center.common.consts.GlobalConstants.CALL_CENTER_DISPATCHER_CALL_IN_PROGRESS;
import static com.csoftz.almundo.call.center.common.consts.GlobalConstants.CALL_CENTER_DISPATCHER_CALL_REJECTED;
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
    private static final int POOL_SIZE = 10;
    private static final int KEEP_ALIVE = 30;
    private static final int DELAY = 10000;
    private static final int RETRY_NUMBER = 3;
    private EmployeeService employeeService;
    private ThreadPoolExecutor executor;

    /**
     * The blocking queue.
     */
    private BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(10);

    /**
     * Constructor with parameters
     *
     * @param employeeService Injects the service for employee management.
     */
    public CallCenterDispatcherServiceImpl(EmployeeService employeeService) {
        executor = new ThreadPoolExecutor(POOL_SIZE, POOL_SIZE, KEEP_ALIVE, TimeUnit.SECONDS, blockingQueue);
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
            Employee employee = this.employeeService.retrieveAvailable();
            if (employee == null) {
                incomingCall.setIncomingCallStatus(IncomingCallStatus.CANCELLED);
                incomingCall.setStatusMsg(CALL_CENTER_DISPATCHER_CALL_REJECTED);

            } else {
                incomingCall.setIncomingCallStatus(IncomingCallStatus.IN_PROGRESS);
                incomingCall.setStatusMsg(CALL_CENTER_DISPATCHER_CALL_IN_PROGRESS);
            }
            incomingCall.setAttendingEmployee(employee);
            log.info("Dispatching call with phoneNumber=[{}]", incomingCall.getPhoneNumber());
            CallTask callTask = new CallTask(incomingCall);
            executor.execute(callTask);
        }
        log.debug("IncomingCall data is set to [{}]", incomingCall);
        return incomingCall;
    }
}
