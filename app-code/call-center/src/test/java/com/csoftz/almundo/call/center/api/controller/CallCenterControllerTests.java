/*----------------------------------------------------------------------------*/
/* Source File:   CALLCENTERCONTROLLERTESTS.JAVA                              */
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

import com.csoftz.almundo.call.center.common.EmployeeStatus;
import com.csoftz.almundo.call.center.common.EmployeeType;
import com.csoftz.almundo.call.center.common.IncomingCallStatus;
import com.csoftz.almundo.call.center.service.intr.EmployeeService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for CallCenterController
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.02/2018
 * @since 1.8 (JDK), May.03/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CallCenterControllerTests {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Autowired
    private EmployeeService employeeService;

    /**
     * Configure all tests initial settings.
     */
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        // The following is to ensure that employee list gets an initial value.
        this.employeeService.retrieveAll().stream().forEach(e -> e.setEmployeeStatus(EmployeeStatus.WAITING));
    }

    /**
     * Given Call Center Controller when invoked returns valid JSON information.
     *
     * @throws Exception
     */
    @Test
    public void givenCallCenterApiControllerReturnsIncomingCall() throws Exception {
        mockMvc.perform(get("/api/v1/call-center//make/call/123456")).andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.phoneNumber").value("123456"))
            .andExpect(jsonPath("$.incomingCallStatus").value(IncomingCallStatus.IN_PROGRESS.name()))
            .andExpect(jsonPath("$.attendingEmployee.id").value("OP1"))
            .andExpect(jsonPath("$.attendingEmployee.firstName").value("OP"))
            .andExpect(jsonPath("$.attendingEmployee..lastName").value("One"))
            .andExpect(jsonPath("$.attendingEmployee.employeeStatus").value(EmployeeStatus.ATTENDING.name()))
            .andExpect(jsonPath("$.attendingEmployee.employeeType").value(EmployeeType.OPERATOR.name()))
            .andExpect(jsonPath("$.attendingEmployee.user").value("COQ"));
    }

    /**
     * Given Call Center Controller when invoked returns valid JSON information.
     *
     * @throws Exception
     */
    @Test
    public void givenCallCenterApiControllerReturnsIncomingCallList() throws Exception {
        mockMvc.perform(get("/api/v1/call-center/simulate/multiple/calls/10")).andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$").value(Matchers.hasSize(10)))
            .andExpect(jsonPath("$[0].phoneNumber").value("57430"))
            .andExpect(jsonPath("$[0].incomingCallStatus").value(IncomingCallStatus.IN_PROGRESS.name()))
            .andExpect(jsonPath("$[0].attendingEmployee.id").value("OP1"))
            .andExpect(jsonPath("$[0].attendingEmployee.firstName").value("OP"))
            .andExpect(jsonPath("$[0].attendingEmployee.lastName").value("One"))
            .andExpect(jsonPath("$[0].attendingEmployee.employeeStatus").value(EmployeeStatus.ATTENDING.name()))
            .andExpect(jsonPath("$[0].attendingEmployee.employeeType").value(EmployeeType.OPERATOR.name()))
            .andExpect(jsonPath("$[0].attendingEmployee.user").value("COQ"));
    }
}
