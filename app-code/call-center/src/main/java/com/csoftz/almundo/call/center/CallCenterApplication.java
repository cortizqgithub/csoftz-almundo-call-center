/*----------------------------------------------------------------------------*/
/* Source File:   CALLCENTERAPPLICATION.JAVA                                  */
/* Description:   Spring Boot Call Center entry point for application         */
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
package com.csoftz.almundo.call.center;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Call Center entry point for application
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.02/2018
 * @since 1.8 (JDK), May.02/2018
 */
@SpringBootApplication
public class CallCenterApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(CallCenterApplication.class);

    /**
     * Application main entry point
     *
     * @param args Command line arguments passed for application.
     */
    public static void main(String[] args) {
        SpringApplication.run(CallCenterApplication.class, args);
    }

    /**
     * Execute the command line runner task.
     *
     * @param args Command line arguments.
     * @throws Exception Captures any exception when executiong.
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("Call Center Dispatcher App V1.0.0 RELEASE May.03/2018");
    }
}
