/*----------------------------------------------------------------------------*/
/* Source File:   CALLCENTERSERVICETESTS.JAVA                                 */
/* Description:   Call Center Service tests                                   */
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

package com.csoftz.almundo.call.center.service;

import com.csoftz.almundo.call.center.service.intr.CallCenterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Call Center Service tests
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.02/2018
 * @since 1.8 (JDK), May.02/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CallCenterServiceTests {
    @Autowired
    private CallCenterService callCenterService;

    @Test
    public void given1() {
        //callCenterService.receiveCall("123");
        callCenterService.dispatchCall("123");
    }
}
