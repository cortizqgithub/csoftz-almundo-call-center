/*----------------------------------------------------------------------------*/
/* Source File:   EMPLOYEECONTROLLERTESTS.JAVA                                */
/* Description:   Tests for EmployeeController                                */
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
package com.csoftz.almundo.call.center.api.controller;

import com.csoftz.almundo.call.center.common.EmployeeStatus;
import com.csoftz.almundo.call.center.common.EmployeeType;
import com.csoftz.almundo.call.center.service.intr.EmployeeService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for EmployeeController
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.02/2018
 * @since 1.8 (JDK), May.02/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTests {
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
     * Given Employee Controller when invoked returns valid JSON information.
     *
     * @throws Exception
     */
    @Test
    public void givenEmployeeApiControllerReturnsEmployeeList() throws Exception {
        mockMvc.perform(get("/api/v1/employee/all")).andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$").value(Matchers.hasSize(15)))
            .andExpect(jsonPath("$[0].user").value("COQ"))
            .andExpect(jsonPath("$[0].id").value("OP1"))
            .andExpect(jsonPath("$[0].firstName").value("OP"))
            .andExpect(jsonPath("$[0].lastName").value("One"))
            .andExpect(jsonPath("$[0].employeeStatus").value(EmployeeStatus.WAITING.name()))
            .andExpect(jsonPath("$[0].employeeType").value(EmployeeType.OPERATOR.name()))
            .andExpect(jsonPath("$[0].user").value("COQ"))
            .andExpect(jsonPath("$[5].id").value("SP1"))
            .andExpect(jsonPath("$[5].firstName").value("SP"))
            .andExpect(jsonPath("$[5].lastName").value("One"))
            .andExpect(jsonPath("$[5].employeeStatus").value(EmployeeStatus.WAITING.name()))
            .andExpect(jsonPath("$[5].employeeType").value(EmployeeType.SUPERVISOR.name()))
            .andExpect(jsonPath("$[10].user").value("COQ"))
            .andExpect(jsonPath("$[10].id").value("DT1"))
            .andExpect(jsonPath("$[10].firstName").value("DT"))
            .andExpect(jsonPath("$[10].lastName").value("One"))
            .andExpect(jsonPath("$[10].employeeStatus").value(EmployeeStatus.WAITING.name()))
            .andExpect(jsonPath("$[10].employeeType").value(EmployeeType.DIRECTOR.name()));
    }
}
