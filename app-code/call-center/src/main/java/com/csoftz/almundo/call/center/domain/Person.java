/*----------------------------------------------------------------------------*/
/* Source File:   PERSON.JAVA                                                 */
/* Description:   Represents a Person abstraction                             */
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
package com.csoftz.almundo.call.center.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Represents a Person abstraction
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.02/2018
 * @since 1.8 (JDK), May.02/2018
 */
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Person extends DomainBase {
    private String id;
    private String firstName;
    private String lastName;

    /**
     * Internal constructor for Builder Annotations to to properly work.
     *
     * @param id           Record identification
     * @param firstName    Start of name
     * @param lastName     Sets the surname part o a name
     * @param creationDate When record was created
     * @param updateDate   When record is updted
     * @param user         Who made the change.
     */
    protected Person(String id, String firstName, String lastName,
                     LocalDateTime creationDate,
                     LocalDateTime updateDate,
                     String user) {
        super(creationDate, updateDate, user);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
