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

import com.csoftz.almundo.call.center.domain.IncomingCall;
import com.csoftz.almundo.call.center.service.intr.CallCenterDispatcherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.csoftz.almundo.call.center.common.consts.GlobalConstants.CALL_CENTER_DISPATCHER_CALL_IN_PROGRESS;
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
     * Then return message that call is being attended.
     */
    @Test
    public void givenPhoneNumberWhenNumberIsNotEmptyThenCallIsBeingAttended() {
        String phoneNumber = "355647886125";
        IncomingCall rslt = callCenterService.dispatchCall(phoneNumber);
        assertThat(rslt.getStatusMsg()).isEqualTo(CALL_CENTER_DISPATCHER_CALL_IN_PROGRESS);
    }
}
