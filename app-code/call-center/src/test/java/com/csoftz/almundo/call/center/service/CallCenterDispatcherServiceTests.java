/*----------------------------------------------------------------------------*/
/* Source File:   CALLCENTERDISTPATCHERSERVICETESTS.JAVA                      */
/* Description:   Call Center Service tests                                   */
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

import com.csoftz.almundo.call.center.common.EmployeeStatus;
import com.csoftz.almundo.call.center.common.EmployeeType;
import com.csoftz.almundo.call.center.common.IncomingCallStatus;
import com.csoftz.almundo.call.center.domain.Employee;
import com.csoftz.almundo.call.center.domain.IncomingCall;
import com.csoftz.almundo.call.center.service.intr.CallCenterDispatcherService;
import com.csoftz.almundo.call.center.service.intr.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.csoftz.almundo.call.center.common.consts.GlobalConstants.CALL_CENTER_DISPATCHER_CALL_IN_PROGRESS;
import static com.csoftz.almundo.call.center.common.consts.GlobalConstants.CALL_CENTER_DISPATCHER_CALL_REJECTED;
import static com.csoftz.almundo.call.center.common.consts.GlobalConstants.CALL_CENTER_DISPATCHER_NULL_PHONE_NUM_SUPLLIED;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Call Center Service tests
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.03/2018
 * @since 1.8 (JDK), May.02/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CallCenterDispatcherServiceTests {
    @Autowired
    private CallCenterDispatcherService callCenterService;

    @Autowired
    private EmployeeService employeeService;

    /**
     * Given Phone Number
     * When supplied phone number is null
     * Then return an error message.
     */
    @Test
    public void givenPhoneNumberWhenNumberIsNullThenError() {
        String phoneNumber = null;
        IncomingCall rslt = callCenterService.dispatchCall(phoneNumber);
        assertThat(rslt.getStatusMsg()).isEqualTo(CALL_CENTER_DISPATCHER_NULL_PHONE_NUM_SUPLLIED);
    }

    /**
     * Given Phone Number
     * When supplied phone number is Empty
     * Then return an error message.
     */
    @Test
    public void givenPhoneNumberWhenNumberIsEmptyThenError() {
        String phoneNumber = "";
        IncomingCall rslt = callCenterService.dispatchCall(phoneNumber);
        assertThat(rslt.getStatusMsg()).isEqualTo(CALL_CENTER_DISPATCHER_NULL_PHONE_NUM_SUPLLIED);
    }

    /**
     * Given Phone Number
     * When supplied phone number is not Empty
     * Then return message that call is being attended and other data.
     */
    @Test
    public void givenPhoneNumberWhenNumberIsNotEmptyThenCallIsBeingAttended() {
        String phoneNumber = "355647886125";
        IncomingCall rslt = callCenterService.dispatchCall(phoneNumber);
        assertThat(rslt.getPhoneNumber()).isEqualTo(phoneNumber);
        assertThat(rslt.getIncomingCallStatus()).isEqualTo(IncomingCallStatus.IN_PROGRESS);
        assertThat(rslt.getAttendingEmployee()).isNotNull();
        assertThat(rslt.getAttendingEmployee().getEmployeeType()).isEqualTo(EmployeeType.OPERATOR);
        assertThat(rslt.getStatusMsg()).isEqualTo(CALL_CENTER_DISPATCHER_CALL_IN_PROGRESS);
    }

    @Test
    public void givenPhoneNumberWhenAllEmployeesAttendingThenAttendingEmpl() {
        String phoneNumber = "355647886126";
        List<Employee> employeeList = employeeService.retrieveAll();
        employeeList.forEach(e -> e.setEmployeeStatus(EmployeeStatus.ATTENDING));
        IncomingCall rslt = callCenterService.dispatchCall(phoneNumber);
        employeeList.forEach(e -> e.setEmployeeStatus(EmployeeStatus.WAITING));

        assertThat(rslt.getPhoneNumber()).isEqualTo(phoneNumber);
        assertThat(rslt.getIncomingCallStatus()).isEqualTo(IncomingCallStatus.CANCELLED);
        assertThat(rslt.getAttendingEmployee()).isNull();
        assertThat(rslt.getStatusMsg()).isEqualTo(CALL_CENTER_DISPATCHER_CALL_REJECTED);
    }
}
